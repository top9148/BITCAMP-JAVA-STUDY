package bitcamp.java100.ch21.ex2;

// 특정 위치에 삽입될 코드를 갖고 있는 클래스를 정의한다.
//
public class MyAdvice {
    
    // 삽입될 코드는 메서드로 정의한다.
    public void advice1() {
        System.out.println("MyAdvice.advice1()");
    }
    
    public void advice2() {
        System.out.println("MyAdvice.advice2()");
    }
}
