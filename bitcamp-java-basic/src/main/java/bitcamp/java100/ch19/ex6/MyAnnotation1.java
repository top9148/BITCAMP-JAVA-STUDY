// 애노테이션의 배열 프로퍼티
//
package bitcamp.java100.ch19.ex6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    String[] name() default {"홍길동","임꺽정"};
    int[] age() default {20, 30};
}
