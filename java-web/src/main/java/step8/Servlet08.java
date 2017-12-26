// 파일 업로드 처리하기 II
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet08")
public class Servlet08 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        // 멀티 파트로 전송된 데이터를 
        // 서버에서는 다음과 같이 일반적으로 방식으로 꺼낼 수 없다.
        // 실행해보면 모든 값이 null일 것이다
        // 해결책!
        // => 멀티파트 형식의 데이터를 분석해야 한다.
        // => 오픈소스 라이브러리들이 있다. 활용하여 처리하라!
        // 
        out.printf("이름 = %s\n", req.getParameter("name"));
        out.printf("나이 = %s\n", req.getParameter("age"));
        out.printf("사진1 = %s\n", req.getParameter("photo1"));
        out.printf("사진2 = %s\n", req.getParameter("photo2"));
    }
    
}

// 멀티파트 데이터 형식 예)
/*
POST /bitcamp-java-web/step8/Servlet08 HTTP/1.1
Host: localhost:9999
Content-Length: 16164
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:9999
Upgrade-Insecure-Requests: 1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryOmN8vafzkCySzU9a
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
Referer: http://localhost:9999/bitcamp-java-web/step8/Servlet08.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

------WebKitFormBoundaryOmN8vafzkCySzU9a
Content-Disposition: form-data; name="name"

홍길동
------WebKitFormBoundaryOmN8vafzkCySzU9a
Content-Disposition: form-data; name="age"

20
------WebKitFormBoundaryOmN8vafzkCySzU9a
Content-Disposition: form-data; name="photo1"; filename="photo11.jpeg"
Content-Type: image/jpeg

바이너리 데이터....
-----WebKitFormBoundaryOmN8vafzkCySzU9a
Content-Disposition: form-data; name="photo2"; filename="photo12.jpeg"
Content-Type: image/jpeg

바이너리 데이터...
------WebKitFormBoundaryOmN8vafzkCySzU9a--
*/
















