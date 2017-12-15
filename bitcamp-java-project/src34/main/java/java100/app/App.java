//: ## ver 34
//: - 여러 사람이 동시에 업무를 볼 수 있도록 C/S(Client/Server) 구조로 
//:   프로그램을 변경하라!
//: - 학습목표
//:   - 네트워킹 프로그래밍을 연습한다.
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

// App 클래스를 서버 프로그램으로 전환한다.
// 그리고 실행 방식도 변경한다.
// 
// 클라이언트 쪽 실행방법
// -------------------------------------
// 명령> /score/list
// bbb, 100, 100, 100, 300, 100.0
// ccc, 90, 90, 90, 270, 90.0
//
// 명령> /score/add?name=aaa&kor=100&eng=90&math=30
// 입력되었습니다.
//
// 명령> /score/view?name=aaa
// 이름: aaa
// 국어: 100
// 영어: 90
// 수학: 30
// 합계: 220
// 평균: 76.6
// 
// 명령> /score/update?name=aaa&kor=100&eng=100&math=100
// 변경하였습니다.
//
// 명령> /score/delete?name=aaa
// 삭제하였습니다.
// 
// 명령>
//
// 게시판 명령어 정리:
// 목록 => /board/list
// 보기 => /board/view?no=1
// 등록 => /board/add?no=10&title=aaa&content=bbb
// 변경 => /board/update?no=10&title=aaax&content=bbbx
// 삭제 => /board/delete?no=10
//
// 회원관리 명령어 정리:
// 목록 => /member/list
// 보기 => /member/view?email=aaa@test.com
// 등록 => /member/add?email=bbb@test.com&name=bbb&password=1111
// 변경 => /member/update?email=bbb@test.com&name=bbbx&password=2222
// 삭제 => /member/delete?email=bbb@test.com
//
// 강의실 명령어 정리:
// 목록 => /room/list
// 보기 => /room/view?name=K101
// 등록 => /room/add?name=K101&location=강남&capacity=30
// 변경 => /room/update?name=K101&location=강남&capacity=30
// 삭제 => /root/delete?name=K101
//
public class App {

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
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버 실행!");
        
        loop:
        while (true) {
            try (
                    // 클라이언트가 연결되면,
                    Socket socket = ss.accept();
                    // 소켓을 통해 데이터를 입출력할 수 있도록 스트림 객체 준비
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(
                            new BufferedOutputStream(socket.getOutputStream()));
                    ) {
                while (true) {
                    // 클라이언트로부터 명령어를 입력 받는다.
                    String command = in.readLine();

                    // 명령어에 따라 처리를 분기한다.
                    if (command.equals("/")) {
                        hello(command, out);
                    } else if (command.equals("quit")) {
                        break;
                    } else if (command.equals("server stop")) {
                        break loop;
                    } else {
                        request(command, out);
                    }
                    out.println(); // 응답을 완료를 표시하기 위해 빈줄 보냄.
                    out.flush();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // while
        
        // 모든 컨트롤러에 대해 마무리 작업을 지시한다.
        Collection<Controller> controllers = controllerMap.values();
        for (Controller controller : controllers) {
            controller.destroy(); // List에 들어있는 값을 파일에 저장.
        }
        
        ss.close();
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

}






