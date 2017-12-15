// 다중 상속을 한 인터페이스 구현하기
package bitcamp.java100.ch12.ex5;


public class Test2 implements D {
    
    // D 인터페이스에 선언된 메서드 구현
    @Override public void m4() {System.out.println("m4()");}
    
    // D의 수퍼 인터페이스인 C에 선언된 메서드 구현
    // m1()은 A 인터페이스에도 선언된 메서드이기 때문에
    // 여기 정의하는 순간 A의 메서드를 구현한 것이 된다.
    @Override public void m1() {System.out.println("m1()");}
    
    @Override public void m3() {System.out.println("m3()");}
    
    // D의 수퍼 인터페이스인 B에 선언된 메서드 구현
    @Override public void m2() {System.out.println("m2()");}
    
    
}



