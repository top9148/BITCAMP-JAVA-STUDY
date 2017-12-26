// @RequestMapping - 요청 헤더의 이름으로 구분하기
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test06")
public class Test06 {

    // 테스트 하는 방법
    //   http://localhost:9999/spring-webmvc/v02/test06.html 
    
    
    // 요청 헤더의 존재 유무에 따라 호출될 메서드를 구분할 수 있다.
    // headers 속성에 헤더 이름을 등록하라.
    @RequestMapping
    public String m1() {
        System.out.println("m1()");
        return "/hello.jsp";
    }
    
    // => aaa 헤더가 있는 경우
    @RequestMapping(headers="aaa")
    public String m2() {
        System.out.println("m2()");
        return "/hello.jsp";
    }
    
    // => bbb 헤더가 있는 경우
    @RequestMapping(headers="bbb")
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }
    
    // => aaa와 bbb 헤더가 모두 있는 경우
    @RequestMapping(headers={"aaa","bbb"})
    public String m4() {
        System.out.println("m4()");
        return "/hello.jsp";
    }
}










