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
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(
                ScoreDao.class);
        
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>성적관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>성적 상세 정보</h1>");

        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Score score = scoreDao.selectOne(no);
            
            if (score != null) {
                out.println("<form action='update' method='post'>");
                out.println("<div>");
                out.println("<label for='no'>번호</label>");
                out.printf("<input readonly id='no' type='number' name='no' value='%d'>\n", 
                            score.getNo());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='name'>이름</label>");
                out.printf("<input id='name' type='text' name='name' value='%s'>\n", 
                            score.getName());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='kor'>국어</label>");
                out.printf("<input id='kor' type='number' name='kor' value='%d'>\n", 
                            score.getKor());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='eng'>영어</label>");
                out.printf("<input id='eng' type='number' name='eng' value='%d'>\n", 
                            score.getEng());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='math'>수학</label>");
                out.printf("<input id='math' type='number' name='math' value='%d'>\n", 
                            score.getMath());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='sum'>합계</label>");
                out.printf("<input readonly id='sum' type='text' value='%d'>\n", 
                            score.getSum());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='aver'>평균</label>");
                out.printf("<input readonly id='aver' type='text' value='%.1f'>\n", 
                            score.getAver());
                out.println("</div>");
                out.println("<button>변경</button>");
                out.printf("<a href='delete?no=%d'>삭제</a>\n", score.getNo());
                out.println("</form>");
                
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
        out.println("</body>");
        out.println("</html>");
    }
}













