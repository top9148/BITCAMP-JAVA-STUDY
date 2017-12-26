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
@WebServlet(urlPatterns="/score/add")   
public class ScoreAddServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>성적관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>성적 상세 정보</h1>");

        out.println("<form method='post'>");
        out.println("<label for='name'>이름</label>");
        out.println("<input id='name' type='text' name='name'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='kor'>국어</label>");
        out.println("<input id='kor' type='number' name='kor'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='eng'>영어</label>");
        out.println("<input id='eng' type='number' name='eng'>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for='math'>수학</label>");
        out.println("<input id='math' type='number' name='math'>");
        out.println("</div>");
        out.println("<button>추가</button>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
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
        out.println("<h1>성적 등록 결과</h1>");

        try {
            Score score = new Score();
            score.setName(request.getParameter("name"));
            score.setKor(Integer.parseInt(request.getParameter("kor")));
            score.setEng(Integer.parseInt(request.getParameter("eng")));
            score.setMath(Integer.parseInt(request.getParameter("math")));

            scoreDao.insert(score);
            out.println("<p>저장하였습니다.</p>");

        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
        out.println("<p><a href='list'>목록</a></p>");
        out.println("</body>");
        out.println("</html>");
    }

}













