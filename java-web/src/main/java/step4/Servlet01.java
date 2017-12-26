// 클라이언트로 텍스트 출력하기
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
@WebServlet("/step4/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // HttpServletResponse 객체에서 응답할 때 사용할 텍스트 출력 도구를 꺼낸다.
        PrintWriter out = res.getWriter();
        out.println("ABC가각간abc똘똠똥123");
        
        // 출력할 때 한글이 깨진다.
        // 이유?
        // - ServletResponse 객체에서 PrintWriter을 꺼내 출력하면,
        //   이 출력스트림은 기본으로 텍스트를 ISO-8859-1 문자표에 따라 
        //   유니코드를 해당 문자로 변환하여 출력한다.
        //   문제는 한글은 이 ISO-8859-1 문자표에 등록되어 있지 않기 때문에
        //   변환할 수 없어서 대신 '?'로 변환하여 출력한다.
        // - 해결책?
        //   다음 서블릿을 보라!
    }
}









