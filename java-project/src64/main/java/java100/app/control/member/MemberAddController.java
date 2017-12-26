package java100.app.control.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Component("/member/add")
public class MemberAddController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping
    public String add(
            Member member,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        memberDao.insert(member);
        return "redirect:list.do";
    }
}








