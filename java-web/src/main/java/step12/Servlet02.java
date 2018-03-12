// 세션(session) - 기존 세션 사용하기 
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
@WebServlet("/step12/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 이 서블릿을 실행할 때
        // 클라이언트가 세션ID를 요청헤더에 포함하여 쿠키로 보냈다면,
        // 그리고 세션아이디가 유효하다면 
        // 다음 getSession() 리턴하는 것은 기존의 HttpSession 객체이다.
        //
        HttpSession session = req.getSession();
        
        // 기존의 HttpSession에서 값을 꺼낸다.
        String name = (String)session.getAttribute("name");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", name);
        
        // 테스트 방법:
        // 1) 먼저 /step12/Servlet01을 요청한다.
        //    - 새로 세션객체를 생성한다.
        //    - 물론 기존에 생성된 세션이 있다면 그 세션을 사용할 것이다.
        //    - 세션 객체에 "name"이라는 key로 값을 저장할 것이다.
        // 2) /step12/Servlet02를 요청한다. 
        //    - 기존에 생성된 HttpSession 객체를 꺼낸다.
        //    - 세션 보관소에서 "name"이라는 key로 저장된 값을 꺼낸 출력한다.
    }
}

// 참고!
// => 클라이언트의 세션을 구분할 때 세션아이디를 사용한다.
// => 이 세션아이디는 쿠키로 주고 받는다.
// => 따라서 쿠키 기능을 막으면 세션을 구분할 수 없기 때문에
//    세션을 이용하는 모든 기능을 수행할 수 없다.
// => 예를 들면 로그인 기능을 사용할 수 없다.













