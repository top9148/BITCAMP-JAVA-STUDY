// 애노테이션 프로퍼티 정의하기
//
package bitcamp.java100.ch19.ex3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션을 사용할 때 값을 저장할 수 있다.
// => 애노테이션 프로퍼티를 정의하라!

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    
    // 프로퍼티를 선언할 때는 메서드 처럼 선언한다.
    String name();
    int age();
}
