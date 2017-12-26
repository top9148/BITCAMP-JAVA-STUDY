// @RequestMapping - 파라미터 이름으로 구분하기
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test05")
public class Test05 {

    // 테스트 하는 방법
    // => 파라미터가 없는 경우   
    //   http://localhost:9999/spring-webmvc/app/v02/test05
    // => menu 파라미터가 있는 경우 
    //   http://localhost:9999/spring-webmvc/app/v02/test05?menu=1
    
    
    // 파라미터의 존재 유무에 따라 호출될 메서드를 구분할 수 있다.
    // params 속성에 파라미터 이름을 등록하라.
    @RequestMapping
    public String m1() {
        System.out.println("m1()");
        return "/hello.jsp";
    }
    
    // => menu라는 파라미터가 있는 경우
    @RequestMapping(params="menu")
    public String m2() {
        System.out.println("m2()");
        return "/hello.jsp";
    }
    
    // => command라는 파라미터가 있는 경우
    @RequestMapping(params="command")
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }
    
    // => menu와 command가 함께 있는 경우
    @RequestMapping(params={"menu","command"})
    public String m4() {
        System.out.println("m4()");
        return "/hello.jsp";
    }
}










