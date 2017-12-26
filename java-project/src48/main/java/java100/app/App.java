//: ## ver 48
//: - Spring IoC 컨테이너를 사용하여 객체 관리(Bean Container) 및 
//:   의존 객체 주입(DI)을 자동화하라!
//: - 학습목표
//:   - Spring IoC 컨테이너의 설정 및 사용방법을 익힌다.
//:   - Spring IoC 컨테이너의 역할을 이해한다.
//:   
package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java100.app.control.Controller;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.util.DataSource;

// 기존 방식의 문제점
// - 객체 관리 및 의존 객체 주입 기능이 단순하다. 
// - 외부 파일을 이용한 객체 관리 뿐만아니라 애노테이션을 이용한 객체 관리 
//   방법을 모두 제공하고 싶다. 
//
// 해결 방안
// - 이미 검증되고 널리 사용되는(best practice) 오픈 소스를 활용하여 
//   객체 관리와 의존 객체 주입을 자동화 하자!
// - Spring IoC 컨테이너를 도입하여 처리한다.
// - 변경코드  
//   0) 오픈 소스 Spring IoC 컨테이너 라이브러리를 다운로드 받는다. 
//      => mvnrepository.com에서 spring-context 라이브러리를 찾는다.
//      => build.gradle에 의존 라이브러리 정보를 등록한다.
//      => "gradlew eclipse"를 실행하여 이클립스 설정 파일을 갱신한다. 
//      => 이클립스 프로젝트를 "Refresh" 한다.
//
//   1) App 클래스 변경
//      => 우리가 만든 ApplicationContext 대신에 Spring의 ApplicationContext를
//         사용한다.
//      => 스프링에서 규정한 방식에 맞춰 설정 관련 애노테이션을 붙인다.
//
//   2) 컨트롤러와 DAO 클래스 변경 
//      => 우리가 만든 @Component 애노테이션 대신 
//         스프링에서 제공하는 @Component 애노테이션으로 바꾼다.
//
//   3) 의존 객체를 주입받으려면 셋터에 @Autowired 또는 @Inject를 붙여라!
//      => 컨트롤러에서는 DAO를 주입받는 셋터에 붙여라!
//      => DAO에서는 DataSource를 주입받는 셋터에 붙여라!
//  
//   4) @Autowired를 셋터에 붙이는 대신 필드에 직접 붙여라!
//      => 셋터에 붙이지 않고 필드에 붙여도 된다.
//      => 그러면 셋터는 지워도 된다.
//
// Spring IoC 컨테이너 = Bean Container + Dependency Injection
// => AnnotationConfigApplicationContext
//    - 애노테이션을 이용하여 클래스에 설정 정보를 붙인다.

// => ClassPathXmlApplicationContext
//    - 설정 정보를 XML 파일에 저장한다.
//    - 설정 정보가 들어 있는 XML 파일이 자바 클래스 경로에 놓여 있다.
//
// => FileSystemXmlApplicationContext
//    - 설정 정보를 XML 파일에 저장한다.
//    - 설정 정보가 들어 있는 XML 파일이 기타 임의의 위치에 놓여 있다.
//

//이 클래스가 스프링 IoC 컨테이너를 위한 설정 클래스임을 표시!
@Configuration 

//@Component 붙은 클래스가 어느 패키지에 있는지 표시
@ComponentScan("java100.app") 

public class App {

    ServerSocket ss;

    // Spring IoC 컨테이너 객체
    AnnotationConfigApplicationContext iocContainer;
    
    // 스프링 IoC 컨테이너에게 getDataSource() 메서드를 호출해서
    // 이 메서드가 리턴한 객체를 꼭 컨테이너에 보관해달고 표시!
    @Bean 
    DataSource getDataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studydb");
        ds.setUsername("study");
        ds.setPassword("1111");
        return ds;
    }
    
    void init() {
        // 애노테이션을 이용하여 IoC 컨테이너를 설정하는 객체 준비
        // => 파라미터로는 설정 관련 애노테이션이 붙은 클래스를 알려준다.
        iocContainer = new AnnotationConfigApplicationContext(App.class);
        
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

        Object controller = iocContainer.getBean(menuName);

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















