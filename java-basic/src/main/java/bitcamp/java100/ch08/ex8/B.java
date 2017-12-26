package bitcamp.java100.ch08.ex8;

public class B extends A {
    // A로부터 상속 받은 메서드와 이름은 같지만,
    // 파라미터가 다른 메서드를 추가했다면,
    // 이 또한 오버로딩이다.
    // 즉 상속한 메서드와 같은 이름의 메서드를 추가하는 것도 
    // 오버로딩이다.
    void m1(float a) {
        System.out.println("B의 m1(float)");
    }
}
