// 빼기(-) 연산을 수행하는 서블릿  
//
package step9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step9/MinusServlet")
public class MinusServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 포워딩 하기 전에 요청 데이터의 문자집합을 지정했으면,
        // 이 서블릿에서는 할 필요가 없다.
        //req.setCharacterEncoding("UTF-8");
        
        // 포워딩은 인클루딩과 달리 이전 서블릿에서 설정한 콘텐츠 타입을 
        // 사용하지 않는다. 따라서 이 서블릿에서는 새로 지정해야 한다.
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        
        out.printf("%d - %d = %d\n", a, b, a - b);
    }
}






















