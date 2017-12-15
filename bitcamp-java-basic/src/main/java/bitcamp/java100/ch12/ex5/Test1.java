// 인터페이스를 구현할 때는
// 그 인터페이스의 조상 인터페이스까지 구현해야 한다.
package bitcamp.java100.ch12.ex5;

// 즉 Test1은 B에 선언된 메서드 뿐만아니라
// B가 상속 받는 A 인터페이스에 선언된 메서드도 구현해야 한다.
// 
public class Test1 implements B {
    
    // B 인터페이스에 선언된 메서드 구현하기
    @Override
    public void m2() {
        System.out.println("m2()");
    }
    
    // B가 상속 받는 A인터페이스에 선언된 메서드 구현하기
    @Override
    public void m1() {
        System.out.println("m1()");
    }
    
}
