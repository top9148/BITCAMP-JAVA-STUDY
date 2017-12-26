package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;

@Component("/member/form")
public class MemberFormController {
    
    @RequestMapping
    public String form(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        return "/member/form.jsp";
        
    }
}








