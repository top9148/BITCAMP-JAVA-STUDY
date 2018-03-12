package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="title", required=false) String[] titles,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

        HashMap<String,Object> params = new HashMap<>();
        params.put("titles", titles);
        params.put("orderColumn", orderColumn);
        params.put("align", align);
        
        model.addAttribute("list", boardDao.findAll(params));
        return "board/list";
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        boardDao.updateViewCount(no);
        model.addAttribute("board", boardDao.findByNo(no));
        return "board/view";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "board/form";
        
    }
    
    @RequestMapping("add")
    public String add(Board board) throws Exception {
        
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        
        boardDao.update(board);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        boardDao.delete(no);
        return "redirect:list";
    }
    
    
}








