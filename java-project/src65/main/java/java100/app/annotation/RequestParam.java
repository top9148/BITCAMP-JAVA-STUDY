package java100.app.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 클라이언트가 보낸 파라미터 값을 받을 변수를 표시하는 애노테이션

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    String value() default "";
}
