package java100.app.control.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.RoomDao;

@Component("/room/delete")
public class RoomDeleteController {
    
    @Autowired RoomDao roomDao;
    
    @RequestMapping
    public String delete(
            @RequestParam("no") int no,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        roomDao.delete(no);
        return "redirect:list.do";
    }
}








