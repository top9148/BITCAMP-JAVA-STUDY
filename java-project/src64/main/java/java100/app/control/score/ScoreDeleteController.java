package java100.app.control.score;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.annotation.RequestMapping;
import java100.app.annotation.RequestParam;
import java100.app.dao.ScoreDao;

@Component("/score/delete")
public class ScoreDeleteController {
    
    @Autowired ScoreDao scoreDao;
    
    @RequestMapping
    public String delete(
            @RequestParam("no") int no,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        scoreDao.delete(no);
        return "redirect:list.do";
    }
}








