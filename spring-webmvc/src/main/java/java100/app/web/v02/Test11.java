// 요청 핸들러의 파라미터 - @RequestParam
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v02/test11")
public class Test11 {

    // @RequestParam
    // => 클라이언트가 보낸 값을 받을 변수에 붙인다.
    // => 클라이언트가 보낸 값의 이름을 지정하면 그 값을 
    //    메서드 아규먼트로 전달해준다.
    // 
    @RequestMapping("m1")
    public String m1(@RequestParam("name") String name) {
        System.out.println(name);
        return "/hello.jsp";
    }
    
    // => 클라이언트가 해당 이름을 값을 보내지 않았으면 실행 오류!
    // => 해결책?
    //    @RequestParam의 required 속성을 false 설정하라!
    @RequestMapping("m2")
    public String m2(
            @RequestParam(value="name",required=false) String name) {
        System.out.println(name);
        return "/hello.jsp";
    }
    
    // => 클라이언트가 값을 보내지 않았을 경우에 사용할 기본 값을 설정할 수 있다.
    @RequestMapping("m3")
    public String m3(
            @RequestParam(value="name",defaultValue="우헤헤") String name) {
        System.out.println(name);
        return "/hello.jsp";
    }
    
    // => @RequestParam을 붙이지 않으면, 
    //    클라이언트가 보낸 데이터 중에서 변수명과 일치하는 것을 찾아 넘겨준다.
    //    만약 값을 찾지 못했으면 null을 넘겨준다.
    @RequestMapping("m4")
    public String m4(
            String name) {
        System.out.println(name);
        return "/hello.jsp";
    }
    
}










