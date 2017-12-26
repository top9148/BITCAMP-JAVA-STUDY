// 파일 업로드 처리하기 V
//
package step8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet11")
public class Servlet11 extends HttpServlet {
    
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
            
            // Map 객체에 저장된 FileItem을 꺼내서 파라미터 값을 추출한다.
            // 또는 업로드 파일 이름을 추출한다.
            name = itemMap.get("name").getString("UTF-8");
            age = itemMap.get("age").getString();
            photo1OriginalFilename = itemMap.get("photo1").getName();
            photo2OriginalFilename = itemMap.get("photo2").getName();
            
            // 임시 폴더에 저장된 파일을 외부에서 다운로드 할 수 있도록 
            // 위치를 변경한다.
            // => "http://localhost:9999/java-web/step8/파일명"으로 
            //    다운로드 할 수 있게 한다. 
            ServletContext context = this.getServletContext();
            String path = context.getRealPath("/step8");
            
            // 사용자가 업로드 한 파일을 서버에 저장할 때 유의할 점은,
            // 업로드 파일명 그대로 저장해서는 안된다.
            // 왜? 
            // 같은 이름은 다른 사람이 업로드 한다면,
            // 기존의 파일을 덮어쓸 것이다.
            // 해결책?
            // 일련번호를 가지고 파일명을 만들어 사용하라!
            FileItem fileItem = itemMap.get("photo1");
            photo1NewFilename = getNewFilename(fileItem.getName());
            File file = new File(path + "/" + photo1NewFilename);
            fileItem.write(file);
            
            fileItem = itemMap.get("photo2");
            photo2NewFilename = getNewFilename(fileItem.getName());
            file = new File(path + "/" + photo2NewFilename);
            fileItem.write(file);
            
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
















