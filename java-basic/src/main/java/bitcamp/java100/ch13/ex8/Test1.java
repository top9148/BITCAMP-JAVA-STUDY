// 예외처리 문법정리 : 예외 체인
package bitcamp.java100.ch13.ex8;

public class Test1 {

    static void m1() {
        m2();
    }
    
    static void m2() {
        m3();
    }
    
    static void m3() {
        m4();
    }
    
    static void m4() {
        
    }
    
    public static void main(String[] args) {
        // 예외가 개입되지 않을 경우에는 메서드를 정의하거나 
        // 호출할 때 아무런 문제가 없다.
        m1();
    }

}
