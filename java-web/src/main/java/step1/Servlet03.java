// XML 파일에 Servlet 배치 정보를 작성하기
//
package step1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 서블릿 배치 정보는 
// 1) 애노테이션으로 설정하거나,
//    => @WebServlet("/step1/Servlet03") 
// 2) XML 파일에 설정할 수 있다.
//    => src/main/webapp/WEB-INF/web.xml 파일에 등록해야 한다.
//
// 배치(deploy)
// => 서버 프로그램 개발 세계에서는 install 이나 setup 이라는 용어 대신에
//    deploy라는 용어를 많이 사용한다.
// => 왜? 
//    PC 세계에서는 프로그램을 설치할 때 단순히 특정 폴더에 실행할 파일을 
//    복사해 놓으면 된다.
//    그러나 서버 세계에서는 한 프로그램을 설치할 때
//    여러 서버에 나눠서 설치해야 한다.
//    예를 들면, HTML/CSS/JavaScript 등 정적인 웹 자원은 "웹서버"에 두고
//    서블릿/JSP 같은 실행 파일을 "WAS서버"에 둔다.
//    그리고 업로드 파일을 관리하는 서버는 별도 컴퓨터에 설치하고,
//    Data 다루는 S/W인 DBMS도 별도의 컴퓨터에 설치한다.
//    이런 식으로 프로그램 하나를 설치할 때 여러 S/W와 H/W에 분산한다고 해서
//    군대에서 사용하는 용어인 deloy를 사용하는 것이다.
//    
// => 그래서 웹 애플리케이션을 서버에 설치할 때도 "배치한다(deploy)" 라는 표현을 
//    사용한다.
//
// web.xml 파일
// => 웹 애플리케이션에 배치되는 서블릿, 필터, 리스너 등의 정보를 등록하는 
//    파일이다.
// => 그래서 "배치 기술서(deployment descriptor file)"이라고 부른다.
// => 보통 개발자들은 이 말을 줄여서 "DD File"이라고 한다.
// 
public class Servlet03 implements javax.servlet.Servlet {
    
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step1.Servlet03.service()");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    
    @Override
    public String getServletInfo() {
        return "Servlet03 - XML 파일에 서블릿 배치 정보 등록";
    }
}









