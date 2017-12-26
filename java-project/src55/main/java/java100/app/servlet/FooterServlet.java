package java100.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/footer")   
public class FooterServlet extends HttpServlet {
    
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
        out.println("<footer>");
        out.println("    비트캠프 자바100기@2017");
        out.println("</footer>");
    }
}













