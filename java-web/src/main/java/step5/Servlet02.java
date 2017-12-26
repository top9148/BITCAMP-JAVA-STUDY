// 클라이언트가 보낸 데이터 꺼내기 - 같은 이름으로 중복해서 값을 보낼 경우
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

@SuppressWarnings("serial")
@WebServlet("/step5/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 예) http://localhost:9999/java-web/step5/Servlet02?name=a&name=b&name=c
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name: %s\n", req.getParameter("name"));
        // 같은 이름으로 넘어온 값이 여러 개 있을 경우,
        // 그 중에서 한 개만 리턴된다.
        out.println("---------------------------");
        
        // 모두 꺼내고 싶다면?
        String[] values = req.getParameterValues("name");
        for (String value : values) {
            out.printf("name: %s\n", value);
        }
        out.println("---------------------------");
        
        // 파라미터 이름을 모두 꺼내고 싶다면?
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            out.printf("%s: %s\n", name, req.getParameter(name));
        }
    }
}









