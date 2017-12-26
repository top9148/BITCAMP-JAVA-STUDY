// 다형성 - 오버라이딩 문법 정리
package bitcamp.java100.ch08.ex7;

public class A {
    private void m1() {
        System.out.println("A.m1()");
    }
    void m2() {
        System.out.println("A.m2()");
    }
    protected void m3() {
        System.out.println("A.m3()");
    }
    public void m4() {
        System.out.println("A.m4()");
    }
}
