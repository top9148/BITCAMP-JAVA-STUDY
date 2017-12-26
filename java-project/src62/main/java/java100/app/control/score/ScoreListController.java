package java100.app.control.score;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@Component("/score/list")
public class ScoreListController implements PageController {
    
    @Autowired ScoreDao scoreDao;
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        List<Score> list = scoreDao.selectList();
        request.setAttribute("list", list);
        return "/score/list.jsp";
    }
}








