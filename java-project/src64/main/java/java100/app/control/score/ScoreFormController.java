package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;

@Component("/score/form")
public class ScoreFormController {
    
    @RequestMapping
    public String form(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/score/form.jsp";
    }
}








