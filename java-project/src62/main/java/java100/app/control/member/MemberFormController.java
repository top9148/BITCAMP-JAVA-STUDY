package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.control.PageController;

@Component("/member/form")
public class MemberFormController implements PageController {
    
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/member/form.jsp";
        
    }
}








