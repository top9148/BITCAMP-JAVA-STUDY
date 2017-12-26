// 클라이언트가 데이터를 보내는 방법 - GET 요청과 POST 요청
//
package step5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// GET 요청
// - URL에 붙여서 보낸다.
// 예) 
/*
GET /bitcamp-java-web/step5/Servlet03?name=hong&age=20&working=true HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
Referer: http://localhost:9999/bitcamp-java-web/step5/Servlet03.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
*/
// POST 요청
// - 요청 헤더 다음에 message-body 순서에서 보낸다.
// 예)
/*
POST /bitcamp-java-web/step5/Servlet03 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Content-Length: 31
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:9999
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
Referer: http://localhost:9999/bitcamp-java-web/step5/Servlet03.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

name=hong2&age=30&working=false
*/

// 데이터를 보내는 형식
// - GET과 POST 모두 같다.
// - 이름=값&이름=값&이름=값...
//
// Query String(쿼리 스트링)
// - GET 요청처럼 URL에 붙어서 보내는 데이터를 말한다.
//
// Message-Body = entity
// - POST 요청처럼 요청 헤더 다음에 보내는 데이터를 말한다.
//
@SuppressWarnings("serial")
@WebServlet("/step5/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 테스트 방법 
        // - 다음 URL을 입력하여 화면에 페이지가 보이면 값을 입력한 후 요청한다.
        // - http://localhost:9999/java-web/step5/Servlet03.html
        // - 한 번은 "GET 요청" 폼에 값을 입력한 후 "요청" 버튼을 누리고,
        // - 또 한 번은 "POST 요청" 폼에 값을 입력한 후 "요청" 버튼을 눌러 봐라! 
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        // GET 요청으로 데이터가 넘어 왔든,
        // POST 요청으로 데이터가 넘어 왔든 
        // 모두 같은 메서드(getParameter())로 꺼낼 수 있다.
        // 
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            out.printf("%s: %s\n", name, req.getParameter(name));
        }
        
        // 주목!
        // - 한글을 보낼 때 GET 요청은 문제가 없지만,
        //   (tomcat8부터는 문제 없다. 
        //    톰캣7 이하 버전에서는 한글이 안깨지도록 설정 정보를 추가해야 한다.)
        // - POST 요청에서는 한글이 깨진다.
        //   이유? 
        //   Servlet04에서 확인바람!
        
    }
}









