//: ## ver 36
//: - 버전 35는 한 번 클라이언트와 연결되면 
//    클라이언트와 연결이 끊어질 때까지 계속 요청과 응답을 수행한다. 
//    문제는 클라이언트 사용자가 아무런 일을 시키지 않아도 
//    계속 연결된 채로 있다는 것이다. 즉 메모리 낭비가 이루어진다.
//: - 버전 35의 문제점을 해결하기 위해 요청할 때마다 연결을 한 후 
//    응답을 하면 연결을 끊는 방식으로 전환한다. 
//    단점, 요청할 때마다 연결해야 하기 때문에 요청/응답 시간이 늘어난다. 
//    장점, 클라이언트와 일시적으로 연결되기 때문에 
//    더 많은 클라이언트의 요청을 처리할 수 있다.
//: - 학습목표
//:   - Stateful 과 Stateless 방식의 차이점을 이해하고 구현할 수 있다.
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

// Stateful
// - 클라이언트와 서버가 한 번 연결되면 명시적으로 연결 끊을 때까지
//   데이터 통신을 하는 방식이다.
// - 예) FTP, SSH, Telnet 등
// - 특징
//   => 클라이언트와 계속 연결된 채로 있기 때문에 클라이언트가 요청한 
//      작업 결과를 서버에 유지(상태 유지)할 수 있다.
// 
// Stateless
// - 클라이언트가 서버에 요청할 때 마다 매번 연결하고,
//   서버가 응답을 한 후에는 연결을 끊는다.
// - 예) HTTP, 이메일 보내기 서버(SMTP), 이메일 가져오기 서버(POP3, IMAP) 등
// - 특징
//   => 클라이언트의 요청을 처리한 후 연결을 끊기 때문에 
//      클라이언트의 작업 상태를 보관할 수 없다.
//   => 그대신 같은 자원(메모리)으로 더 많은 클라이언트 요청을 처리한다.
//
// RequestProcessor 클래스에서 요청/응답을 반복하는 부분에서
// while 반복문을 제거한다.
// => 클라이언트도 변경해야 한다.
// 
public class App {

    ServerSocket ss;
    Scanner keyScan = new Scanner(System.in);

    // 이제 HashMap에 보관하는 값은 Controller 규칙을 준수한 객체이다.
    HashMap<String,Controller> controllerMap = 
            new HashMap<>();

    void init() {
        controllerMap.put("/score", new ScoreController("./data/score.csv"));
        controllerMap.put("/member", new MemberController("./data/member.csv"));
        controllerMap.put("/board", new BoardController("./data/board.csv"));
        controllerMap.put("/room", new RoomController("./data/room.csv")); 

    }

    void service() throws Exception {
        // 서버 소켓 준비
        ss = new ServerSocket(9999);
        System.out.println("서버 실행!");
        
        while (true) {
            // 클라이언트가 연결되면, 스레드에 처리를 위임한다.
            new RequestProcessor(ss.accept()).start();
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
    
    class RequestProcessor extends Thread {
        Socket socket;
        
        public RequestProcessor(Socket socket) {
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
                // 클라이언트와 연결되면 한 번 요청을 받고 응답한 후 
                // 연결을 끊는다.
                // => 요청/응답을 반복적으로 처리한 코드에서 
                //    반복문을 제거한다.
                
                // 클라이언트로부터 명령어를 입력 받는다.
                String command = in.readLine();

                // 명령어에 따라 처리를 분기한다.
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















