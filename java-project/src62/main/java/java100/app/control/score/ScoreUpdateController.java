package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.ScoreDao;
import java100.app.domain.Score;

@Component("/score/update")
public class ScoreUpdateController implements PageController {
    
    @Autowired ScoreDao scoreDao;
    
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        Score score = new Score();
        score.setNo(Integer.parseInt(request.getParameter("no")));
        score.setName(request.getParameter("name"));
        score.setKor(Integer.parseInt(request.getParameter("kor")));
        score.setEng(Integer.parseInt(request.getParameter("eng")));
        score.setMath(Integer.parseInt(request.getParameter("math")));
        
        scoreDao.update(score);
        
        return "redirect:list.do";
    }
}








