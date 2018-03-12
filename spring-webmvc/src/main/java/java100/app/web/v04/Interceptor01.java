// 인터셉터 만들고 설정하기 I
package java100.app.web.v04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터페이스를 만들었으면 
// 스프링 설정 파일(XML)이나 @Configuration 클래스(Config 클래스)에 
// 등록해야만 동작한다.
//
public class Interceptor01 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        // 페이지 컨트롤러의 요청 핸들러가 호출되기 전에 실행된다.
        System.out.println("Interceptor01.preHandle()....");
        
        return true; // 다음 인터셉터가 있다면 계속 실행하라!
        // false를 리턴한다면, 더이상 인터셉터를 실행하지 않고 응답한다.
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        // 페이지 컨트롤러의 요청 핸들러가 호출된 후 실행된다.
        // => JSP가 실행되기 전에 호출된다.
        System.out.println("Interceptor01.postHandle()");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
        // 요청 처리를 완료한 후 호출된다.
        // => 즉 JSP 실행을 완료한 후 호출된다.
        System.out.println("Interceptor01.afterCompletion()");
    }
    
    
}








