// @RequestMapping - GET, POST 구분하기
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/v02/test04")
public class Test04 {

    // 테스트 하는 방법
    // => http://localhost:9999/spring-webmvc/app/v02/test04.html
    
    
    // GET 또는 POST 등 특정 요청에 대해 호출되도록 제한하고 싶다면,
    // @RequestMapping의 method 속성을 추가하라!
    // method 속성의 값을 설정하지 않으면 모든 요청 방식에 대해 호출된다.
    @RequestMapping(method=RequestMethod.GET)
    public String get() {
        System.out.println("get()");
        return "/hello.jsp";
    }
    
    // 다음 메서드는 POST 요청에만 호출되도록 한다.
    // => URL을 지정하지 않았기 때문에 /test04 에 대해 POST 요청을 처리한다.
    @RequestMapping(method=RequestMethod.POST)
    public String post() {
        System.out.println("post()");
        return "/hello.jsp";
    }
    
    // 당연히 URL과 요청 방식을 모두 지정할 수 있다.
    @RequestMapping(value="m1", method=RequestMethod.GET)
    public String m1Get() {
        System.out.println("m1Get()");
        return "/hello.jsp";
    }
    
    @RequestMapping(path="m1", method=RequestMethod.POST)
    public String m1Post() {
        System.out.println("m1Post()");
        return "/hello.jsp";
    }
}










