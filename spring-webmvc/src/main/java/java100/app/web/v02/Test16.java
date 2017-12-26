// 요청 핸들러의 파라미터 - @RequestBody
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test16")
public class Test16 {

    // 테스트 방법:
    // => http://localhost:9999/spring-webmvc/v02/test16.html
    
    // 클라이언트가 보낸 text/csv 데이터 전체를 받기
    @RequestMapping("/m1")
    public String m1(@RequestBody String body) {
        System.out.println(body);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // 클라이언트가 보낸 application/json 전체를 받기
    @RequestMapping("/m2")
    public String m2(@RequestBody String body) {
        System.out.println(body);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // 클라이언트가 보낸 application/x-www-form-urlencoded 데이터 전체를 받기
    @RequestMapping("/m3")
    public String m3(@RequestBody String body) {
        System.out.println(body);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // 클라이언트가 보낸 text/plain 데이터 전체를 받기
    @RequestMapping("/m4")
    public String m4(@RequestBody String body) {
        System.out.println(body);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
}










