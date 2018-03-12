// @RestController 
// => HTML과 같은 UI를 클라이언트에 출력하는 것이 아니라,
//    XML이나 JSON 형식의 문자열처럼 구조화된 데이터를 출력하는 
//    페이지 컨트롤러에 붙이는 애노테이션이다.
// => 기본으로 요청 핸들러의 리턴 값은 
//    JSON 형식의 문자열로 변환하여 출력한다.
//
package java100.app.web.v03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v03/test04")
public class Test04 {
    
    @RequestMapping(value="/m1")
    //@ResponseBody // @RestController에 정의된 요청 핸들러가 일반 객체를
                  // 리턴 할 때 @ResponseBody를 붙일 필요가 없다.
    public Object m1() {
        return new Member("홍길동", 20, true);
    }
    
    @RequestMapping(value="/m2", produces="text/plain;charset=UTF-8")
    public String m2() {
        return "Hello!안녕!";
    }
    
}










