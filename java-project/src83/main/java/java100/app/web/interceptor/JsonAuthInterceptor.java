package java100.app.web.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;

public class JsonAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response,
            Object handler)
            throws Exception {
        
        System.out.println("JsonAuthInterceptor.....");
        // 세션 보관소에 "loginUser"가 저장되었는지 검사한다.
        HttpSession session = request.getSession();
        
        // 로그인 정보가 없으면 로그인 폼으로 보낸다.
        if (session.getAttribute("loginUser") == null) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("message", "사용 권한이 없습니다.");
            
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(result));
            return false;
            // 로그인 된 상태가 아니라면 다음 인터셉터의 실행을 모두 멈추고,
            // 즉시 로그인 폼으로 간다.
        }
        
        return true;
    }
}
