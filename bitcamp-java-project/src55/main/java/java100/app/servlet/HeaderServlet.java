package java100.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/header")   
public class HeaderServlet extends HttpServlet {
    
    // 인클루딩 할 때,
    // 이전 서블릿이 GET 요청을 받았으면 같은 GET 방식으로 인클루딩한다.
    // 이전 서블릿이 POST 요청을 받았으면 같은 POST 방식으로 인클루딩한다.
    // 그래서,
    // 인클루딩 되는 서블릿은 GET/POST 요청 모두에 대응할 수 있도록
    // 가능한 service()를 오버라이딩하라!
    //
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("<header>");
        out.println("<nav class='navbar navbar-expand-lg navbar-light bg-light'>");
        out.println("<a class='navbar-brand' href='../index.html'>");
        out.println("  <img src='../images/bootstrap-solid.svg' width='30' height='30' class='d-inline-block align-top' alt=''>");
        out.println("  비트캠프");
        out.println("</a>");
        out.println("<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>");
        out.println("  <span class='navbar-toggler-icon'></span>");
        out.println("</button>");
        out.println("<div class='collapse navbar-collapse' id='navbarNav'>");
        out.println("<ul class='navbar-nav'>");
        out.println("  <li class='nav-item'>");
        out.println("    <a class='nav-link' href='../score/list'>성적</a>");
        out.println("  </li>");
        out.println("  <li class='nav-item'>");
        out.println("    <a class='nav-link' href='../member/list'>회원</a>");
        out.println("  </li>");
        out.println("  <li class='nav-item'>");
        out.println("    <a class='nav-link' href='../board/list'>게시판</a>");
        out.println("  </li>");
        out.println("  <li class='nav-item'>");
        out.println("    <a class='nav-link' href='../room/list'>강의실</a>");
        out.println("  </li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</nav>");
        out.println("</header>");
    }
}













