package step2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 매번 서블릿 클래스의 service() 메서드를 작성할 때 마다 
// HTTP 기능을 모두 사용하기 위해 
// ServletRequest와 ServletResponse를 
// 원래의 타입인 HttpServletRequest, HttpServletResponse로 
// 타입 캐스팅하기가 번거롭다.
//
// 그래서 미리 타입 캐스팅을 한 메서드를 추가하자!
// 그리고 개발자도 오리지널 service(ServletRequest,ServletResponse)를 
// 오버라이딩하지 말고 새로 추가한 메서드를 오버라이딩 하자!
// 
public abstract class AbstractHttpServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        
        service(httpReq, httpRes);
    }
    
    public abstract void service(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}











