package java100.app.servlet.room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/room/list")
public class RoomListServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(
                RoomDao.class);
        

        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>강의실관리</title>");
        out.println("<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href='../css/common.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");

        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<h1>강의실 목록</h1>");

        out.println("<p><a href='add' class='btn btn-primary btn-sm'>추가</a></p>");
        
        out.println("<table class='table table-hover'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th><th>지역</th><th>강의실명</th><th>수용인원</th><th>삭제</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        
        try {
            List<Room> list = roomDao.selectList();
            
            for (Room room : list) {
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td>"
                        + "<td>%d</td><td><a href='delete?no=%d' class='btn btn-danger btn-sm'>삭제</a></td></tr>\n",
                        room.getNo(),
                        room.getLocation(),
                        room.getName(),
                        room.getCapacity(),
                        room.getNo());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
        out.println("</tbody>");
        out.println("</table>");

        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
        out.println("</div>");
        
        out.println("<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>");
        out.println("<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>");
        out.println("<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}










