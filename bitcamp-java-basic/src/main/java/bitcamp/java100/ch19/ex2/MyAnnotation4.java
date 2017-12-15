// 애노테이션 보관 범위 및 사용 범위
//
package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// RUNTIME 
// => 컴파일 한 후 .class 파일에 보관된다.
// => 프로그램을 실행하는 동안에 조회할 수 있다.
//
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation4 {}
