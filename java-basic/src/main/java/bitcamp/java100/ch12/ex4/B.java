// 인터페이스를 구현한 클래스를 상속 받기
package bitcamp.java100.ch12.ex4;

// B 클래스가 A를 상속 받으면 
// A가 구현한 Protocol 메서드까지 상속 받게 된다.
// 따라서 B 클래스도 Protocol을 구현한 것이 된다.
// 결론!
// 인터페이스를 구현한 클래스의 모든 자손 클래스들은
// 그 인터페이스를 구현한 것이 된다.
public class B extends A {
    void m3() {
        System.out.println("m3()");
    }
}
