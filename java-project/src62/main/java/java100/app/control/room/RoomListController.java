package java100.app.control.room;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.RoomDao;
import java100.app.domain.Room;

@Component("/room/list")
public class RoomListController implements PageController {
    
    @Autowired RoomDao roomDao;
    
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        List<Room> list = roomDao.selectList();
        
        // 작업한 결과를 JSP에게 넘겨주기 위해 ServletRequest 보관소에 저장한다.
        request.setAttribute("list", list);
        
        return "/room/list.jsp";
        
    }
}








