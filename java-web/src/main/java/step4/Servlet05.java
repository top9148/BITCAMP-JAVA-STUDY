// 클라이언트로 바이너리 데이터 출력하기
//
package step4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step4/Servlet05")
public class Servlet05 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 바이너리 데이터를 출력하려면 바이트 출력 스트림을 얻어야 한다.
        //
        BufferedOutputStream out = new BufferedOutputStream(
                                        res.getOutputStream());
        
        // 현재 웹 애플리케이션의 경로를 알아내기
        ServletContext webAppInfo = req.getServletContext();
        String filePath = webAppInfo.getRealPath("/test.jpg");
        
        BufferedInputStream in = new BufferedInputStream(
                                    new FileInputStream(filePath));
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        in.close();
        
        out.flush();
    }
}









