// 클라이언트로 텍스트 출력하기 - MIME 타입
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
@WebServlet("/step4/Servlet03")
public class Servlet03 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.println("<html><body><h1>Hello!</h1></body></html>");
        
        // MIME(Multi-purpose Internet Mail Extensions)
        // - 원래는 이메일을 전송할 때 8비트 이상으로 전송해야 하는 
        //   멀티 바이트 문자나 바이너리 문자를 위해 형식을 알려주려고 
        //   만들었다.
        // - 현재는 이메일 뿐만아니라 웹, 인터넷 전체에서 콘텐츠를 전송할 때
        //   그 콘텐츠가 무슨 콘텐츠인지 알려주기 위해 널리 사용되고 있다.
        // - 콘텐츠를 받는 쪽에서는 상대편이 알려준 MIME 타입의 정보를 
        //   바탕으로 받은 데이터를 어떻게 처리할 지 결정한다.
        //
        // 위의 경우를 보면, 
        // 텍스트를 출력할 때 단순 텍스트라고 지정했기 때문에
        // 웹브라우저 쪽에서는 그냥 단순 텍스트로 간주하여 출력한다.
        // 원래의 타입인 HTML 형식으로 출력하려면,
        // 웹브라우저에게 정확하게 MIME 타입을 전달해야 한다.
    }
}









