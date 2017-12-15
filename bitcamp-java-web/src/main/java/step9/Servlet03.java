// 다른 서블릿에게 요청을 떠넘기기 - forwarding II  
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
@WebServlet("/step9/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        
        // forwarding을 이용하여 다른 서블릿으로 요청을 넘기면,
        // 현재 서블릿에서 버퍼로 출력한 내용은 버려진다.
        // => 서블릿에서 출력하는 내용은 내부의 버퍼에 임시 보관된다.
        // => service() 메서드 호출이 끝나면 그때서야 버퍼에 보관된 내용을
        //    한 번에 클라이언트로 보낸다.
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("Servlet03에서 출력하였음.");
        
        RequestDispatcher rd = req.getRequestDispatcher("/step9/OtherServlet");
        rd.forward(req, res);
    }
}






















