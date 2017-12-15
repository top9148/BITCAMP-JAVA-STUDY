package bitcamp.java100.ch11.ex6;

// 추상 클래스가 제공하는 필드와 메서드를 상속 받는다.
// 이렇게 추상 클래스는 서브 클래스를 만들 때 
// 필요한 필드와 메서드를 제공하는 용도로 사용한다.
public class B extends A {
    int v2;
    
    public void m2() {
        System.out.println("B.m2()");
    }
}
