//: ## ver 43
//: - 객체의 의존성 관리를 외부에서 처리하게 하라!
//: - 즉 의존 객체를 직접 만드는 것이 아니라 외부에서 주입하는 방식으로 변경하라!
//: - 학습목표
//:   - IoC의 개념과 기능에 대해 이해한다.
//:   - IoC와 DI의 관계를 이해한다.
//:   - DI를 구현할 수 있다.
//: 
//:   
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import java100.app.beans.ApplicationContext;
import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;
import java100.app.dao.BoardDao;
import java100.app.dao.MemberDao;
import java100.app.dao.RoomDao;
import java100.app.dao.ScoreDao;
import java100.app.util.DataSource;

// 기존 방식의 문제점
// - 컨트롤러는 자신이 사용할 DAO를 직접 생성해야 한다.
// - DAO는 자신이 사용할 DataSource를 직접 준비해야 한다.
// - 만약 DAO가 사용할 DataSource가 바뀌면 모든 DAO를 변경해야 한다.
// - 만약 DAO를 교체하게 되면 DAO를 사용하는 컨트롤러를 모두 변경해야 한다.
//
// 해결 방안
// - 의존하는 객체를 중앙 관리자가 주입해주는 방식으로 변경한다.
// - 변경 코드
//   1) DAO 클래스에서는 DataSource를 주입 받을 수 있도록 변경한다.
//      - DataSource 객체를 받기 위한 변수와 셋터를 준비한다.
//   2) 컨트롤러 클래스는 자신이 사용할 DAO를 주입 받을 수 있도록 변경한다.
//      - DAO를 저장할 변수와 셋터를 준비한다.
//   3) App 클래스를 변경한다.
//      - 이 클래스에서 모든 객체를 생성하고 의존 객체를 주입한다.
//
// IoC(Inversion of Control)
// - 프로그램의 기본 실행흐름을 역행하는 방식으로 동작시키는 기법.
// 예1) Event Listener
//      - 이벤트가 발생했을 때 특정 함수를 실행하는 만드는 방법
//      - 윈도우 프로그래밍에서 많이 사용한다.
//      - "event-driven development"라고도 부른다.
//      - 웹 페이지의 자바스크립트 프로그래밍도 이 방식을 사용한다.
// 예2) Dependency Injection
//      - 의존 객체를 외부에서 주입하는 방법
//      - 예전 코딩 방식에서는 자신이 사용할 객체는 자신이 만들어서 사용했다.
//      - 이 방식의 문제점은 객체를 바꿔야 할 경우 코드를 변경해야 한다.
//      - 그러나 의존 객체를 주입 받는 방식으로 코딩을 하게 되면,
//        객체를 교체할 때 그 객체를 사용하는 쪽에서는 코드를 변경할 필요가 없다.
// 
public class App {

    ServerSocket ss;
    Scanner keyScan = new Scanner(System.in);
    
    void init() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        
        // DAO 생성 및 의존 객체 주입하기 
        ScoreDao scoreDao = new ScoreDao();
        scoreDao.setDataSource(ds);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(ds);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setDataSource(ds);
        
        RoomDao roomDao = new RoomDao();
        roomDao.setDataSource(ds);
        
        // 컨트롤러 생성 및 의존 객체 주입하기
        ScoreController scoreController = new ScoreController();
        scoreController.setScoreDao(scoreDao);
        scoreController.init();
        ApplicationContext.addBean("/score", scoreController);
        
        MemberController memberController = new MemberController();
        memberController.setMemberDao(memberDao);
        memberController.init();
        ApplicationContext.addBean("/member", memberController);
        
        BoardController boardController = new BoardController();
        boardController.setBoardDao(boardDao);
        boardController.init();
        ApplicationContext.addBean("/board", boardController);
        
        RoomController roomController = new RoomController();
        roomController.setRoomDao(roomDao);
        roomController.init();
        ApplicationContext.addBean("/room", roomController); 

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

        Object controller = ApplicationContext.getBean(menuName);

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















