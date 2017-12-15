// 파일 업로드 처리하기 VI
//
package step8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet12")
@MultipartConfig(
    //location="/tmp", <== 업로드 파일이 임시 보관될 폴더
    //fileSizeThreshold=1024 * 1024, // 파일을 업로드 할 때 버퍼 크기 
    maxFileSize=1024 * 1024 * 10, // 업로드 파일 한 개의 최대 크기
    maxRequestSize=1024 * 1024 * 100 // 한 번 요청으로 보내는 데이터의 최대 크기
)
public class Servlet12 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");

        // 멀티 파트로 전송된 데이터를 분석하여 값과 파일명을 꺼내
        // 다음 변수에 저장할 것이다.
        String name = null;
        String age = null;
        String photo1OriginalFilename = null;
        String photo1NewFilename = null;
        String photo2OriginalFilename = null;
        String photo2NewFilename = null;
        
        // Servlet API에서 제공하는 클래스 사용하여 
        // 멀티파트로 전송된 데이터 처리하기.
        // 1) 서블릿 배치할 때 멀티파트 데이터를 처리하는 서블릿이라고 선언해야 한다.
        //    => @MultipartConfig 애노테이션을 붙이거나,
        //    => web.xml에 multipart-config 태그를 붙인다.
        //       예)
        //        <multipart-config>
        //        <location>/tmp</location>
        //        <max-file-size>20848820</max-file-size>
        //        <max-request-size>418018841</max-request-size>
        //        <file-size-threshold>1048576</file-size-threshold>
        //        </multipart-config>
        //
        
        try {
            ServletContext context = this.getServletContext();
            String path = context.getRealPath("/step8");
            
            name = req.getParameter("name");
            age = req.getParameter("age");
            
            Part photo1Part = req.getPart("photo1");
            photo1OriginalFilename = photo1Part.getSubmittedFileName();
            
            // 파일이 저장되는 위치는 MultipartConfig의 location 속성에 
            // 설정된 위치를 기준으로 저장된다.
            // => 만약 웹브라우저에서 바로 접근할 수 있는 폴더에 
            //    저장하고 싶다면 별도의 출력스트림으로 처리하라!
            // => 만약 location 속성의 값을 지정하지 않으면,
            //    톰캣 테스트 용 임시 서버의 경우, 
            //    그 위치가 ..server.core/tmp0/work/Catalina/localhost/... 
            //    에 보관된다.
            // 
            //photo1NewFilename = getNewFilename(photo1OriginalFilename);
            //photo1Part.write(photo1NewFilename);
            
            // 배치 폴더에 직접 저장해보자!
            photo1NewFilename = writeUploadFile(photo1Part, path);
            
            
            Part photo2Part = req.getPart("photo2");
            photo2OriginalFilename = photo2Part.getSubmittedFileName();
            //photo2NewFilename = getNewFilename(photo2OriginalFilename);
            //photo2Part.write(photo2NewFilename);
            photo2NewFilename = writeUploadFile(photo2Part, path);
            
        } catch (Exception e) {
            throw new ServletException(e);
        }

        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>파일 업로드 결과</title>");
        out.println("</head>");
        
        out.println("<body>");
        out.println("<h1>파일 업로드 결과</h1>");
        
        out.printf("이름 = %s<br>\n", name);
        out.printf("나이 = %s<br>\n", age);
        
        out.printf("사진1 = %s<br>\n", photo1OriginalFilename);
        out.printf("<img src='%s' width='200'><br>\n", photo1NewFilename);
        
        out.printf("사진2 = %s<br>\n", photo2OriginalFilename);
        out.printf("<img src='%s'width='200'><br>\n", photo2NewFilename);
        
        out.println("</body>");
        out.println("</html>");
    }
    
    long prevMillis = 0;
    int count = 0;
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(Part part, String path) throws IOException {
        BufferedInputStream in = new BufferedInputStream(
                part.getInputStream());
        
        String filename = getNewFilename(part.getSubmittedFileName());
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(path + "/" + filename));
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        out.flush();
        
        in.close();
        out.close();
        
        return filename;
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
















