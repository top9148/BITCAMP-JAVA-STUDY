// GET/POST 요청 처리하기
//
package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step8/Servlet01")
public class Servlet01 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // POST 요청으로 받은 데이터의 경우 
        // 클라이언트가 어떤 문자집합을 사용하여 보냈는지 알아야 한다.
        // 그래야 서블릿에서 제대로 String 객체로 변환할 수 있다.
        req.setCharacterEncoding("UTF-8");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>GET/POST 요청 처리</title>");
        out.println("</head>");
        out.println("<body>");
        
        // 클라이언트가 요청한 방식을 알고 싶다면 
        // HttpServletRequest의 getMethod()를 호출하라!
        out.printf("<h1>%s 요청</h1>\n", req.getMethod());
        out.printf("name=%s<br>\n", req.getParameter("name"));
        out.printf("age=%s<br>\n", req.getParameter("age"));
        out.println("</body>");
        out.println("</html>");
    }
}

// GET vs POST
// [GET 요청]
// - 특징
//   => 데이터를 보낼 때 URL에 붙여 보낸다.
//   => 서버에 보내는 데이터가 웹 브라우저의 URL 주소창에 보인다.
//      => URL은 웹 브라우저에서 방문 내역에 보관한다.
//      => 누구든 그 전에 방문한 페이지와 데이터를 볼 수 있다.
//      => 로그인과 같은 보안을 요구하는 경우 GET이 맞지 않다.
///  => 페이지 주소와 보내는 데이터를 묶어 보관하거나 전달하기 쉽다.
//      => 다른 사람에게 특정 페이지의 링크를 쉽게 보낼 수 있다.
//      => 즐겨 찾기나 북마크로 해당 페이지의 주소를 저장할 수 있다.
//   => 데이터를 보낼 때 URL에 붙여 보내기 때문에 바이너리 데이터를 보낼 수 없다.
//      => 만약 바이너리 데이터를 보내려면 Base64와 같은 인코딩 방식을 사용하여
//         바이너리를 텍스트로 변환시켜 보내야 한다.
//   => 웹서버 중에는 HTTP Request-line의 크기를 8KB로 제한하는 서버가 있다.
//      그런 경우 바이너리 데이터를 보내더라도 크기에 제약이 생기기 때문에
//      바이너리 데이터를 보내기에 적합하지 않다.
//   => 그러나 최근에 RESTful 방식으로 동작시키는 웹 애플리케이션이 많다 보니,
//      request-line이나 요청 헤더의 최대 크기를 더 높인 경우가 많다.
//      그리고 웹서버 관리자가 제한하는 크기에 따라 더 커질 수 있다. 
//      * RESTFul 방식에서는 서버에 데이터를 보낼 때 요청 헤더에 붙여서 
//        보낸다.
// - 특징 요약
//   => URL에 데이터를 붙인다.
//   => 웹브라우저창에 데이터가 노출되어 보안에 안좋다.
//   => 서버에 바이너리 데이터를 보낼 수 없다.
//   => 보내는 데이터의 크기에 제약이 있다.
// - 용도
//   => 게시물 조회 페이지 링크
//   => 검색어처럼 URL에 포함시켜야 할 때 
//   => 즐겨 찾기나 북마크에 포함시키고 싶을 때 
// 
// [POST 요청]
// - 특징
//   => 데이터를 보낼 때 message-body 영역에 보낸다.
//   => 서버에 보내는 데이터가 웹 브라우저의 URL 주소창에 보이지 않는다.
//      => 웹 브라우저가 방문 내역을 저장할 때, 
//         서버에 보내는 데이터는 저장하지 않는다.
//      => 다른 사용자가 이전 사용자가 방문한 페이지는 볼 수 있어도 
//         보낸 데이터를 알 수 없다.
//   => 페이지 주소와 보내는 데이터를 묶어 보관할 수 없다.
//      => 즐겨 찾기나 북마크에 해당 페이지를 저장할 수 없다.
//   => 데이터를 보낼 때 message-body 영역에 보내기 때문에 
//      "multipart 인코딩" 방식을 사용하면 텍스트로 변환할 필요없이 
//      바이너리 데이터를 보낼 수 있다.
//   => 보통 웹서버는 POST 방식으로 보내는 데이터에 대해 크기 제한을 두지 않는다.
//      다만 개발자가 애플리케이션을 개발할 때 받아들이는 데이터의 크기를
//      제한 할 뿐이다.
//      설사 웹서버가 관리자가 크기의 제한을 두더라도 GET 방식과 달리 
//      더 큰 용량의 데이터를 전송할 수 있도록 해준다.
// - 특징 요약
//   => 요청 프로토콜에서 message-body 부분에 데이터를 보낸다.
//   => 웹브라우저 주소창에 데이터를 노출시키지 않는다. 
//   => 바이너리 데이터를 전송할 수 있다.
//   => 보내는 데이터의 크기에 제약이 거의 없다.
// - 용도
//   => URL에 데이터를 포함하지 않는다.
//   => 로그인처럼 외부에 데이터가 노출되지 않아야 하는 경우.
//   => 데이터 조회 보다는 데이터를 많이 보내는 입력이나 변경하는 경우.
//   => 바이너리 데이터를 보내는 경우.



















