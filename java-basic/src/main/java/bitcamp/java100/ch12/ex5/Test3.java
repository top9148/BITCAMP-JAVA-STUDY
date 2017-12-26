// 클래스는 다중 상속은 불가능하지만 다중 구현은 가능하다.
// 
package bitcamp.java100.ch12.ex5;


public class Test3 implements A, C {
    
    // A의 m1()과 C의 m1()을 동시에 만족시킨다.
    @Override public void m1() {System.out.println("m1()");}
    
    // C의 m3()를 구현한 것이다. 
    @Override public void m3() {System.out.println("m3()");}
    
}



