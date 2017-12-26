// value 프로퍼티 값을 지정하기
package bitcamp.java100.ch19.ex7;

// 프로퍼티 이름이 "value" 일 경우,
// 값을 설정할 때 이름을 생략할 수 있다.
// => 다른 이름의 프로퍼티는 안된다.

// => 단 다른 프로퍼티의 값도 지정할 때는 이름을 생략할 수 없다.
//@MyAnnotation1("오호라ㅋㅋ!", value3=300) // 오류! 

// => 다른 프로퍼티의 값도 지정할 경우, 
//    value 프로퍼도 무조건 이름을 적어야 한다.
@MyAnnotation1(value="오호라ㅋㅋ!", value3=300)
public class MyClass3 {

}
