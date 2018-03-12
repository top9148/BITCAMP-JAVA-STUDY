package java100.app.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// "/app/*"으로 들어온 요청(페이지 컨트롤러를 실행하는 요청)에 대해서 
// 로그인 여부를 검사한다.
//@WebFilter("/app/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        // 파라미터 값을 원래의 타입으로 변환한다.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // getPathInfo() 리턴 값은 
        // 예를 들면 "/app/score/list" 요청이 들어 왔을 때
        // 필터에 설정된 "/app"을 제외한 나머지 url "/score/list" 이다.
        // 
        String pathInfo = httpRequest.getPathInfo();
        
        // 페이지 컨트롤러를 실행시키는 경우
        // => 즉 /app 으로 시작하는 경우에는 로그인 여부를 검사해야 한다.
        // => 단 /app/auth/* 는 제외한다.
        // 
        if (!pathInfo.startsWith("/auth")) {
            
            // 세션 보관소에 "loginUser"가 저장되었는지 검사한다.
            HttpSession session = httpRequest.getSession();
            
            // 로그인 정보가 없으면 로그인 폼으로 보낸다.
            if (session.getAttribute("loginUser") == null) {
                httpResponse.sendRedirect(
                    request.getServletContext().getContextPath() + 
                    "/app/auth/login");
                return;
            }
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }

}
