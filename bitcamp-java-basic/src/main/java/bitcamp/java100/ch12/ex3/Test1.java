// 인터페이스 구현하기
// 
package bitcamp.java100.ch12.ex3;

// 인터페이스에 선언된 모든 메서드를 구현해야 한다.
// 한 개라도 빠뜨리면 추상 메서드인채로 존재하기 때문에
// 추상 메서드를 가질 수 있는 클래스는 추상 클래스만이 가능함으로 
// 클래스를 추상 클래스로 선언해야 한다.
//
public abstract class Test1 implements Protocol3 {

    @Override
    public void m1() {}

    @Override
    public void m2(int v) {}

    // m3()를 구현하지 않는다면 추상 메서드가 존재하는 상태이기 때문에
    // 추상 클래스로 선언해야 한다.
    /*
    @Override
    public void m3(String v) {}
    */

}
