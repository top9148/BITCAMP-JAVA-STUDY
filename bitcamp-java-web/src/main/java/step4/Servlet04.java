// 클라이언트로 텍스트 출력하기 - MIME 타입 II
//
package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step4/Servlet04")
public class Servlet04 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 웹 브라우저 쪽에 어떤 타입의 텍스트를 보낼 것인지 알려준다. 
        res.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("<html><body><h1>Hello!</h1></body></html>");
        
    }
}









