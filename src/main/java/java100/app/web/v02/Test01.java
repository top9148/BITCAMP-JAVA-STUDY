// 페이지 컨트롤러 만들기
// => @Controller 애노테이션을 붙인다.
// => @RequestMapping 애노테이션을 이용하여 
//    요청을 처리할 메서드(request handler)를 지정한다.
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test01 {

    // request handler 작성 규칙
    // => 메서드 이름은 개발자 마음대로
    // => 파라미터는 프론트 컨트롤러(DispatcherServlet)가 줄 수 있는 값만 선언
    // => 리턴 타입은 JSP 이름(경로 포함)
    // 
    @RequestMapping("/v02/test01")
    public String m() {
        
        // request handler가 JSP 이름을 리턴하면, 
        // 프론트 컨트롤러가 그 JSP를 include 할 것이다.
        return "/hello.jsp";
    }
}










