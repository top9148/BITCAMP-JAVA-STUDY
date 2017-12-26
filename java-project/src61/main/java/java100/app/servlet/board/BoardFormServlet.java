package java100.app.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/form")
@SuppressWarnings("serial")
public class BoardFormServlet extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        request.setAttribute("viewName", "/board/form.jsp");
        
    }
}








