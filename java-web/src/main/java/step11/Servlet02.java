// 쿠키(cookie) 꺼내기
// => 응답 헤더에 포함된 쿠키 데이터를 꺼내기
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
@WebServlet("/step11/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 응답 헤더에 포함된 쿠키 꺼내기
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

// 클라이언트가 서버로 쿠키를 보내는 요청 프로토콜 예:
/*
GET /bitcamp-java-web/step11/Servlet02 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36
Upgrade-Insecure-Requests: 1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
Cookie: name=hong; age=20; working=true
*/
// 웹 브라우저는 메모리에 보관된 쿠키 데이터를 
// 요청 헤더에 포함하여 서버에 보낸다.














