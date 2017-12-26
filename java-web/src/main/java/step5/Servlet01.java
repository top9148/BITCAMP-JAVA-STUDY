// 클라이언트가 보낸 데이터 꺼내기
//
package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step5/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // URL에 포함된 데이터를 꺼내기
        // ServletRequest의 getParameter() 메서드를 사용하여 꺼낸다.
        // URL 예) http://localhost:9999/java-web/step5/Servlet01?name=a&age=20&working=true
        // getParameter()의 리턴 값은 String이다.
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("이름: %s\n", req.getParameter("name"));
        out.printf("나이: %s\n", req.getParameter("age"));
        out.printf("재직: %s\n", req.getParameter("working"));
        
        // 지정한 이름의 파라미터를 찾을 수 없으면, null을 리턴.
        // 지정한 이름의 파라미터는 있는데 값이 없으면, 빈 문자열 리턴.
    }
}









