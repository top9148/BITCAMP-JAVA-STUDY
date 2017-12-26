// HTTP 프로토콜 정보를 추출하기 II
//
package step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step2/Servlet04")
public class Servlet04 extends AbstractHttpServlet {
    
    // Servlet 인터페이스 정의된 service(ServletRequest,ServletResponse)를
    // 오버라이딩 하는 대신에,
    // AbstractHttpServlet 클래스가 추가한
    // service(HttpServletRequest,HttpServletResponse)를 
    // 오버라이딩 하라!
    // 내부적으로 오리지널 service() 이 메서드를 호출하도록
    // 수퍼클래스에 코딩되어 있다.
    //
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.printf("클라이언트 IP: %s\n", req.getRemoteAddr());
        System.out.printf("클라이언트 포트: %d\n", req.getRemotePort());
        System.out.printf("URL: %s\n", req.getRequestURL());
        System.out.printf("URI: %s\n", req.getRequestURI());
        System.out.printf("servlet path: %s\n", req.getServletPath());
        System.out.printf("path info: %s\n", req.getPathInfo());
        System.out.printf("query string: %s\n", req.getQueryString());
    }
}









