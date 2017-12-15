package java100.app.servlet.score;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
        out.println("<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href='../css/common.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");

        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<h1>성적 상세 정보</h1>");

        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Score score = scoreDao.selectOne(no);
            
            if (score != null) {
                out.println("<form action='update' method='post'>");
                out.println("<div class='form-group row'>");
                out.println("<label for='no' class='col-sm-2 col-form-label'>번호</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' readonly id='no' type='number' name='no' value='%d'>\n", 
                            score.getNo());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='name' class='col-sm-2 col-form-label'>이름</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' id='name' type='text' name='name' value='%s'>\n", 
                            score.getName());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='kor' class='col-sm-2 col-form-label'>국어</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' id='kor' type='number' name='kor' value='%d'>\n", 
                            score.getKor());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='eng' class='col-sm-2 col-form-label'>영어</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' id='eng' type='number' name='eng' value='%d'>\n", 
                            score.getEng());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='math' class='col-sm-2 col-form-label'>수학</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' id='math' type='number' name='math' value='%d'>\n", 
                            score.getMath());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='sum' class='col-sm-2 col-form-label'>합계</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' readonly id='sum' type='text' value='%d'>\n", 
                            score.getSum());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<label for='aver' class='col-sm-2 col-form-label'>평균</label>");
                out.println("<div class='col-sm-10'>");
                out.printf("<input class='form-control' readonly id='aver' type='text' value='%.1f'>\n", 
                            score.getAver());
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='form-group row'>");
                out.println("<div class='col-sm-10'>");
                out.println("<button class='btn btn-primary btn-sm'>변경</button>");
                out.printf("<a href='delete?no=%d' class='btn btn-primary btn-sm'>삭제</a>\n", score.getNo());
                out.println("</div>");
                out.println("</div>");
                out.println("</form>");
                
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }

        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
        out.println("</div>");
        
        out.println("<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>");
        out.println("<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>");
        out.println("<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}













