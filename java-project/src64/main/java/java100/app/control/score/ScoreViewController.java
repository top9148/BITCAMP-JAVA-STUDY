package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@Component("/score/view")
public class ScoreViewController {
    
    @Autowired ScoreDao scoreDao;
    
    @RequestMapping
    public String view(
            @RequestParam("no") int no,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Score score = scoreDao.selectOne(no);
        request.setAttribute("score", score);
        return "/score/view.jsp";        
    }
}








