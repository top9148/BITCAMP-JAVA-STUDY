// 클래스의 접근 범위 테스트 I
package bitcamp.java100.ch08.ex1;

public class Test4 {

    public static void main(String[] args) {
        
        // Test4는 B 클래스랑 같은 패키지에 소속된 클래스이기 때문에 사용할 수 있다.
        new B(); // OK!

    }

}
