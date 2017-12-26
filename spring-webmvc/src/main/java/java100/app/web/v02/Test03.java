// @RequestMapping
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test03") // 클래스 선언부에 기본 경로를 지정하고,
public class Test03 {

    // 각 메서드에 나머지 경로를 지정할 수 있다.
    @RequestMapping("m1")
    public String m1() {
        System.out.println("m1()");
        return "/hello.jsp";
    }
    
    // 각 메서드에 나머지 경로를 지정할 수 있다.
    @RequestMapping("m2")
    public String m2() {
        System.out.println("m2()");
        return "/hello.jsp";
    }
    
    // 속성 이름을 생략하면 value이다.
    @RequestMapping(value="m3")
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }
    
    // value는 path와 같다.
    @RequestMapping(path="m4")
    public String m4() {
        System.out.println("m4()");
        return "/hello.jsp";
    }
    
    
    // 나머지 경로를 작성할 때 앞에 /를 붙여도 된다.
    // 즉 붙여도 되고 안 붙여도 된다.
    @RequestMapping("/m5")
    public String m5() {
        System.out.println("m5()");
        return "/hello.jsp";
    }
}










