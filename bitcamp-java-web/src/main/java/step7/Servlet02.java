// 동적 자원(dynamic resource)란?
// - 서블릿에서 작업을 수행한 후 그 결과에 따라 동적으로 생성하는 
//   HTML 등을 말한다.
// - HTML 파일을 한 번 작성하면 변경되지 않지만,
//   Servlet은 실행할 때마다 다른 HTML을 만들 수 있다.
//   이것이 서블릿을 사용하는 이유이다.
//
// 정적 자원(static resource)?
// - HTML, CSS, JavaScript, Image 파일처럼 그대로 읽어서 클라이언트로 
//   보내는 콘텐츠를 말한다.
//
package step7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step7/Servlet02")
public class Servlet02 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 계산 결과를 출력하는 HTML을 만들어보자!
        // 1) 클라이언트가 보낸 데이터를 꺼낸다.
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        String op = req.getParameter("op");
        
        // 2) 클라이언트가 보낸 값으로 계산을 수행한 후 그 결과를 
        //    HTML로 만들어 다시 클라이언트로 보낸다.
        //
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>계산 결과</h1>");
        out.println("<p>");
        out.printf("%d %s %d = ", a, op, b);
        
        switch (op) {
        case "+": out.println(a + b); break;
        case "-": out.println(a - b); break;
        case "*": out.println(a * b); break;
        case "/": out.println(a / b); break;
        case "%": out.println(a % b); break;
        default: out.println("지원하지 않는 연산자 입니다!");
        }
        out.println("<p>");
        out.println("</body>");
        out.println("</html>");
        
        // 이 서블릿을 테스트하기 위해 URL을 입력할 때 
        // 다음과 같이 -, *, / 연산자는 정상적으로 수행된다.
        // 예) http://localhost:9999/java-web/step7/Servlet02?a=20&b=15&op=-
        //
        // 그런데 +, % 의 경우는 예상한 대로 동작하지 않는다.
        // 예) http://localhost:9999/java-web/step7/Servlet02?a=20&b=15&op=+
        // 그 이유는 무엇인가?
        // - URL에 포함되는 문자 중에서 특별한 의미를 지니는 문자가 있다.
        // - 예를 들어 '+' 문자는 서버에 한 개의 공백(space) 문자를 보낼 때
        //   사용한다.
        // - '%'는 한글과 같은 멀티 바이트 문자를 서버에 보낼 때 
        //   URL 인코딩을 표시하는 문자이다.
        // - 따라서 이런 문자를 서버에서 받으면 '+'는 공백으로 바꾸고,
        //   '%'는 URL 디코딩 명령으로 인식하기 때문에 
        //   우리가 원하는 결과를 얻을 수 없다.
        // 
        // 해결책
        // - URL에 포함될 때 특별한 의미를 지니는 문자인 경우 
        //   직접 URL 인코딩하여 보내라!
        // - 예) '+' 문자는 '%2B'로 작성하여 보내고,
        //       '%' 문자는 '%25'로 작성하여 보낸다.
    }
}









