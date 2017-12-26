package java100.app.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 이 애노테이션은 프론트 컨트롤러가 페이지 컨트롤러에 대해 호출할 
// 메서드를 표시하는 용도이다.

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
}
