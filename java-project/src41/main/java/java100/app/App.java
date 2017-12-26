//: ## ver 41
//: - DataSource의 멤버를 스태틱에서 인스턴스로 전환하여 여러 DBMS의 커넥션을 
//:   다룰 수 있도록 하라!
//: - 학습목표
//:   - 스태틱 멤버의 한계와 인스턴스 멤버의 사용이유를 이해한다.
//:   - 인스턴스를 어디서 생성하고 관리해야 하는지 이해한다.
//:   
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.beans.BeansException;
import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;
import java100.app.util.DataSource;

// 기존 방식의 문제점
// - DataSource의 멤버가 스태틱이라서 오직 한 DBMS의 커넥션만 관리할 수 있다.
//
// 해결 방안
// - 커넥션 객체를 보관할 List를 인스턴스 멤버로 만든다.
// - DBMS 연결정보(url, id, password)를 외부에서 입력 받아 관리한다.
// - 변경 코드
//   1) DataSource.java 변경
//      - 다양한 DBMS에서도 사용할 수 있게 변경한다.
//   2) App.java 변경 
//      - DataSource를 객체를 이 클래스에서 생성하고 관리한다.
//      - 기존에 Controller만 보관하던 맵을 변경하여 
//        다양한 타입의 객체도 담을 수 있도록 한다. 
// 
public class App {

    ServerSocket ss;
    Scanner keyScan = new Scanner(System.in);

    // 이제 HashMap은 Controller 구현체 뿐만 아니라 기타 여러 타입의 객체도
    // 담을 수 있다.
    static HashMap<String,Object> beanContainer = 
            new HashMap<>();

    public static Object getBean(String name) {
        Object bean = beanContainer.get(name);
        if (bean == null)
            throw new BeansException("빈을 찾을 수 없습니다.");
        return bean;
    }
    
    void init() {
        ScoreController scoreController = new ScoreController();
        scoreController.init();
        beanContainer.put("/score", scoreController);
        
        MemberController memberController = new MemberController();
        memberController.init();
        beanContainer.put("/member", memberController);
        
        BoardController boardController = new BoardController();
        boardController.init();
        beanContainer.put("/board", boardController);
        
        RoomController roomController = new RoomController();
        roomController.init();
        beanContainer.put("/room", roomController); 

        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        
        beanContainer.put("mysqlDataSource", ds);
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

    private void request(String command, PrintWriter out) {

        String menuName = command;

        int i = command.indexOf("/", 1);
        if (i != -1) {
            menuName = command.substring(0, i);
        }

        Object controller = beanContainer.get(menuName);

        if (controller == null && controller instanceof Controller) {
            out.println("해당 명령을 지원하지 않습니다.");
            return;
        }

        // Controller를 실행하기 전에 컨트롤러가 작업하기 편하게
        // 클라이언트가 보낸 명령을 분석하여 객체 담아 둔다.
        Request request = new Request(command);
        
        Response response = new Response();
        response.setWriter(out);
        
        ((Controller)controller).execute(request, response);
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
                }
                out.println(); // 응답을 완료를 표시하기 위해 빈줄 보냄.
                out.flush();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}















