package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;

public class RoomController implements Controller {
    
    RoomDao roomDao = new RoomDao();
    
    @Override
    public void destroy() {}
    
    @Override
    public void init() {}
    
    
    @Override
    public void execute(Request request, Response response) {
        switch (request.getMenuPath()) {
        case "/room/list": this.doList(request, response); break;
        case "/room/add": this.doAdd(request, response); break;
        case "/room/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");
        
        try {
            List<Room> list = roomDao.selectList();
            
            for (Room room : list) {
                out.printf("%d, %s, %s, %d\n", 
                        room.getNo(),
                        room.getLocation(),
                        room.getName(),
                        room.getCapacity());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doAdd(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[강의실 등록]");
        
        try {
            Room room = new Room();
            room.setLocation(request.getParameter("location"));
            room.setName(request.getParameter("name"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            
            roomDao.insert(room);
            
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doDelete(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[강의실 삭제]");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));
            
            if (roomDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'의 강의실 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
}










