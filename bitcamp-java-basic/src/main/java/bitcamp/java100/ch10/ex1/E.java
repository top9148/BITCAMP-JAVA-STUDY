// 같은 파일에 여러 개 선언된 "패키지 멤버 클래스"
// => 물론 이럴 경우 오직 한 개의 클래스만 공개할 수 있다.
// => 공개 클래스가 있을 경우 그 소스 파일 이름은 반드시 공개 클래스 이름과 같아야 한다.
package bitcamp.java100.ch10.ex1;

public class E {

}

class F {}
class G {}