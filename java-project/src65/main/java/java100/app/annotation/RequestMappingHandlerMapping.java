package java100.app.annotation;

import static org.reflections.ReflectionUtils.getMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

public class RequestMappingHandlerMapping {
    
    Map<String,RequestHandler> handlerMap = new HashMap<>();
    
    public static class RequestHandler {
        public Object instance;
        public Method method;
        
        public RequestHandler(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }
    }
    
    public RequestMappingHandlerMapping(ApplicationContext iocContainer) {
        
        // 스프링 IoC 컨테이너에서 @Controller 가 표시된 객체를 추출한다.
        // 즉 페이지 컨트롤러를 꺼낸다.
        String[] controllerNames = 
                iocContainer.getBeanNamesForAnnotation(Controller.class);

        for (String controllerName : controllerNames) {
            Object controller = iocContainer.getBean(controllerName);
            
            // 각 페이지 컨트롤러에 들어 있는 메서드 중에서
            // @RequestMapping이 붙은 메서드만 추출한다.
            @SuppressWarnings("unchecked")
            Set<Method> methods = getMethods(controller.getClass(), 
                    withAnnotation(RequestMapping.class));
            
            // 각 핸들러에서 @RequestMapping 애노테이션 정보를 추출한다.
            for (Method m : methods) {
                RequestMapping anno = m.getAnnotation(RequestMapping.class);
                
                // @RequestMapping 애노테이션의 value 값을 가지고 
                // 매핑 객체를 생성한다.
                RequestHandler handler = 
                        new RequestHandler(controller, m);
                
                // 핸들러 메서드 정보를 담은 객체를 맵에 보관한다.
                handlerMap.put(anno.value(), handler);
            }
        }
    }
    
    public RequestHandler getRequestHandler(String name) {
        return handlerMap.get(name);
    }
}










