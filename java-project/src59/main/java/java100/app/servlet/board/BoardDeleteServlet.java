package java100.app.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.BoardDao;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/board/delete")
@SuppressWarnings("serial")
public class BoardDeleteServlet extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDao boardDao = ContextLoaderListener.iocContainer.getBean(
                BoardDao.class);
        int no = Integer.parseInt(request.getParameter("no"));
        int count = boardDao.delete(no);
        
        // 작업한 결과를 JSP에게 넘겨주기 위해 ServletRequest 보관소에 저장한다.
        request.setAttribute("count", count);
        
        // 이 값을 출력할 JSP로 인클루딩한다.
        // => 인클루드를 실행하는 쪽에서 콘텐츠 타입을 설정해야 한다.
        // => 인클루드 되는 쪽에서는 여기에서 설정한 것을 그대로 따른다.
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/board/delete.jsp");
        rd.include(request, response);
        
    }
}








