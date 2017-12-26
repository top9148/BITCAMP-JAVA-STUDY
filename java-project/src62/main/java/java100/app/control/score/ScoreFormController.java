package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.control.PageController;

@Component("/score/form")
public class ScoreFormController implements PageController {
    
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/score/form.jsp";
    }
}








