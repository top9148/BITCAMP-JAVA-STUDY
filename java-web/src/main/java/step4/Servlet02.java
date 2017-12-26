// 클라이언트로 텍스트 출력하기 - 한글 깨짐 해결
//
package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step4/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // ServletResponse 객체에서 텍스트 출력 도구를 꺼내기 전에
        // 출력할 때 어떤 콘텐츠를 출력할 것이고,
        // 어떤 문자표를 사용하여 변환할 것인지
        // 먼저 설정하라!
        // 주의!
        // 반드시 출력 스트림을 꺼내기 전에 먼저 호출해야 한다.
        // getWriter()를 호출한 다음에 다음 메서드를 호출해봐야 소용없다.
        //
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("ABC가각간abc똘똠똥123");
        
    }
}









