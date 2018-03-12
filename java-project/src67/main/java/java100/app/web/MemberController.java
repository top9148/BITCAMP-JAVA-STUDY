package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired MemberDao memberDao;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="word", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("words", words);
        params.put("orderColumn", orderColumn);
        params.put("align", align);
        
        model.addAttribute("list", memberDao.findAll(params));
        return "member/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("member", memberDao.findByNo(no));
        return "member/view";
    }
    
    @RequestMapping("add")
    public String add(Member member) throws Exception {
        
        memberDao.insert(member);
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "member/form";
        
    }
    
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        
        memberDao.update(member);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        memberDao.delete(no);
        return "redirect:list";
    }
}








