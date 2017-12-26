// 파일 업로드 처리하기 III
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet09")
public class Servlet09 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");

        // 멀티 파트로 전송된 데이터를 분석하여 값과 파일명을 꺼내
        // 다음 변수에 저장할 것이다.
        String name = null;
        String age = null;
        String photo1Filename = null;
        String photo2Filename = null;
        
        // 이 부분에 멀티파트로 전송된 데이터를 분석하는 코드를 작성하라!
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/step8");
        MultipartRequest multi = new MultipartRequest(req, path, "UTF-8");

        name = multi.getParameter("name");
        age = multi.getParameter("age");
        photo1Filename = multi.getFilesystemName("photo1");
        photo2Filename = multi.getFilesystemName("photo2");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.printf("이름 = %s\n", name);
        out.printf("나이 = %s\n", age);
        out.printf("사진1 = %s\n", photo1Filename);
        out.printf("사진2 = %s\n", photo2Filename);
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
















