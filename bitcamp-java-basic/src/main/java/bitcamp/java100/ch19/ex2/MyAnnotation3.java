// 애노테이션 보관 범위 및 사용 범위
//
package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// CLASS 
// => 컴파일 한 후 .class 파일에 보관된다.
// => 단 프로그램을 실행하는 동안에 조회할 수는 없다.
// => 보관 정책을 지정하지 않으면 기본이 CLASS이다.
//
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation3 {}
