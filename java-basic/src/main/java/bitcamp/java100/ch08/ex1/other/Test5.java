// 클래스의 접근 범위 테스트 II

package bitcamp.java100.ch08.ex1.other;

import bitcamp.java100.ch08.ex1.A; // OK! 왜? public 이기 때문에.
//import bitcamp.java100.ch08.ex1.B; // 접근 불가! 왜? (default) 이기 때문에.

public class Test5 {
    public static void main(String[] args) {
        new A(); // OK!
        //new B();
    }
}
