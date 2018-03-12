// 쿠키(cookie) 값으로 한글을 사용하기
// => 쿠키 이름과 값은 반드시 ISO-8859-1 이어야 한다.
//    그외 문자는 UTF-8로 인코딩하여 저장하라!
// 
package step11;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet07")
public class Servlet07 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 쿠키 이름을 한글로 작성할 경우,
        //res.addCookie(new Cookie("이름", "hong")); // 오류 발생!
      
        // 쿠키 값을 한글로 작성할 경우,
        // => 보내지지만, UTF-8 형식으로 전달된다.
        //    즉 7비트를 초과하는 값이 전달된다.
        //    문제는 네트웍 장비 중에 8비트를 처리하지 못하는 경우
        //    데이터가 손실될 수 있다.
        // => 해결책?
        //    ISO-8859-1로 표현하지 못하는 데이터는 URL 인코딩을 하여 보내라!
        //
        //res.addCookie(new Cookie("name", "홍길동"));
        res.addCookie(new Cookie("name", URLEncoder.encode("ABC123홍길동", "UTF-8")));
        // URLEncoder.encode("홍길동", "UTF-8")의 동작 과정
        // 1) 유니코드 2바이트로 된 "홍길동"을 UTF-8 형식으로 변환한다.
        //    d64d ae38 b3d9 ==> ed998d eab8b8 eb8f99
        // 2) UTF-8 코드를 ASCII 문자로 변환한다.
        //    "%ED%99%8D%EA%B8%B8%EB%8F%99"
        // 주의!
        // => 저장할 때 값을 URL 인코딩하였다면,
        //    꺼낼 때도 그냥 꺼내지 말고 꺼낸 데이터를 URL 디코딩 해야 한다.
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("쿠키를 보냈음!");
        
        // 테스트 방법:
        // 1) 웹브라우저를 모두 닫아라!
        //    - 그러면 기존에 보낸 쿠키 데이터가 지워진다.
        // 2) 웹브라우저를 새로 띄우고 쿠키를 보낸다.
        //    - /step11/Servlet07 요청
        // 3) 쿠키를 확인한다. 
        //    - /step11/Servlet02를 요청 (URL 디코딩을 하지 않은 경우)
        //    - /step11/Servlet08을 요청 (URL 디코딩 한 경우)
    }
}

// 쿠키의 값을 URL 인코딩 한 경우, 
// 서버에서 보내는 예:
/*
HTTP/1.1 200
Set-Cookie: name=ABC123%ED%99%8D%EA%B8%B8%EB%8F%99
Content-Type: text/plain;charset=UTF-8
Content-Length: 21
Date: Wed, 27 Dec 2017 05:57:46 GMT
*/













