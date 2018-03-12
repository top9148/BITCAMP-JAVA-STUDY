// 쿠키(cookie) 꺼내기 - 하위 경로의 서블릿을 실행할 때 
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/other/Servlet04")
public class Servlet04 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 쿠키를 보낸 서블릿(/step11/Servlet01)과 
        // 다른 경로에 있는 경우에는 쿠키를 받을 수 없다.
        // 즉 웹브라우저가 쿠키 데이터를 전송하지 않는다.
        Cookie[] cookies = req.getCookies();
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("클라이언트가 보낸 쿠키:");
        
        if (cookies != null) { // 쿠기가 한 개 이상 있다면,
            for (Cookie cookie : cookies) {
                out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
            }
        }
    }
}










