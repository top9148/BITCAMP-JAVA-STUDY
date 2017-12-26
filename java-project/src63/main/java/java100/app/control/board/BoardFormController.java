package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;

@Component("/board/form")
public class BoardFormController {
    
    @RequestMapping
    public String form(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/board/form.jsp";
        
    }
}








