//: ## ver 46
//: - 자동으로 인스턴스를 생성할 클래스에 대해 애노테이션으로 표시하라!
//: - 프로그램을 실행할 때 애노테이션으로 표시된 클래스만 인스턴스를 생성하라!
//: - 학습목표
//:   - 애노테이션을 활용하는 방법을 연습한다.
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
// - 컨트롤러나 DAO 클래스를 추가할 때 마다 .properties 파일을 변경해야 한다.
//
// 해결 방안
// - 자동으로 객체를 생성할 클래스라면, 클래스 파일을 정의할 때 
//   클래스 선언부에 애노테이션으로 표시를 한다.
// - 변경코드  
//   1) 클래스 선언부에 자동 생성 객체임을 표시할 때 사용할 애노테이션 정의.
//      => Component 애노테이션 
//   2) 자동으로 객체를 생성해야 하는 클래스에 Component 애노테이션을 붙인다.
//      => 컨트롤러와 DAO 클래스
//   3) ApplicationContext 변경
//      => .properties 파일을 읽어들이는 대신, 
//         클래스 파일을 로딩하여 @Component가 붙었는지 검사하고,
//         @Component가 붙은 클래스인 경우 객체를 생성한다.
//
public class App {

    ServerSocket ss;

    // 빈 관리 컨테이너 객체
    ApplicationContext beanContainer;
    
    void init() {
        
        // 빈 관리 컨테이너를 생성할 때 "프로퍼티" 파일의 경로를 넘겨주어
        // 프로퍼티 파일에 등록된 클래스의 객체를 자동 생성하게 한다.
        beanContainer = new ApplicationContext("./bin");
        
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















