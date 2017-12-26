package java100.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
    
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // 요청 데이터가 어떤 문자집합으로 인코딩되어 있는지 설정한다.
        // 그런데 그 문자집합은 DD 파일에서 초기화 파라미터를 참고한다.
        String encoding = config.getInitParameter("encoding");
        request.setCharacterEncoding(encoding);
        
        // 다음 필터나 서블릿을 요청한다.
        chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
    }
    
}
