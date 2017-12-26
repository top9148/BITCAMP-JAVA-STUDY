// 정적 자원과 동적 자원의 만남!
// - 입력 폼과 같이 실행할 때 마다 콘텐츠가 변하지 않는 것은 
//   정적 자원의 형식, 즉 HTML 파일로 작성한다.
// - 계산 결과와 같이 작업을 수행한 후에 결과를 출력하는 콘텐츠는 
//   서블릿으로 만든다.
//
package step7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step7/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 계산을 위한 입력 값은 /step7/Servlet03.html을 통해 전송 받아보자!
        //
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        String op = req.getParameter("op");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>계산 결과</h1>");
        out.println("<p>");
        out.printf("%d %s %d = ", a, op, b);
        
        switch (op) {
        case "+": out.println(a + b); break;
        case "-": out.println(a - b); break;
        case "*": out.println(a * b); break;
        case "/": out.println(a / b); break;
        case "%": out.println(a % b); break;
        default: out.println("지원하지 않는 연산자 입니다!");
        }
        out.println("<p>");
        
        // 이전 입력 양식으로 돌아가는 링크를 추가한다.
        // 사용자가 웹 페이지에서 이 링크를 클릭하면 
        // 웹 브라우저는 Servlet03.html을 웹서버에 요청한다.
        //
        out.println("<a href='Servlet03.html'>다시 계산</a>");
        
        out.println("</body>");
        out.println("</html>");
        
    }
}









