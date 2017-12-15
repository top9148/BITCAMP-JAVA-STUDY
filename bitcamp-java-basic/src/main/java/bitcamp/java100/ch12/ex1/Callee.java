// 인터페이스 구현 
package bitcamp.java100.ch12.ex1;

// 인터페이스 구현
// => 인터페이스 규칙에 따라 클래스를 정의함을 말한다.
// => 인터페이스에 선언된 모든 메서드를 구현해야 한다.
//
public class Callee implements Protocol {

    @Override
    public void m1() {
        System.out.println("m1()...");
        
    }

    @Override
    public void m2() {
        System.out.println("m2()...");
    }
    
}
