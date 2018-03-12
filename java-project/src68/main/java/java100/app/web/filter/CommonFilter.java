package java100.app.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 요청 실행 전후에 공통으로 처리해야 할 작업을 수행하는 필터 
//@WebFilter("/*")
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        // JSP에서 사용할 웹애플리케이션 root 경로를 저장한다.
        request.setAttribute("contextPath", 
                request.getServletContext().getContextPath());
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }

}
