// Servlet 인터페이스
// - 서블릿 컨테이너가 클라이언트로부터 서블릿을 실행해달라고 요청을 받으면,
//   javax.servlet.Servlet 인터페이스에 규칙에 따라 
//   개발자가 만든 객체에 대해 메서드를 호출한다.
// - Servlet은 서블릿 컨테이너(caller)와 개발자가 만든 프로그램(callee) 
//   사이에 호출 규칙이다.
// - 따라서 서블릿 컨테이너가 실행하는 프로그램을 만드려면 
//   반드시 Servlet 인터페이스를 구현해야 한다.
// 
// Servlet 인터페이스의 메서드
// - 서블릿의 생명주기와 관련된 메서드: init(), destroy(), service()
// - 기타 관리용 메서드: getServletConfig(), getServletInfo()
//
package step1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step1/Servlet01")
public class Servlet01 implements javax.servlet.Servlet {
    
    // init()에서 받은 파라미터 값을 저장하는 변수
    ServletConfig config;
    
    public Servlet01() {
        System.out.println("step1.Servlet01.Servlet01()");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        // 파라미터 값을 인스턴스 변수에 저장해 두었다가
        // ServletConfig 객체를 달라고 getServletConfig()를 호출하면 
        // 이 값을 리턴해준다.
        this.config = config;
        
        // 서블릿을 실행시켜 달라고 요청이 들어오면 
        // 서블릿 컨테이너는 그 요청을 처리할 서블릿 객체를 찾는다.
        // 만약 서블릿 객체를 아직 만들지 않았다면,
        // 클래스를 로딩한 후 해당 클래스의 인스턴스를 생성한다.
        // 그 후에 이 메서드를 호출한다.
        // 만약 서블릿 객체가 있다면, 또다시 인스턴스를 만들지는 않는다.
        // 즉 서블릿 인스턴스는 클래스당 오직 한 개만 생성된다.
        // => init()는 클래스의 인스턴스가 생성될 때 딱 한 번 호출된다.
        
        // 이 메서드에는 어떤 코드를 두는 것이 좋을까?
        // 클라이언트에게 서비스를 하기 위해 서블릿 인스턴스를 만들 때
        // 딱 한 번 호출되니까,
        // 여기에서 이 서블릿이 사용할 자원을 준비시키는 코드를 두는 것이 좋다.
        System.out.println("step1.Servlet01.init()");
    }
    
    @Override
    public void destroy() {
        // 웹 애플리케이션을 종료하면,
        // 웹 애플리케이션이 실행되는 동안 생성된 서블릿들에 대해
        // 서블릿 컨테이너가 이 메서드를 호출한다.
        // 왜 호출하냐요?
        // 웹 애플리케이션을 종료하기 전에 서블릿들이 스스로 필요해서 
        // 만든 외부 자원(DB, 파일, 소켓 등)들을 해제시키라고 기회를 주는 것이다.
        // 웹 애플리케이션이 실행되는 동안 클라이언트의 요청이 없어서
        // 객체가 생성되지 않은 서블릿에 대해서는 당연히
        // 이 메서드를 호출할 수 없다. 왜? 인스턴스가 없으니까!
        System.out.println("step1.Servlet01.destroy()");
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 클라이언트 요청이 들어오면,
        // 서블릿 컨테이너는 이 메서드를 호출한다.
        // 따라서 이 메서드에는 클라이언트가 요청한 작업을 처리하고,
        // 클라이언트에게 콘텐츠를 보내는 코드를 둔다.
        // 클라이언트가 요청할 때 마다 호출된다.
        System.out.println("step1.Servlet01.service()");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        // 서블릿의 설정 정보를 다룰 필요가 있을 때,
        // 서블릿 컨테이너나 개발자가 이 메서드를 호출하여 
        // 리턴 받은 ServletConfig를 사용한다.
        //
        // 보통 init() 메서드에서 받은 파라미터 값을 그대로 리턴한다.
        System.out.println("step1.Servlet01.getServletConfig()");
        return this.config;
    }
    
    @Override
    public String getServletInfo() {
        // 서블릿에 대한 간단한 안내 정보가 필요할 때,
        // 서블릿 컨테이너가 관리자 화면에서 서블릿에 대한 간단한 설명을 
        // 출력하려 할 때 이 메서드를 호출한다.
        // 보통 개발자가 직접 호출할 일은 없다.
        //
        // 
        System.out.println("step1.Servlet01.getServletInfo()");
        return "Servlet01 - 서블릿 인터페이스와 메서드들";
    }
}









