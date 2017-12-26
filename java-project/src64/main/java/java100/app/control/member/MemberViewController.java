package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member/view")
public class MemberViewController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping
    public String view(
            @RequestParam("no") int no,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        Member member = memberDao.selectOne(no);
        request.setAttribute("member", member);
        return "/member/view.jsp";
    }
}








