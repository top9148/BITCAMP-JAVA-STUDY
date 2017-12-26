package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/view")
public class BoardViewController {
    
    @Autowired BoardDao boardDao;
    
    @RequestMapping
    public String view(
            @RequestParam("no") int no,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        Board board = boardDao.selectOne(no);
        request.setAttribute("board", board);
        return "/board/view.jsp";
        
    }
}








