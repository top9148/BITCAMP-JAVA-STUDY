package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/add")
public class BoardAddController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping
    public String add(
            Board board,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        boardDao.insert(board);
        return "redirect:list.do";
    }
}








