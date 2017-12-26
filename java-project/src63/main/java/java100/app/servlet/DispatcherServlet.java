package java100.app.servlet;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.annotation.RequestMapping;
import java100.app.listener.ContextLoaderListener;

// 프론트 컨트롤러(Front Controller) 
// - 페이지 컨트롤러의 앞 쪽에서 요청을 먼저 받는다.
// - 페이지 컨트롤러가 사용하기 쉽게 요청 데이터를 가공한다.
// - 페이지 컨트롤러가 작업을 완료하면 그 작업 결과를 출력할 JSP를 실행한다.
// - 또는 redirect 한다.
// - "Facade" 설계 패턴과 같다.
// 
@WebServlet("*.do")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 요청한 URL에서 .do를 제외한 
        // 페이지 컨트롤로의 경로를 추출한다.
        String pageControllerPath = request.getServletPath().replace(".do", "");
        
        // 스프링 IoC 컨테이너에서 페이지 컨트롤러를 찾는다.
        Object pageController = 
          ContextLoaderListener.iocContainer.getBean(pageControllerPath);
        
        if (pageController == null) {
            throw new ServletException("페이지 컨트롤러를 찾을 수 없습니다.");
        }

        // 페이지 컨트롤러 객체에서 @RequestMapping이 붙은 메서드를 찾는다.
        @SuppressWarnings("unchecked")
        Set<Method> methods = getMethods(pageController.getClass(),
                withAnnotation(RequestMapping.class));
        
        if (methods.size() == 0) {
            throw new ServletException(
                    "페이지 컨트롤러의 요청 핸들러를 찾을 수 없습니다.");
        }
        
        // 메서드 목록에서 첫 번째 메서드를 꺼낸다.
        Method requestHandler = (Method)methods.toArray()[0];
        
        try {
            // 페이지 컨트롤러를 요청 핸들러를 호출한다.
            String viewName = (String)requestHandler.invoke(
                    pageController, request, response);
            
            if (viewName.startsWith("redirect:")) {
                response.sendRedirect(viewName.substring(9));
                return;
            } else {
                // JSP를 인클루딩하기 전에 콘텐츠 타입을 설정해야 한다.
                // => 인클루드 되는 쪽에서는 여기에서 설정한 것을 그대로 따른다.
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher rd = request.getRequestDispatcher(viewName);
                rd.include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}











