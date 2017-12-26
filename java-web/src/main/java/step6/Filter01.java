package step6;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터에서 DD File(web.xml)에 선언된 값을 가져오기
//
//@WebFilter("/step6/Servlet01") <== DD File 에서 배치 정보 설정하므로 제거한다.
public class Filter01 implements Filter {
    
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(
        ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        String charset = config.getInitParameter("charset");
        System.out.println("step6.Filter01=>" + charset);
        
        request.setCharacterEncoding(charset);

        chain.doFilter(request, response);
        
    }
}










