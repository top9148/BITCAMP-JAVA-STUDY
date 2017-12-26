package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//urlPatterns 속성
//- 클라이언트가 "/hello/xxx" URL을 요청할 때 이 서블릿을 실행하라고 표시한다.
//- /hello/xxx 요청이 들어오면 서블릿 컨테이너는 이 서블릿 객체를 실행한다.
//
@WebServlet(urlPatterns="/hello/*")
public class HelloServlet implements Servlet {

    // init()가 호출될 때 받은 파라미터 값을 저장할 변수
    ServletConfig servletConfig;
    
    @Override
    public void destroy() {}
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "인사하는 서블릿";
    }
    
    
    @Override
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {
        
        // 파라미터로 넘어오는 request 에는 원래 
        // ServletRequest의 하위 인터페이스인 HttpServletRequest 객체가 넘어온다.
        // 그러니 원래 타입으로 바꾼 후 사용하라!
        // 그냥 사용하면 안되나요?
        // => ServletRequest에는 웹 브라우저가 요청한 URL에서 
        //    서블릿의 경로를 리턴해주는 메서드가 없다.
        // => 그러니 귀찮더라도 원래 타입으로 바꿔야 한다.
        //    HttpServletRequest에는 URL에서 서블릿 경로를 추출해주는 
        //    getServletPath()라는 메서드가 있다.
        //
        // => request의 주소를 원래 타입으로 바꾼김에 아예,
        //    response 또한 원래 타입으로 바꾸자!
        // => 그래서 doXxx() 등을 호출할 때
        //    쓰기 편하도록 원래 타입의 값을 넘기자!
        //
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // 출력하는 콘텐츠의 문자표 이름(character set)을 웹브라우저에게 알려줘라!
        httpResponse.setContentType("text/plain;charset=UTF-8");
        
        switch (httpRequest.getPathInfo()) {
        case "/hi": this.doHi(httpRequest, httpResponse); break;
        case "/hi2": this.doHi2(httpRequest, httpResponse); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doHi(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("하이루~~~");
    }
    
    private void doHi2(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("오호라... 안녕!");
        
    } 
}










