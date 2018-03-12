// 세션(session) - 요청과 요청 사이에 데이터 공유하기 II 
// 
package step12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step12/Servlet05")
public class Servlet05 extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        
        // 세션 객체를 준비한다.
        // => 기존에 생성된 객체이든, 새로 만든 객체이든 준비한다.
        HttpSession session = req.getSession();
        
        // 클라이언트가 보낸 파라미터 값을 세션 보관소에 저장한다.
        String working = req.getParameter("working");

        if (working != null) {
            session.setAttribute("working", working);
        } else {
            // 기존에 저장된 값을 지운다.
            session.removeAttribute("working");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/step12/result.jsp");
        rd.forward(req, res);
    }
}














