package step2;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

// 이 클래스의 목적은 서브 클래스에서 Servlet의 5개 메서드 중에서
// 반복적으로 거의 동일하게 구현하는 4개의 메서드를 미리 구현하여 
// 상속해주는 것이다.
//
public abstract class AbstractServlet implements Servlet {
    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
    
    @Override
    public String getServletInfo() {
        return this.getClass().getName();
    }    
}







