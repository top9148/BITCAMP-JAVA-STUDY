// Filter의 배치
package step3;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터의 배치 
// 1) 애노테이션으로 배치하거나,
//    => @WebFilter(urlPatterns="/step3/*") 
// 2) DD 파일에 배치할 수 있다.
//    => src/main/webapp/WEB-INF/web.xml 파일 
// 
public class Filter02 implements javax.servlet.Filter {
    
    FilterConfig  config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02.init()");
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter02.destroy()");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        // 다음 필터나 서블릿이 실행하기 전에 해야할 작업
        // - 클라이언트가 보낸 데이터에 대해 압축 해제 
        // - 암호화된 데이터를 암호 해제
        // - JSON 문자열을 파싱하여 자바 객체로 변환
        // - 클라이언트의 권한 검사
        // 
        System.out.println("Filter02.doFilter() - before");
        
        // 다음 필터나 서블릿을 실행
        // - 다음 메서드를 호출하지 않으면 서블릿을 실행하지 않는다.
        chain.doFilter(request, response);
        
        // 서블릿을 실행한 후에 해야할 작업
        // - 실행 로그를 남긴다.
        // - 보낼 데이터를 압축하기
        // - 보낼 데이터를 암호화하기
        // - 보낼 데이터를 특별한 형식으로 변환하여 보내기 
        System.out.println("Filter02.doFilter() - after");
        
    }
}








