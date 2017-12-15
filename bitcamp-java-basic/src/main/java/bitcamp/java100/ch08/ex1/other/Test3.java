// 캡슐화 - 다른 패키지의 서브 클래스에서 멤버에 접근할 경우
package bitcamp.java100.ch08.ex1.other;

import bitcamp.java100.ch08.ex1.A;

public class Test3 extends A {

    public static void main(String[] args) {
        
        // Test3는 A클래스와 다른 패키지에 있다 하지만 A의 서브 클래스이다.
        // => private 멤버?
        //A.v1 = 100; // 접근 불가!
        
        // => (default) 멤버?
        //A.v2 = 200; // 접근 불가!
        
        // => protected 멤버
        A.v3 = 300; // OK!
        
        // => public 멤버
        A.v4 = 400; // OK!
    }

}
