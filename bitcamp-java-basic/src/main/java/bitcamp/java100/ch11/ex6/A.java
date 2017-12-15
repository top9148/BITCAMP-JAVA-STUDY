package bitcamp.java100.ch11.ex6;

// 추상 클래스
// => 서브 클래스가 사용할 필드와 메서드를 물려주는 역할을 한다.
public abstract class A {
    int v1;
    
    public void m1() {
        System.out.println("A.m1()");
    }
}
