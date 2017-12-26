// GET과 HEAD 요청 구분하기 
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet06")
public class Servlet06 extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        System.out.println("GET 요청 들어왔음!");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("hello!");
    }
    
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        System.out.println("HEAD 요청 들어왔음!");
        
        // HEAD 요청은 응답을 하지 않는다.
        // 따라서 다음 출력은 클라이언트로 보내지 않는다.
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("hello!");
    }
}

















