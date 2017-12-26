// 애노테이션 프로퍼티의 기본값
//
package bitcamp.java100.ch19.ex4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    
    // 프로퍼티를 선언할 때 기본 값을 설정할 수 있다.
    // 기본 값을 설정하면, 
    // 애노테이션을 사용할 때 값을 지정하지 않아도 된다.
    String name() default "홍길동";
    int age() default 20;
}
