// 쿠키(cookie)의 사용 기간 지정하기 
// => 쿠키의 사용기간을 지정하지 않으면 
//    웹브라우저가 실행되는 동안만 유지된다.
//    웹브라우저를 모두 닫으면 쿠키는 소멸된다.
// => 사용 기간을 지정하면,
//    그 기간동안은 보존되어 서버에 요청할 때 보내진다.
// => 사용 기간이 지난 쿠키는 웹브라우저가 제거한다.
// => 쿠키는 PC의 저장되기 때문에 보안에 취약하다.
//    각 웹브라우저마다 암호화 하여 저장하지만,
//    인터넷에 그 암호를 푸는 프로그램들이 존재한다.
//    따라서 암호와 같이 보안을 요구하는 데이터는 쿠키로 저장해서는 안된다.
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
@WebServlet("/step11/Servlet06")
public class Servlet06 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 사용 기간을 지정하지 않을 경우,
        //
        res.addCookie(new Cookie("name", "hong"));
      
        // 사용 기간을 30초 지정할 경우, 
        //
        Cookie cookie = new Cookie("age", "20");
        cookie.setMaxAge(30); // 30초
        res.addCookie(cookie);
        
        // 사용 기간을 1분으로 지정할 경우,
        //
        cookie = new Cookie("working", "true");
        cookie.setMaxAge(60); // 60초
        res.addCookie(cookie);
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
        
        // 테스트 방법:
        // 1) 웹브라우저를 모두 닫아라!
        //    - 그러면 기존에 보낸 쿠키 데이터가 지워진다.
        // 2) 웹브라우저를 새로 띄우고 쿠키를 보낸다.
        //    - /step11/Servlet06 요청
        // 3) 쿠키를 확인한다. 
        //    - /step11/Servlet02를 요청
    }
}

// 쿠키의 사용 기간이 설정되었을 경우 
// 서버에서 보내는 예:
/*
HTTP/1.1 200
Set-Cookie: name=hong
Set-Cookie: age=20; Max-Age=30; Expires=Wed, 27-Dec-2017 05:25:05 GMT
Set-Cookie: working=true; Max-Age=60; Expires=Wed, 27-Dec-2017 05:25:35 GMT
Content-Type: text/plain;charset=UTF-8
Content-Length: 21
Date: Wed, 27 Dec 2017 05:24:35 GMT
*/













