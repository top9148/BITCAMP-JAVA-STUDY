package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        boardDao.delete(no);
        
        return "redirect:list.do";
    }
}








