// 쿠키(cookie)의 사용 범위를 지정하기 
// => 쿠키의 사용범위를 지정하지 않으면 기본으로 
//    그 쿠키를 보낸 서블릿의 경로에 한정 된다.
//    물론 그 하위 경로를 포함한다.
// => 쿠키의 사용 범위를 지정하면 
//    그 쿠키를 보낸 서블릿의 경로와 다르더라도 쿠키를 받을 수 있다.
// 
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet05")
public class Servlet05 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 기본 경로
        // 즉 /step11/* 서블릿만 name을 받을 수 있다.
        // "야! 웹브라우저야 지금 내가 보내는 name 쿠키 데이터는 
        //  다음에 같은 경로 또는 그 하위 경로(/bitcamp-java-web/step11/*)로 
        //  요청하는 경우에 보내다오!"
        //
        res.addCookie(new Cookie("name", "hong"));
      
        // 모든 경로(/)의 서블릿들이 쿠키를 받을 수 있도록 조정하기
        // "야! 웹브라우저야 지금 내가 보내는 age 쿠키 값은
        //  /* 경로에 해당되는 모든 요청에 대해 보내다오!" 
        //
        Cookie cookie = new Cookie("age", "20");
        cookie.setPath("/");
        res.addCookie(cookie);
        
        // 특정 경로(/bitcamp-java-web/other/)의 서블릿만이 쿠키를 받을 수 있도록 설정하기
        // "야! 웹브라우저야 working 쿠키 데이터를 잘 보관하고 있다가
        //  다음에 /bitcamp-java-web/other/* 요청을 할 때 보내거라!"
        //
        cookie = new Cookie("working", "true");
        cookie.setPath("/bitcamp-java-web/other/");
        res.addCookie(cookie);
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
        
        // 테스트 방법:
        // 1) 웹브라우저를 모두 닫아라!
        //    - 그러면 Servlet01에서 보낸 쿠키 데이터가 지워진다.
        // 2) 웹브라우저를 새로 띄우고 쿠키가 없음을 확인하라!
        //    - /step11/Servlet02 요청
        //    - /step11/other/Servlet03 요청
        //    - /other/Servlet04 요청
        // 3) /step11/Servlet05를 요청하라!
        //    - 웹브라우저는 사용 범위가 정해진 쿠키를 받아서 보관한다.
        // 3) Servlet02, Sevlet03, Servlet04를 실행하여 
        //    출력되는 쿠키 데이터를 확인하라!
    }
}

// 쿠키의 사용 범위가 설정되었을 경우 
// 서버에서 보내는 예:
/*
HTTP/1.1 200
Set-Cookie: name=hong
Set-Cookie: age=20; Path=/
Set-Cookie: working=true; Path=/bitcamp-java-web/other/
Content-Type: text/plain;charset=UTF-8
Content-Length: 21
Date: Wed, 27 Dec 2017 03:55:05 GMT
*/













