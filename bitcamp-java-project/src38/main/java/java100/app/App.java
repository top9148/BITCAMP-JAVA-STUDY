//: ## ver38
//: - DBMS를 사용하여 데이터를 저장하라!
//: - 학습목표
//:   - JDBC API를 사용하는 방법을 훈련한다.
//:   - SQL 사용 방법을 훈련한다. 
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

// 0) JDBC API 사용 준비
//    => build.gradle 파일에 의존 라이브러리 MySQL JDBC 드라이버를 등록한다.
//    => "gradlew eclipse"를 실행하여 라이브러리를 다운로드하고 
//       이클립스 설정 파일을 갱신한다.
//    => 프로젝트를 리프래시 하여 상태를 갱신한다.
//
// 1) 성적, 회원, 게시물, 강의실 데이터를 저장할 테이블을 준비한다.
//    => bitcamp-docs/java-project.sql
//
// 2) 성적관리 기능에 DBMS 적용
//    => Score 클래스를 테이블 정의에 맞춰서 변경
//    => ScoreController 클래스에 JDBC API 적용
// 3) 회원관리, 강의실관리, 게시물관리 기능에도 DBMS 적용
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















