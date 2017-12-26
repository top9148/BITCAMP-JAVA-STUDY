// 다른 서블릿의 실행을 포함하기 - including 
//
package step9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step9/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>포함</title>");
        out.println("</head>");
        out.println("<body>");
        
        // RequestDispatcher 객체를 이용하면 
        // 다른 서블릿의 실행 결과를 포함할 수 있다.
        // => ServletRequest.getRequestDispatcher("다른 서블릿의 URL")
        //
        RequestDispatcher rd = req.getRequestDispatcher("/step9/HeaderServlet");
        rd.include(req, res);
        // 서블릿 실행을 마치면 다시 이 서블릿으로 리턴한다. 
        
        out.println("<h1>Servlet01</h1>");
        out.println("<p>이 출력은 Servlet01에서 만든 것이다.</p>");
        
        // FooterServlet의 실행을 요청한다.
        rd = req.getRequestDispatcher("/step9/FooterServlet");
        rd.include(req, res); // 실행을 마치면 리턴한다.
        
        out.println("</body>");
        out.println("</html>");
    }
}






















