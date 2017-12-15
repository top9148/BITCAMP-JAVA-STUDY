package java100.app.servlet.score;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/score/view")   
public class ScoreViewServlet extends HttpServlet {
    
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(
                ScoreDao.class);
        
        response.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("[성적 상세 정보]");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Score score = scoreDao.selectOne(no);
            
            if (score != null) {
                out.printf("번호: %d\n", score.getNo());
                out.printf("이름: %s\n", score.getName());
                out.printf("국어: %d\n", score.getKor());
                out.printf("영어: %d\n", score.getEng());
                out.printf("수학: %d\n", score.getMath());
                out.printf("합계: %d\n", score.getSum());
                out.printf("평균: %.1f\n", score.getAver());
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
}













