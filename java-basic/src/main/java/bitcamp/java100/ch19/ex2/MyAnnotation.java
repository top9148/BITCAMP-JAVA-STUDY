// 애노테이션 보관 범위 및 사용 범위
//
package bitcamp.java100.ch19.ex2;

// 애노테이션의 보관 정책을 지정하지 않았기 때문에
// CLASS 보관 정책을 가진다.
// 즉 다음 정책을 지정한 것과 같다.
//
// @Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {}
