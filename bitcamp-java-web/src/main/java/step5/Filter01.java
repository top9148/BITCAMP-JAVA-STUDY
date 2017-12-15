package step5;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 필터 응용!
// 클라이언트가 보낸 데이터에 대해 
// 어떤 문자 집합인지 설정하는 코드를
// 필터에 두면 매번 서블릿에 작성할 필요가 없어 편하다.
//
@WebFilter("/step5/Servlet05")
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    public void destroy() {}
    
    @Override
    public void doFilter(
        ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // 서블릿을 실행하기 전에 
        // 필터에서 먼저 한글 처리를 한다.
        request.setCharacterEncoding("UTF-8");

        // 한글 처리를 한 후에 다음과 같이
        // 다음 필터나 서블릿을 실행한다.
        chain.doFilter(request, response);
        
    }
}










