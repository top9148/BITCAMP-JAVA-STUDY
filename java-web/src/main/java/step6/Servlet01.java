// 서블릿 초기화 파라미터
//
package step6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet("/step6/Servlet01") <== DD File에 배치 정보가 있기 때문에 제거한다.
public class Servlet01 extends HttpServlet {
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // DD File(web.xml) 파일에 선언된 파라미터 값을 받기
        // - DB 연결 정보라든가, 인코딩 문자집합 등의 시스템 환경정보는
        //   상황에 따라 값이 변경될 수 있다.
        // - 이런 값을 자바 코드에서 문자열로 직접 작성하면,
        //   값을 변경할 때 마다 코드를 바꿔야 하는 문제가 생긴다.
        // - 특히 고객사 마다 환경이 다를 수 있는데, 
        //   특정 고객사에만 해당 되는 값을 코드에 삽입한다면,
        //   고객사가 바뀔 때 그 값도 변경해야 하므로 코드 관리가 매우 어려워진다.
        // - 이건 값들은 외부 파일에 두어
        //   코드에서 그 외부 파일에 작성된 값을 사용하는 방식으로 
        //   작성하는 것이 좋다.
        // - 서블릿 기술에서도 이런 경우를 고려하여 
        //   외부 파일, 특히 DD File에 값을 설정해 놓고
        //   서블릿이나 필터, 리스너가 그 값을 사용할 수 있도록
        //   방법을 제공하고 있다.
        //
        
        // DD File(web.xml)에 값을 지정하는 방법
        // => DD File에 서블릿 배치 정보를 작성하라!
        // 
        // 서블릿에서 그 값을 가져오는 방법
        // => 서블릿 설정 정보를 다루는 객체를 이용하여 값을 꺼내라! 
        // => ServletConfig 객체!
        
        ServletConfig config = this.getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("driver: %s\n", driver);
        out.printf("url: %s\n", url);
        out.printf("name: %s\n", req.getParameter("name"));
    }
}









