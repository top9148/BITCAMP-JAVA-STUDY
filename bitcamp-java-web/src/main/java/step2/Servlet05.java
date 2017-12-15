// HttpServlet 추상 클래스
//
package step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JavaEE 에는 AbstractHttpServlet 클래스처럼 동작하는 클래스를  
// 미리 만들어 제공하고 있다.
// 그 클래스의 이름이 "HttpServlet"이다.
// 
// 
@SuppressWarnings("serial")
@WebServlet("/step2/Servlet05")
public class Servlet05 extends HttpServlet {
    
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









