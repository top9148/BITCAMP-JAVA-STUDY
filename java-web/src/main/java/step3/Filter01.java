// 웹 애플리케이션 멤버 - Filter
package step3;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 클라이언트 요청이 들어 왔을 때 
// 서블릿을 실행하기 전 후에 어떤 작업을 수행하는 일을 한다.
// 
// 구현 방법
// => javax.servlet.Filter 인터페이스를 구현하라!
//

// 필터를 어느 요청에 꼽아야 할 지 지정해야 한다.
@WebFilter(urlPatterns="/step3/Servlet01")
public class Filter01 implements javax.servlet.Filter {
    
    // init()에서 받은 파라미터 값을 보관한다.
    FilterConfig  config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터는 서블릿과 달리 서블릿 컨테이너를 실행할 때 
        // 미리 생성되고 이 메서드도 미리 호출된다.
        // 서블릿의 init()의 용도와 같다.
        // => 딱 한 번만 호출된다.
        // => 필터가 필요한 자원을 준비시키는 코드를 둔다.
        System.out.println("Filter01.init()");
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
        // 웹 애플리케이션이 종료되기 전에
        // 필터 객체에 대해 호출하는 메서드이다.
        // 서블릿의 destroy()와 용도가 같다.
        // => 웹 애플리케이션이 종료하기 전에 필터가 사용한 자원을 해제시키는 
        //    코드를 둔다.
        System.out.println("Filter01.destroy()");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        // 다음 필터가 있으면 다음 필터가 실행되기 전에 먼저 호출된다.
        // 다음 필터가 없으면 서블릿의 service()가 호출될 것이다.
        // 서블릿의 service()가 호출되기 전에 먼저 호출된다.
        //
        // 단 다음 필터를 실행하라고 메서드를 명시적으로 호출해야만 한다. 
        
        // 연결 고리에서 다음에 필터가 있으면 그 필터를 실행하고,
        // 다음에 필터가 없으면 최종 목적지인 서블릿을 실행한다.
        System.out.println("Filter01.doFilter() - before");
        
        // 만약 체인을 따라 다음 메서드를 호출하지 않으면 
        // 서블릿이 실행되지 않는다. 
        chain.doFilter(request, response);
        
        // 서블릿의 service() 메서드 호출이 끝나면 
        // 연결고리를 따라 꺼꾸로 리턴해 올 것이다.
        // 즉 위의 doFilter() 호출이 리턴될 것이다.
        System.out.println("Filter01.doFilter() - after");
        
    }
}








