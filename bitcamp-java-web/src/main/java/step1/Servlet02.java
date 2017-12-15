// Servlet 배치 URL
//
package step1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 클라이언트가 이 서블릿을 실행할 때 어떤 URL로 요청해야 하는지 
// @WebServlet 애노테이션에 지정해야 한다.
@WebServlet({"/step1/Servlet02/*","/servlet02","/ohora"})
public class Servlet02 implements javax.servlet.Servlet {
    
    // init()에서 받은 파라미터 값을 저장하는 변수
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step1.Servlet02.service()");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet02 - 서블릿 배치 URL";
    }
}









