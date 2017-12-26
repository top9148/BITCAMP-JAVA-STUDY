// 웹 애플리케이션 멤버 - Servlet
//
package step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet은 클라이언트 요청을 처리하는 일을 담당한다.
// 
@SuppressWarnings("serial")
@WebServlet("/step3/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("step3.Servlet02.service()");
    }
}









