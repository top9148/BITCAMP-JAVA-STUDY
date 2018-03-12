// URL 인코딩 된 쿠키(cookie) 값 꺼내기
//
package step11;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet08")
public class Servlet08 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 응답 헤더에 포함된 쿠키 꺼내기
        Cookie[] cookies = req.getCookies();
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("클라이언트가 보낸 쿠키:");
        
        if (cookies != null) { // 쿠기가 한 개 이상 있다면,
            for (Cookie cookie : cookies) {
                // URL로 인코딩 되어 있는 값을 받았다면,
                // 사용하기 전에 URL 디코딩하여 원래의 값을 복원해야 한다.
                out.printf("%s=%s\n", cookie.getName(), 
                        
                        // getValue()가 리턴하는 문자열은 
                        // UTF-8 코드를 URL인코딩 한 것이다.
                        // 그러니 이 정보를 바탕으로 원래의 
                        // 유니코드 값으로 복원하라는 의미다.
                        // 즉,
                        // URL 인코딩 문자열 => UTF-8 코드 => 2바이트 유니코드
                        // => String 객체로 만들어 리턴한다.
                        URLDecoder.decode(cookie.getValue(), "UTF-8"));
            }
        }
    }
}

// 클라이언트가 서버로 쿠키를 보내는 요청 프로토콜 예:
/*
GET /bitcamp-java-web/step11/Servlet08 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
Cookie: name=ABC123%ED%99%8D%EA%B8%B8%EB%8F%99
*/
// 웹 브라우저는 메모리에 보관된 쿠키 데이터를 
// 요청 헤더에 포함하여 서버에 보낸다.














