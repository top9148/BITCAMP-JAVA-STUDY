// 애노테이션의 배열 프로퍼티
//
package bitcamp.java100.ch19.ex6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    
    // 배열 프로퍼티에 기본 값을 한 개만 지정할 때는 중괄호 생략 가능!
    String[] name() default "홍길동";
    int[] age() default 20;
}
