// 세션(session) 
// => 클라이언트가 요청한 작업을 수행한 후 그 결과를 서버에 보관하는 방법
// => 서블릿에서 getSession() 호출하면 HttpSession 객체가 생성된다.
//    서블릿 컨테이너는 이 세션 객체를 내부에서 임의로 생성한 
//    문자열(세션ID라 부른다)을 사용하여 보관한다. 
//    그리고 클라이언트에 응답할 때 이 세션아이디를 쿠키로 보낸다.
// => 클라이언트는 세션아이디가 쿠키이기 때문에 
//    쿠키를 다루는 방식으로 저장하고 서버에 전송한다.
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
@WebServlet("/step12/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 세션을 생성한다.
        // 시나리오 1: 요청 헤더의 쿠키 값으로 세션 아이디가 넘어오지 않았다.
        //    => 새로 세션을 만들어서 리턴한다.
        //    => 물론 응답할 때 새로 만든 세션의 세션아이디를 보낸다.
        //
        // 시나리오 2: 요청 헤더의 쿠키 값으로 세션 아이디가 넘어 왔다.
        //    => 그 세션아이디로 기존에 생성했던 세션 객체를 찾아 리턴한다.
        //    => 이때는 응답할 때 세션아이디를 다시 보내지 않는다.
        //       왜? 이미 클라이언트가 알고 있지 않은가!
        //
        // 시나리오 3: 요청 헤더의 쿠키 값으로 세션아이디가 넘어 왔는데,
        //             세션의 유효기간(보통 5분 또는 30분)이 지났다.
        //    => 새로 세션을 만들어서 리턴한다.
        //    => 물론 기존의 세션 객체를 제거한다. 
        //       따라서 기존 세션 객체에 보관된 모든 데이터도 날아간다.
        //    => 새로 세션객체를 만들었기 때문에 응답할 때,
        //       세션아이디를 보내야 한다.
        // 참고!
        //    => JSP 페이지로 생성한 서블릿 클래스는 내부적으로 
        //       HttpSession 객체를 준비하기 때문에
        //       JSP 페이지를 요청하면 무조건 세션 객체가 생성된다.
        //       (물론 생성되어 있으면 기존 객체를 사용할 것이다.)
        HttpSession session = req.getSession();
        
        // HttpSession 보관소에 값을 저장한다.
        session.setAttribute("name", "홍길동");
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("세션을 생성하였고 그 세션아이디 값을 쿠키로 보냈음!");
        
        // 테스트 방법:
        // 1) 테스트할 때 사용할 웹브라우저를 모두 닫는다
        //    - 이유? 그래야 기존에 서버로부터 받은 세션아이디 쿠키 값이 제거된다.
        // 2) 새로 웹브라우저를 띄우고 /step12/Servlet01을 요청한다.
        //    - 새로 웹브라우저를 띄웠기 때문에 서버에 세션아이디 쿠키를 전송하지 않는다.
        // 3) 서버는 클라이언트로 부터 세션아이디를 받지 않았기 때문에 
        //    getSession()을 호출할 때 새로 HttpSession 객체를 생성한다.
        // 4) 클라이언트에게 응답할 때 쿠키로 세션아이디를 전송한다.
        //    - 응답 프로토콜에서 Set-Cookie 헤더의 값을 확인해보라!
        //    - 톰캣 서버의 경우 JSESSIONID라는 이름으로 보낸다.
        //    - 만약 기존에 생성한 세션을 사용한다면 
        //      응답할 때 세션아이디를 보내지 않는다.
    }
}

// 서버에서 클라이언트로 쿠키를 보내는 응답 프로토콜 예:
/*
HTTP/1.1 200
Set-Cookie: JSESSIONID=022E14E67FD0069DA79D87EF3F3F0147; Path=/bitcamp-java-web; HttpOnly
Content-Type: text/plain;charset=UTF-8
Content-Length: 74
Date: Wed, 27 Dec 2017 06:44:59 GMT
*/
// 응답 헤더의 쿠키 중에서 
// "JSESSIONID"라는 이름의 쿠키가 바로 톰캣 서버가 보낸 세션아이디이다.
// 주의!
// 세션아이디의 이름은 서버마다 다를 수 있다. 
// 서버에서 자신이 사용할 쿠키 이름을 보내는 것이기 때문에 
// 다를 수 있다.














