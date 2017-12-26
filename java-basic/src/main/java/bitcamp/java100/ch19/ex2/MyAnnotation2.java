// 애노테이션 보관 범위 및 사용 범위
//
package bitcamp.java100.ch19.ex2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// SOURCE 
// => 소스 파일에서만 유효하고 컴파일 하면 제거된다.
// => 즉 .class 파일에 보관되지 않는다.
//
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation2 {}
