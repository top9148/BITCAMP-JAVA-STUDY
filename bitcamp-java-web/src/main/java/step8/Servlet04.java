// GET과 POST 요청을 구분하여 처리하는 예 III 
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
@WebServlet("/step8/Servlet04")
public class Servlet04 extends HttpServlet {
    
    // HttpServlet 클래스는 이미 GET 요청과 POST 요청 등을 구분하여 
    // 내부에서 만든 메서드를 호출하도록 이미 프로그래밍 되어 있다.
    // 
    // 1) 클라이언트 요청이 들어 온다.
    // 2) 서블릿 컨테이너가 service(ServletRequest, ServletResponse)를 호출한다.
    //    => 이 메서드는 ServletRequest와 ServletResponse를 원래의 타입인 
    //       HttpServletRequest, HttpServletResponse로 형변환 한 다음에,
    //       내부에 새로 추가한 service()를 호출한다.
    // 3) service(HttpServletRequest, HttpServletResponse) 호출 
    //    => 이 메서드는 클라이언트가 요청한 방식에 따라 
    //       내부에 새로 추가한 메서드를 호출하게 프로그래밍 되어 있다.
    //    => 요청 방식과 호출되는 메서드 
    //       GET 요청     ---> doGet()
    //       POST 요청    ---> doPost()
    //       HEAD 요청    ---> doHead()
    //       PUT 요청     ---> doPut()
    //       등 
    //
    // 따라서 HttpServlet을 상속 받아 프로그래밍 할 때는
    // 굳이 직접 요청 메서드를 구분하지 말고,
    // HttpServlet이 미리 프로그래밍 되어 있는 대로 사용하라!
    // 즉 get 요청을 처리하고 싶다면 doGet()을 오버라이딩하고,
    // post 요청을 처리하고 싶다면 doPost()를 오버라이딩하라!
    //
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>계산기</h1>");
        out.println("<form action='Servlet04' method='POST'>");
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
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
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
        
        out.println("<a href='Servlet04'>다시 계산</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

















