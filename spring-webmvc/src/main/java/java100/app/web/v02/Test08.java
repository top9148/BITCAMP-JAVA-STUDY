// @RequestMapping - Accept 요청 헤더의 값에 따라 구분하기
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test08")
public class Test08 {

    // 테스트 하는 방법
    //   http://localhost:9999/spring-webmvc/v02/test08.html 
    
    
    // Accept 요청 헤더
    // => HTTP 클라이언트가 웹서버에서 받고 싶어 하는 콘텐츠의 MIME 타입
    // => 웹서버는 가능한 클라이언트가 요구하는 타입의 콘텐츠를 우선으로 보내준다.
    // 
    // 클라이언트가 무슨 타입의 콘텐츠를 원하는 지에 따라 구분하여 처리할 수 있다.
    // => produces 속성에 MIME 타입을 지정하면 된다.
    //
    @RequestMapping(produces="text/csv")
    public String m1() {
        System.out.println("m1()");
        return "/hello.jsp";
    }
    
    @RequestMapping(produces="application/json")
    public String m2() {
        System.out.println("m2()");
        return "/hello.jsp";
    }
    
    @RequestMapping
    public String m3() {
        System.out.println("m3()");
        return "/hello.jsp";
    }
}










