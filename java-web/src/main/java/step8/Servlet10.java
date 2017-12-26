// 파일 업로드 처리하기 IV
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet10")
public class Servlet10 extends HttpServlet {
    
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
        // => Apache FileUpload 라이브러리 사용하기
        //
        // 멀티파트 데이터를 받아서 각 파트 데이터를 FileItem 객체로 만들고, 
        // 파일은 외부 저장장치(HDD)에 저장하는 역할을 수행한다. 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // 멀티 파트로 전송된 요청 정보를 다루는 역할을 수행한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // List에 담겨 있는 FileItem 객체를 사용하기 쉽게 Map으로 옮긴다.
        Map<String, FileItem> itemMap = new HashMap<>();
        try {
            // 멀티 파트 데이터를 처리하라!
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                itemMap.put(item.getFieldName(), item);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        //ServletContext context = this.getServletContext();
        //String path = context.getRealPath("/step8");

        // Map 객체에 저장된 FileItem을 꺼내서 파라미터 값을 추출한다.
        // 또는 업로드 파일 이름을 추출한다.
        name = itemMap.get("name").getString("UTF-8");
        age = itemMap.get("age").getString();
        photo1Filename = itemMap.get("photo1").getName();
        photo2Filename = itemMap.get("photo2").getName();
        
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
















