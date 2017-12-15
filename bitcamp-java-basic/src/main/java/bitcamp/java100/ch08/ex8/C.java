package bitcamp.java100.ch08.ex8;

public class C extends A {
    // 리턴 타입만 다른 메서드를 추가할 수 없다.
    // 왜? 
    // => 호출할 때 파라미터의 타입이나 개수, 순서로 
    //    메서드를 찾는데, 
    //    리턴 타입이 다른 경우는 구분할 수 없다.
    // => 메서드를 호출할 때 리턴 값을 받드시 받는 것은 아니기 때문이다.
    // 
    int m1(int a) { // 컴파일 오류!
        System.out.println("int m1(int)");
    }
    
    
    
}
