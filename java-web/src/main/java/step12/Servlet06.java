// 세션(session) 무효화 시키기 
// 
package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step12/Servlet06")
public class Servlet06 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 세션을 무효화시키는 방법 
        // 1) 클라이언트 쪽에서 모든 웹브라우저를 닫기
        //    - 모든 웹브라우저가 종료되면 메모리에 보관되어 있는
        //      쿠키 값들이 모두 제거된다.
        //    - 세션아이디는 사용기간이 지정되지 않았기 때문에
        //      메모리에 보관된다.
        //    - 따라서 모든 웹브라우저를 닫으면 세션아이디도 잃게 된다.
        //    - 그러면 다음에 웹브라우저가 서버에 요청할 때 
        //      세션아이디를 보낼 수 없기 때문에 
        //      서버 입장에서는 새로 HttpSession을 만들 수 밖에 없다.
        //    - 결국 기존 세션 객체가 무효화 된 것이다.
        //
        // 2) 세션의 타임아웃 시간을 경과할 경우
        //    - 서버에 마지막으로 요청한 시각에서 
        //      서버에 설정된 타임아웃 시간까지 요청이 없을 때
        //      서버는 세션을 무효화시킨다.
        //    - 타임아웃 시간은 서버 설정 파일에 지정한다.
        //    - 서버마다 설정하는 방법이 다르니 매뉴얼을 참고하라!
        // 
        // 3) 프로그램 코드를 명확하게 세션을 무효화하기 
        //    - 다음 코드를 보라!     
        HttpSession session = req.getSession();
        session.invalidate(); // 세션을 무효화 하라!
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("세션을 무효화했습니다!");
    }
}














