// 인터페이스 구현하기 II
// 
package bitcamp.java100.ch12.ex3;

// 인터페이스에 선언된 모든 메서드를 구현하면 
// 추상 메서드가 없기 때문에 일반 클래스로 만들 수 있다.
//
public class Test2 implements Protocol3 {

    @Override
    public void m1() {
        System.out.println("m1()");
    }

    @Override
    public void m2(int v) {
        System.out.println("m2()");
    }

    @Override
    public void m3(String v) {
        System.out.println("m3()");
    }
}







