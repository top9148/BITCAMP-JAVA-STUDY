package java100.app.control.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/list")
public class BoardListController implements PageController {
    
    @Autowired BoardDao boardDao;
    
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        List<Board> list = boardDao.selectList();
        
        // 작업한 결과를 JSP에게 넘겨주기 위해 ServletRequest 보관소에 저장한다.
        request.setAttribute("list", list);
        
        return "/board/list.jsp";
        
    }
}








