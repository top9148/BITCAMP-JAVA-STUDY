package java100.app.servlet.room;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/room/delete")
@SuppressWarnings("serial")
public class RoomDeleteServlet extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(
                RoomDao.class);
        int no = Integer.parseInt(request.getParameter("no"));
        
        roomDao.delete(no);
        
        // 다시 목록 페이지를 요청하라고 응답한다.
        response.sendRedirect("list");
    }
}








