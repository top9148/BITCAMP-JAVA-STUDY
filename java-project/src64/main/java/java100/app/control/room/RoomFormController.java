package java100.app.control.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;

@Component("/room/form")
public class RoomFormController {
    
    @RequestMapping
    public String form(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/room/form.jsp";
        
    }
}








