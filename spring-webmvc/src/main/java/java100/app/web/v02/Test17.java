// 요청 핸들러의 파라미터 - @RequestBody II
//
package java100.app.web.v02;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping("/v02/test17")
public class Test17 {

    // 테스트 방법:
    // => http://localhost:9999/spring-webmvc/v02/test17.html
    
    // JSON 문자열 ==> 자바 객체
    // => google-json 라이브러리를 이용하여 처리한다.
    // => mvnrepository.com에서 "google-gson"으로 검색한다.
    // => 라이브러리 정보를 build.gradle에 추가한다.
    // => "gradle eclipse"를 실행하여 라이브러리를 다운로드하고 
    //    이클립스 설정 파일을 갱신한다.
    // => 프로젝트를 "Refresh" 한다.
    // 
    @RequestMapping("/m1")
    public String m1(@RequestBody String json) {
        
        // JSON 문자열 ==> Map 객체
        @SuppressWarnings("rawtypes")
        Map obj = new Gson().fromJson(json, Map.class);
        
        System.out.printf("name=%s\n", obj.get("name"));
        System.out.printf("age=%f\n", obj.get("age"));
        System.out.printf("tel=%s\n", obj.get("tel"));
        System.out.printf("email=%s\n", obj.get("email"));
        
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // // JSON 문자열 ==> 특정 자바 객체
    // 
    
    class User {
        String name;
        int age;
        String tel;
        String email;
    }
    
    @RequestMapping("/m2")
    public String m2(@RequestBody String json) {
        
        User user = new Gson().fromJson(json, User.class);
        
        System.out.printf("name=%s\n", user.name);
        System.out.printf("age=%d\n", user.age);
        System.out.printf("tel=%s\n", user.tel);
        System.out.printf("email=%s\n", user.email);
        
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // 스프링에서 제공하는 Message Converter를 이용하여 
    // JSON 문자열을 자동으로 자바 객체로 바꾸기
    // => 설정이 필요하다.
    // => 설정 방법
    //    1) JSON 문자열을 자바 객체로 바꿔주는 변환기를 등록하기
    //       - app-servlet.xml 파일에서 RequestMappingHandlerAdapter 객체 참고!
    //    2) MVC 설정을 활성화시키는 태그나 애노테이션을 사용하여 등록하기
    //       - 애노테이션 예:
    //         @Configuration
    //         @EnableWebMvc
    //         public class WebConfig {...}
    //       - 태그 예:
    //         <mvc:annotation-driven/>
    // 이 예제에서는 RequestMappingHandlerAdapter에 직접 컨버터를 등록한다.
    // => app-servlet.xml 을 확인하라!
    //
    
    // 요청 핸들러의 파라미터 타입으로 nested 클래스를 사용할 때는
    // 프런트 컨트롤러가 해당 클래스를 알 수 있도록
    // public/(default) 이면서 static 클래스로 선언해야 한다.
    // 또는 패키지 멤버 클래스로 선언하면 된다.
    // 가장 좋은 방법은 패키지 멤버 클래스를 사용하는 것이다.
    //
    static class User2 {
        String name;
        int age;
        String tel;
        String email;
        
        // google-gson 라이브러리와 달리 
        // JSON 문자열을 자바 객체로 바꿀 때 Jackson 라이브러리는
        // 셋터 메서드를 이용한다.
        // 따라서 반드시 셋터 메서드가 있어야 한다.
        //
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    }
    
    @RequestMapping(value="/m3")
    public String m3(@RequestBody User2 user) {
        
        System.out.printf("name=%s\n", user.name);
        System.out.printf("age=%d\n", user.age);
        System.out.printf("tel=%s\n", user.tel);
        System.out.printf("email=%s\n", user.email);
        
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    // 주의!
    // => HttpMessageConverter를 등록하면 
    //    클라이언트가 보낸 데이터 중에서 "application/json"에 대해 
    //    자동 변환을 실시하기 때문에
    //    기존에 문자열을 그대로 받으려 할 경우 오류가 발생한다.
    //    즉 m2()를 테스트할 때 오류가 발생할 것이다.
    // => 문자열을 그대로 받고 싶을 때도 있다. 그런 경우 어떻게 하나?
    //    서버에 데이터를 보낼 때 Content-Type 헤더의 값을 
    //    text/plain으로 설정하라!
    //    또한 String을 받는 컨버터를 명시적으로 등록해야 한다.
    
}










