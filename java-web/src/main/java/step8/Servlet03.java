// GET과 POST 요청을 구분하여 처리하는 예 II 
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
@WebServlet("/step8/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // GET 요청을 처리하는 코드와 POST 요청을 처리하는 코드를
        // 관리하기 쉽게 별도의 메서드로 분리한다.
        //
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        
        
        // GET 요청일 때 계산기의 입력양식을 출력한다.
        // POST 요청일 때 계산을 수행한다.
        //
        if (req.getMethod().equals("GET")) {
            get(req, res);
            
        } else if (req.getMethod().equals("POST")) {
            post(req, res);
            
        }
        
    }
    
 
    protected void get(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>계산기</h1>");
        out.println("<form action='Servlet03' method='POST'>");
        out.println("<input type='text' name='a' size='3'>");
        out.println("<select name='op'>");
        out.println("    <option>+</option>");
        out.println("    <option>-</option>");
        out.println("    <option>*</option>");
        out.println("    <option>/</option>");
        out.println("    <option>%</option>");
        out.println("</select>");
        out.println("<input type='text' name='b' size='3'>");
        out.println("<button>=</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    
    protected void post(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        PrintWriter out = res.getWriter();
        
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        String op = req.getParameter("op");
        
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
        
        out.println("<a href='Servlet03'>다시 계산</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

















