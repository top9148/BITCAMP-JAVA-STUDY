// 세션 다루기 - 다른 페이지 컨트롤러에서 등록한 세션 값 사용? 
//
package java100.app.web.v03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v03/test09")
//@SessionAttributes({"name","age"})
// => 이 애노테이션이 없으면,
//    프론트 컨트롤러는 JSP를 실행하기 전에
//    세션에 저장된 name, age 값을 ServletRequest에 복사해주는 일을 하지 않는다.
// => 또한 메서드를 호출할 때 
//    @ModelAttribute 에 지정된 값을 넘겨주지 않는다.
public class Test09 {
    
    @RequestMapping(value="/m1")
    public String m1(HttpSession session, Model model) {
        
        // 보관소에 저장된 값을 확인해보자!
        return "v03/test09/m1";
        // 테스트 방법
        // 1) 웹브라우저를 모두 닫아 세션을 새로 만들도록 한다.
        // 2) /app/v03/test08/m1 을 요청하여 세션에 값을 보관한다.
        // 3) /v03/test09/m1.jsp 를 요청하여 직접 JSP 실행 결과를 확인한다.
        // 3) /app/v03/test09/m1 를 요청하여 세션 값을 확인한다.
    }
    
    @RequestMapping(value="/m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @ModelAttribute("name") String name,
            @ModelAttribute("age") String age) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("name=%s\n", name));
        buf.append(String.format("age=%s\n", age));
        
        return buf.toString();
        // 테스트 방법
        // 1) 웹브라우저를 모두 닫아 세션을 새로 만들도록 한다.
        // 2) /app/v03/test08/m1 을 요청하여 세션에 값을 보관한다.
        // 3) /app/v03/test09/m2 를 요청하여 변수에 세션 값이 들어있는지 확인한다.
    }
    
    
}










