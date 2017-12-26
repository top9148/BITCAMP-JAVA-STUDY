// 중첩 클래스(Nested Class = Inner Class)
// => 패키지에 직접 소속된 클래스가 아니라 다른 클래스 안에 소속된 클래스를 말한다.
// 
package bitcamp.java100.ch08.ex1;

// 다음 X1 클래스는 같은 파일에 있지만, 엄연한 패키지 멤버 클래스이다. 
// => 중첩 클래스가 아니다.
// => 중첩 클래스는 아래에 Test6에 소속된 클래스를 말한다.
class X1 {}

// 그래서 public 또는 (default) 이 두가지로만 접근을 제한할 수 있다.
// 다음과 같이 protected, private 안된다.

//protected class X2 {} //컴파일 오류!
//private class X3 {} // 컴파일 오류!

public class Test6 {

    // 클래스 안에 선언된 클래스를 "중첩(nested) 클래스"라 부른다.
    // 중첩 클래스도 클래스의 멤버로 보기 때문에
    // 변수나 메서드처럼 모든 접근 범위를 가질 수 있다.
    private class X4 {}
    class X5 {}
    protected class X6 {}
    public class X7 {}
    
    public static void main(String[] args) {

    }

}











