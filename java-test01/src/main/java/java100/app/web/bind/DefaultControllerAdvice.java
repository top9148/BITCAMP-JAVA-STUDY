// 클라이언트가 보낸 문자열 데이터를 다른 타입으로 변환하기
package java100.app.web.bind;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


// 방법2: @ControllerAdvice 클래스에 둔다.
// @ControllerAdvice?
// => 페이지 컨트롤러를 실행하는 데 추가적인 도움을 제공하는 클래스에 붙인다.
// => 이 애노테이션이 붙은 클래스는 페이지 컨트롤러의 요청 핸들러를 호출하기 전에
//    이 클래스에 포함된 메서드를 적절하게 호출하여 작업을 수행한 후 
//    요청 핸들러를 호출한다.
// 
// => 충고의 대상을 지정할 수 있다.
//    annotations : 특정 애노테이션들이 붙은 페이지 컨트롤러들.
//    basePackages : 특정 패키지나 그 하위 패키지에 소속된 페이지 컨트롤러들.
//    value : basePackages 와 같다.
//    assignableType : 특정 타입의 페이지 컨트롤러들.
//
@ControllerAdvice // 모든 페이지 컨트롤러에 충고한다.
public class DefaultControllerAdvice {
   
    @InitBinder // 요청 핸들러가 호출되기 전에 먼저 실행된다.
    protected void initBinder(WebDataBinder binder) {
        //System.out.println("DefaultControllerAdvice.initBinder()");
        
        // "yyyy-MM-dd" 형식 문자열 ===> java.util.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // 날짜 형식을 엄격하게 검사하라!
        
        binder.registerCustomEditor(
                java.util.Date.class,  
                new CustomDateEditor(dateFormat, false)); 
        
        // "yyyy-MM-dd" 형식 문자열 ===> java.sql.Date
        @SuppressWarnings("serial")
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd") {
            @Override
            public java.util.Date parse(String source) throws ParseException {
                java.util.Date date = super.parse(source);
                return new java.sql.Date(date.getTime());
            }
        };
        dateFormat2.setLenient(false); // 날짜 형식을 엄격하게 검사하라!
        
        binder.registerCustomEditor(
                java.sql.Date.class,  
                new CustomDateEditor(dateFormat2, false)); 
        
    }
}
