// Redirect - 다른 페이지로 요청하라고 응답한다. 
//
package step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        if (name == null) {
            // 클라이언트에게 ErrorServlet을 요청하라고 응답한다.
            // 상대 경로이기 때문에 실제 경로는 다음과 같다.
            // http://localhost:9999/java-web/step10/ErrorServlet
            res.sendRedirect("ErrorServlet");
            return;
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>redirect</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<p>%s 님 환영합니다!</p>\n", name);
        out.println("</body>");
        out.println("</html>");
    }
}

// Redirect의 응답 프로토콜
/*
HTTP/1.1 302
Location: ErrorServlet
Content-Type: text/html;charset=UTF-8
Content-Length: 0
Date: Tue, 19 Dec 2017 02:55:32 GMT

=> Redirect는 응답할 때 어떠한 내용도 보내지 않는다.
=> 응답 코드 값이 302이다.
=> Location 헤더에 요청할 URL 정보가 있다.
=> 웹브라우저는 응답을 받는 즉시 Location 헤더에 설정된 URL로 바로 요청한다.
*/

// 응용 예:
// => 포탈 사이트에 로그인 한 후 메인 화면으로 이동하는 경우! 





















