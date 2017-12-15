package java100.app.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(
                MemberDao.class);
        
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>회원관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>회원 상세 정보</h1>");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));
            Member member = memberDao.selectOne(no);
            
            if (member != null) {
                out.println("<form action='update' method='post'>");
                out.println("<div>");
                out.println("<label for='no'>번호</label>");
                out.printf("<input readonly id='no' type='number' name='no' value='%d'>\n", 
                            member.getNo());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='name'>이름</label>");
                out.printf("<input id='name' type='text' name='name' value='%s'>\n", 
                            member.getName());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='email'>이메일</label>");
                out.printf("<input id='email' type='email' name='email' value='%s'>\n", 
                            member.getEmail());
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='password'>암호</label>");
                out.println("<input id='password' type='password' name='password'>");
                out.println("</div>");
                out.println("<div>");
                out.println("<label for='regdate'>등록일</label>");
                out.printf("<input readonly id='regdate' type='date' value='%s'>\n", 
                            member.getCreatedDate());
                out.println("</div>");
                out.println("<div>");
                out.println("<button>변경</button>");
                out.printf("<a href='delete?no=%d'>삭제</a>\n", member.getNo());
                out.println("</form>");
            } else {
                out.printf("<p>'%d'번의 회원 정보가 없습니다.</p>\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
        out.println("</body>");
        out.println("</html>");
    } 
}










