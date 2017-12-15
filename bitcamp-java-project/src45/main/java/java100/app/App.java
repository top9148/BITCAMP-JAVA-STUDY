//: ## ver 45
//: - 컨트롤러와 DAO 객체를 자동 생성하라!
//: - 자동 생성할 클래스 정보를 properties 파일에 등록한 다음,
//:   프로그램을 시작할 때 해당 파일에 등록된 클래스의 객체를 자동생성한다. 
//: - 학습목표
//:   - 객체를 자동 생성하는 방법을 연습한다.
//:   - Reflection API의 활용법을 이해한다.
//: 
//:   
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java100.app.beans.ApplicationContext;
import java100.app.control.Controller;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.util.DataSource;

// 기존 방식의 문제점
// - 컨트롤러나 DAO가 추가될 때마다 해당 객체를 생성하는 코드를 
//   App 클래스에 추가해야 한다.
//
// 해결 방안
// - 객체를 생성해야 하는 클래스 이름을 외부 파일에 등록한 후
//   프로그램을 시작할 때 자동으로 생성되게 한다.
// - 변경코드  
//   1) application-context.properties 파일 생성
//      - 자동으로 생성할 객체의 클래스 이름을 등록한다.
//   2) ApplicationContext 변경
//      - 멤버를 개별적으로 관리할 수 있도록 인스턴스 멤버로 전환한다.
//      - 생성자에 프로퍼티 파일을 경로를 넘겨주면, 해당 경로의 정보를 읽어서
//        주어진 클래스의 인스턴스를 자동 생성한다.
//      - 각 인스턴스의 셋터 메서드를 찾아서 호출한다.
//        즉 그 객체가 원하는 의존 객체를 주입한다.
// 
public class App {

    ServerSocket ss;

    // 빈 관리 컨테이너 객체
    ApplicationContext beanContainer;
    
    void init() {
        
        // 빈 관리 컨테이너를 생성할 때 "프로퍼티" 파일의 경로를 넘겨주어
        // 프로퍼티 파일에 등록된 클래스의 객체를 자동 생성하게 한다.
        beanContainer = new ApplicationContext(
                "./bin/application-context.properties");
        
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        
        // 밖에서 만든 DataSource는 수동으로 빈 컨테이너에 추가한다.
        beanContainer.addBean("mysqlDataSource", ds);
        
        // 다시 의존 객체 주입을 해야 한다.
        beanContainer.refreshBeanFactory();
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

        Object controller = beanContainer.getBean(menuName);

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















