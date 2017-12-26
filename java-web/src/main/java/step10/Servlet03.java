// Refresh II - 메시지를 출력한 후 지정된 시간이 지나면 
//           다른 페이지로 요청하라고 응답한다. 
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
@WebServlet("/step10/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        
        if (name == null) {
            // Refresh 명령을 HTTP 응답 헤더가 아닌 다음과 같이
            // HTML meta 태그로 설정할 수 있다.
            out.println("<meta http-equiv='Refresh' content='3;url=ErrorServlet'>");
        }
        out.println("<meta charset='UTF-8'>");
        out.println("<title>redirect</title>");
        out.println("</head>");
        out.println("<body>");
        
        if (name == null) {
            out.println("실행 오류! (3초후에 페이지 이동)");
        } else {
            out.printf("<p>%s 님 환영합니다!</p>\n", name);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

// Refresh의 응답 프로토콜
/*
HTTP/1.1 200
Refresh: 3;url=ErrorServlet
Content-Type: text/html;charset=UTF-8
Content-Length: 153
Date: Tue, 19 Dec 2017 03:07:05 GMT

...서버에서 보내는 내용...

=> Refresh는 응답 내용을 포함하고 있다.
=> 응답 코드 값이 200이다.
=> Refresh 헤더에 시간과 요청할 URL 정보가 들어 있다.
=> 웹 브라우저는 Refresh 헤더의 값을 보고 지정된 시간 만큼 출력한 다음에
   다시 서버에 요청한다.
*/

// 요청을 받았을 때 뭔가 출력한 후에 다른 페이지로 보내고 싶다면 => Refresh
// 요청을 받았을 때 출력 없이 바로 다른 페이지로 보내고 싶다면 => Redirect
































