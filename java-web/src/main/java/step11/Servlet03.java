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
@WebServlet("/step11/other/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 쿠키를 보낸 서블릿(/step11/Servlet01)과 
        // 같은 경로(/step11/Servlet02)에 있거나,
        // 그 하위 경로(/step11/other/Servlet03)에 있는 경우 
        // 쿠키를 받을 수 있다.
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










