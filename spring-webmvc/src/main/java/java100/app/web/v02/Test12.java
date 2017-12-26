// 요청 핸들러의 파라미터 - 커스텀 프로퍼티 에디터
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test12")
public class Test12 {

    // 클라이언트가 보낸 데이터는 모두 문자열이다.
    // 프론트 컨트롤러가 이 문자열을 메서드의 변수 타입에 맞게 형변환한다.
    // 단 primitive 타입만 형변환 가능하다.
    // 
    @RequestMapping("m1")
    public String m1(
            String name, 
            int age, 
            boolean working, 
            float height) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(working);
        System.out.println(height);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    
    // 기본 타입외에 다른 타입으로 형변환을 요구하면 
    // 프론트 컨트롤러는 오류를 발생시킨다.
    // 해결 방안?
    // => String을 java.util.Date 객체로 변환시켜주는 변환기를 만들어 
    //    스프링에 꼽아야 한다.
    // => 이런 변환기를 꼽으면 다음 메서드가 호출될 때 오류가 발생하지 않는다.
    // => 변환기를 꼽는 방법
    //    1) 해당 페이지 컨트롤러에 @InitBinder 메서드를 둔다.
    //    2) @ControllerAdvice 클래스에 @InitBinder 메서드를 둔다.
    //    3) WebBindingInitializer의 구현체를 제공한다.
    // 
    @RequestMapping("m2")
    public String m2(java.util.Date birthDate) {
        System.out.println(birthDate);
        System.out.println("--------------------");
        return "/hello.jsp";
    }
    
    
    // @InitBinder
    // => 프론트 컨트롤러(DispatcherServlet)는 클라이언트로 부터 요청이 들어오면
    //    클라이언트가 보낸 데이터를 적절하게 변환하기 위해 
    //    변환기를 셋팅한다. 이것을 "Web Data Binding" 이라 표현한다.
    // => 문자열을 다른 타입의 값으로 변환시키는 객체를 "WebDataBinder"라 부른다. 
    // => 스프링은 문자열을 primitive 타입으로 바꾸는 변환기는 기본으로 제공한다.
    //    그 외의 타입은 개발자가 만들어 셋팅해야 한다.
    // => @InitBinder가 붙은 메서드는 
    //    프론트 컨트롤러가 문자열을 특정 타입의 값으로 바꾸기 전에 
    //    WebDataBinder를 추가로 설정하기 위해 호출하는 메서드이다.
    // => 문자열을 다른 타입의 값으로 바꾸기 전에 매번 호출된다.
    //    즉 요청 핸들러 파라미터가 5개면 요청할 때 5번 호출된다.
    
    // 방법1: @InitBinder 메서드를 페이지 컨트롤러에 두기 
    // => 이 메서드를 오직 이 페이지 컨트롤러에만 영향을 미친다.
    /* 이 메서드의 실행을 확인했으면, 이 메서드를 주석을 막고
     * Test12ControllerAdvice 클래스의 동작을 확인하라!
     * 
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        System.out.println("Test12.initBinder()");
        
        // 문자열을 날짜 객체로 만들어줄 도구를 준비한다.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // 날짜 형식을 엄격하게 검사하라!
        
        // 스프링에서 제공하는 문자열을 날짜 객체로 변환시켜주는 
        // 커스텀 에디터를 준비하여 
        // WebDataBinder에 등록한다.
        binder.registerCustomEditor(
                Date.class, // 문자열을 어떤 타입으로 바꿀지 설정한다 
                new CustomDateEditor( // 문자열을 java.util.Date 객체로 만들어 준다.
                        dateFormat, // 실제로는 그 작업을 SimpleDateFormat이 한다. 
                        false)); // 문자열 값이 비어 있는 것을 허락할 것인지 여부!
    }
    */
    
}










