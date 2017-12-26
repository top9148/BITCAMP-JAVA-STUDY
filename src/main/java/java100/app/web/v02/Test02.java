// @RequestMapping
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test02")
public class Test02 {

    // 클래스에 @RequestMapping으로 URL을 설정하고,
    // request handler를 표시하기 위해 @RequestMapping을 적을 수 있다.
    @RequestMapping
    public String m() {
        
        // request handler가 JSP 이름을 리턴하면, 
        // 프론트 컨트롤러가 그 JSP를 include 할 것이다.
        return "/hello.jsp";
    }
}










