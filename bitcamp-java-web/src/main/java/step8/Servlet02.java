// GET과 POST 요청을 구분하여 처리하는 예 
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
@WebServlet("/step8/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        // GET 요청일 때 계산기의 입력양식을 출력한다.
        // POST 요청일 때 계산을 수행한다.
        //
        if (req.getMethod().equals("GET")) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>계산기</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>계산기</h1>");
            out.println("<form action='Servlet02' method='POST'>");
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
            
        } else if (req.getMethod().equals("POST")) {
            
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
            
            out.println("<a href='Servlet02'>다시 계산</a>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
    }
    
 
}

















