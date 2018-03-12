// 쿠키 다루기 - @Cookie 
//
package java100.app.web.v03;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v03/test05")
public class Test05 {
    
    // 쿠키 보내기
    @RequestMapping(value="/m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) {
        response.addCookie(new Cookie("name", "hongkildong"));
        response.addCookie(new Cookie("age", "20"));
        
        return "쿠키를 보냈습니다!";
    }
    
    // 쿠키 받기
    // => @CookieValue 애노테이션을 이용하면 특정 쿠키의 값을 받을 수 있다.
    @RequestMapping(value="/m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @CookieValue("name") String name,  
            @CookieValue("age") int age) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("name=%s\n", name));
        buf.append(String.format("age=%d\n", age));
        
        return buf.toString();
        // 테스트 방법
        // 1) /v03/test05/m1 을 먼저 실행한다.
        // 2) /v03/test05/m2 를 실행하여 쿠키 값을 제대로 받았는지 확인한다.
    }
    
    // 쿠키 받기
    // => 만약 @CookieValue 에 쿠키의 이름을 지정하지 않으면,
    //    변수의 이름을 사용하여 쿠키를 찾는다.
    @RequestMapping(value="/m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(
            @CookieValue String name,  
            @CookieValue int age) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("name=%s\n", name));
        buf.append(String.format("age=%d\n", age));
        
        return buf.toString();
    }
    
    // 쿠키 받기
    // => 쿠키가 없다면 실행 오류 발생!
    @RequestMapping(value="/m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(@CookieValue String working) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("working=%s\n", working));
        
        return buf.toString();
    }
    
    // 쿠키 받기
    // => required 옵션을 사용하면 쿠키의 값을 선택사항으로 만들 수 있다.
    //    required의 기본 값은 true 이다.
    @RequestMapping(value="/m5", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m5(@CookieValue(required=false) String working) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("working=%s\n", working));
        
        return buf.toString();
    }
    
    // 쿠키 받기
    // => defaultValue를 설정하면 쿠키 값이 없을 때 그 값을 사용한다.
    @RequestMapping(value="/m6", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m6(@CookieValue(defaultValue="true") String working) {
        
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("working=%s\n", working));
        
        return buf.toString();
    }
    
}










