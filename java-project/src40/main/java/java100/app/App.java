//: ## ver 40
//: - DAO의 메서드가 호출될 때마다 Connection 객체를 생성하는 문제점 해결
//: - 학습목표
//:   - DBMS와의 연결을 효과적으로 관리하는 방법을 이해한다.
//    - DB 커넥션풀 방식을 이해하고 구현할 수 있다.
//:   
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;

// 기존 방식의 문제점
// - DAO 객체의 각 메서드를 호출할 때마다 DBMS와 연결을 수행한다.
//   연결할 때마다 사용자 인증(authentication)과 권한 검사(authorization)를
//   수행하기 때문에 일정한 시간을 소요한다.
//
// 해결 방안 1:
// - DAO 객체를 생성할 때 DBMS에 연결을 수행한다.
// - SQL문을 실행할 때는 기존에 Connection 객체를 사용한다.
//   즉 SQL 문을 실행할 때마다 Connection을 수행하지 않는다.
// - XxxDao 클래스를 변경한다.
// - 문제점
//   1) DAO 당 1 개의 커넥션을 유지해야 한다.
//   2) 자주 사용되지 않는 DAO도 자신만의 커넥션 객체를 유지한다. 
//      즉 커넥션 객체가 낭비된다.
//
// 해결 방안 2:
// - App에서 Connection 객체를 1개 준비하고 DAO는 그 객체를 공유하여 사용한다.
// - 각각의 DAO가 자체 커넥션 객체를 유지할 필요가 없어서
//   커넥션이 낭비되는 문제를 해결할 수 있다.
// - 문제점
//   => SQL 작업을 수동으로 commit/rollback할 때 문제가 된다.
//   => commit()이나 rollback()은 Connection 객체에 대해 호출한다.
//   => 즉 그 커넥션으로 수행한 모든 작업들이 commit()/rollback()된다.
//   => 싱글 스레드에서 DAO를 사용하는 상황에서는 
//      순차적으로 SQL 작업이 이루어지기 때문에 문제가 되지 않는다.
//   => 멀티 스레드 상황에서는 동시에 여러 스레드에서
//      같은 커넥션을 가지고 SQL 작업을 수행할 때 문제가 된다.
//      여러 스레드 중에서 어느 하나가 commit()이나 rollback()을 하게되면
//      그 커넥션을 공유한 다른 스레드가 수행한 작업까지
//      모두가 commit()되고 rollback() 되는 치명적인 문제가 발생한다.
//   => 결론!
//      생성한 커넥션 객체는 사용 후에도 닫지 않고 재사용은 하지만,
//      스레드들이 한 커넥션 객체를 동시에 사용하지 않는다.
// 
// 해결 방안 3:
// - 그러면 다시 예전처럼 메서드가 호출될 때마다 커넥션 객체를 생성해야 하는가?
//   => 그러면 다시 속도가 느려질 것이다!
// - 그럼 커넥션 객체를 공유하지 않으면서 속도를 빠르게 할 방법이 없는가?
//   => DVD대여점에서 비디오를 대여하는 방법을 사용하라!
//   => DVD는 여러 고객이 공유할 수는 있지만,
//      단 사용할 때는 한 명의 고객만이 사용한다.
//      사용이 끝난 후에 다른 고객이 그 DVD를 사용할 수 있다.
//   => 이렇게 함으로써 각 고객은 단독으로 DVD를 사용하고,
//      사용이 끝나면 그 DVD를 다른 고객과 공유하기 때문에
//      고객 수 만큼 DVD를 장만하지 않아도 된다. 
// - 결론!
//   => Connection 객체를 빌려주는 클래스를 만든다.
//   => 각각의 DAO가 메서드를 실행할 때는 이 클래스를 통해 
//      커넥션을 빌려서 작업한다. 
//   => 작업이 끝난 후에는 다시 이 클래스에 커넥션을 반납한다.
//   => 이렇게 함으로써 한 번 생성된 커넥션을 계속 사용하기 때문에
//      매번 커넥션을 생성할 때 발생하는 실행 속도가 저하되는 문제를 해결한다.
//   => 또한 각 메서드가 자신만의 커넥션을 사용하기 때문에
//      멀티 스레드 상황에서 commit()/rollback() 할 때의 문제를 해결할 수 있다.
//   => 공유하기 때문에 매번 커넥션 객체를 만들지 않는다.
//      즉 가비지를 줄 일 수 있다.
// - 용어!
//   => 생성된 객체를 대여/반납을 통해 공유함으로써 
//      메모리를 절약하는 개발 방식을 "Flyweight" 디자인 패턴이라 한다.
//   => 여러 곳에서 사용되는 객체를 대여해주고 반납 받는 역할을 수행하는
//      클래스를 Pool이라 부른다.
//   => 그래서 Connection을 대여/반납해주는 클래스를 
//      "DB Connection Pool"이라 부른다.
//
public class App {

    ServerSocket ss;
    Scanner keyScan = new Scanner(System.in);

    // 이제 HashMap에 보관하는 값은 Controller 규칙을 준수한 객체이다.
    HashMap<String,Controller> controllerMap = 
            new HashMap<>();

    void init() {
        ScoreController scoreController = new ScoreController();
        scoreController.init();
        controllerMap.put("/score", scoreController);
        
        MemberController memberController = new MemberController();
        memberController.init();
        controllerMap.put("/member", memberController);
        
        BoardController boardController = new BoardController();
        boardController.init();
        controllerMap.put("/board", boardController);
        
        RoomController roomController = new RoomController();
        roomController.init();
        controllerMap.put("/room", roomController); 

    }

    void service() throws Exception {
        // 서버 소켓 준비
        ss = new ServerSocket(9999);
        System.out.println("서버 실행!");
        
        while (true) {
            // 클라이언트가 연결되면, 스레드에 처리를 위임한다.
            new HttpAgent(ss.accept()).start();
        }
    }

    private void save() {
        Collection<Controller> controllers = controllerMap.values();
        for (Controller controller : controllers) {
            controller.destroy(); // List에 들어있는 값을 파일에 저장.
        }
    }


    private void request(String command, PrintWriter out) {

        String menuName = command;

        int i = command.indexOf("/", 1);
        if (i != -1) {
            menuName = command.substring(0, i);
        }

        Controller controller = controllerMap.get(menuName);

        if (controller == null) {
            out.println("해당 명령을 지원하지 않습니다.");
            return;
        }

        // Controller를 실행하기 전에 컨트롤러가 작업하기 편하게
        // 클라이언트가 보낸 명령을 분석하여 객체 담아 둔다.
        Request request = new Request(command);
        
        Response response = new Response();
        response.setWriter(out);
        
        controller.execute(request, response);
    }

    private void hello(String command, PrintWriter out) {
        out.println("안녕하세요. 성적관리 시스템입니다.");
        out.println("[성적관리 명령들]");
        out.println("목록보기: /score/list");
        out.println("상세보기: /score/view?name=이름");
        out.println("등록: /score/add?name=이름&kor=점수&eng=점수&math=점수");
        out.println("변경: /score/update?name=이름&kor=점수&eng=점수&math=점수");
        out.println("삭제: /score/delete?name=이름");
        out.println("[회원]");
        out.println("[게시판]");
        out.println("[강의실]");

    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init();
        app.service();
    }
    
    class HttpAgent extends Thread {
        Socket socket;
        
        public HttpAgent(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try (
                    Socket socket = this.socket; // 왜? 자동 close() 호출!
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(
                            new BufferedOutputStream(socket.getOutputStream()));
                    ) {
                // HTTP 요청 읽기
                // => request-line 읽기
                // 예) GET /score/list HTTP/1.1 (CRLF)
                String command = in.readLine().split(" ")[1];

                // => header 읽기
                String header = null;
                while (true) {
                    header = in.readLine();
                    if (header.equals("")) // 빈 줄을 만나면 요청 데이터의 끝!
                        break;
                }
                
                // HTTP 응답 출력하기 
                // => status-line 출력
                // 예) HTTP/1.1 200 ok (CRLF)
                out.println("HTTP/1.1 200 OK");
                
                // => 콘텐츠의 MIME 타입과 인코딩 문자집합에 대한 정보를 출력한다. 
                out.println("Content-Type:text/plain;charset=UTF-8");
                
                // => 헤더의 끝임을 표시하기 위해 빈 줄을 출력한다.
                out.println();
                
                // 명령어에 따라 처리를 분기하여 콘텐츠를 출력한다.
                if (command.equals("/")) {
                    hello(command, out);
                } else {
                    request(command, out);
                    
                    // 클라이언트와 연결을 끊는 과정이 따로 없기 때문에
                    // 각 요청을 처리할 때 마다 바로 저장해야 한다.
                    save();
                }
                out.println(); // 응답을 완료를 표시하기 위해 빈줄 보냄.
                out.flush();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}















