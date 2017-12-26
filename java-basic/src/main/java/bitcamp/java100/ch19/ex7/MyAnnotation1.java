// value 프로퍼티
//
package bitcamp.java100.ch19.ex7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    String value();
    String value2() default "aaaa";
    int value3() default 100;
}
