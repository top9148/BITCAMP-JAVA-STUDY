//: ## ver 44
//: - DAO를 교체하기 쉽도록 하라!
//: - 학습목표
//:  - 인터페이스 문법을 사용하여  규칙과 구현을 분리시키는 방법을 연습한다.
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
import java100.app.dao.mysql.BoardDaoImpl;
import java100.app.dao.mysql.MemberDaoImpl;
import java100.app.dao.mysql.RoomDaoImpl;
import java100.app.dao.mysql.ScoreDaoImpl;
import java100.app.util.DataSource;

// 기존 방식의 문제점
// - 컨트롤러에 주입되는 DAO는 클래스로 선언되어 있어서,
//   다른 구현체로 바꾸기가 어렵다.
// - 다른 구현체로 쉽게 바꿀 수 있으면, 그 클래스들의 상위 클래스을 정의하여
//   그 상위 클래스를 DAO 레퍼런스로 사용해야 한다.
// - 문제는 만약 어떤 DAO가 이미 다른 클래스를 상속받고 있다면,
//   새로 정의한 클래스를 상속 받을 수 없다는 것이다.
// - 그래서 이런 경우를 위해 자바에서는 좀 더 유현한 인터페이스라는 문법을 
//   제공하고 있다.
// - 의존 객체를 사용할 때 호출하는 메서드의 규칙을 인터페이스로 정의해 놓고,
//   DAO 클래스는 그 인터페이스 규칙에 맞춰 구현하는 것이다.
// - 이렇게 하면 어떤 클래스가 다른 클래스를 상속 받고 있다 하더라도
//   문제가 되지 않는다.
//
// 해결 방안
// - 컨트롤러가 의존하는 DAO의 메서드 사용 규칙을 분리하여 인터페이스로 정의한다.
// - 기존의 DAO 클래스 이름으로 인터페이스를 만들고,
//   기존 클래스는 새 이름을 부여한다.
// - 변경코드  
//   1) ScoreDao : ScoreDao(인터페이스), ScoreDaoImpl(클래스)
//   2) BoardDao : BoardDao(인터페이스), BoardDaoImpl(클래스)
//   3) MemberDao : MemberDao(인터페이스), MemberDaoImpl(클래스)
//   4) RoomDao : RoomDao(인터페이스), RoomDaoImpl(클래스)
//   5) App 클래스 변경
//      - 각각의 DAO 인터페이스를 구현한 객체를 만들어 컨트롤러에 주입한다.
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
        ScoreDaoImpl scoreDao = new ScoreDaoImpl();
        scoreDao.setDataSource(ds);
        
        MemberDaoImpl memberDao = new MemberDaoImpl();
        memberDao.setDataSource(ds);
        
        BoardDaoImpl boardDao = new BoardDaoImpl();
        boardDao.setDataSource(ds);
        
        RoomDaoImpl roomDao = new RoomDaoImpl();
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















