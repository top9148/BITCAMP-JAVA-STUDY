// 패키지 멤버 클래스의 접근 범위
// => 즉 패키지에 소속된 클래스의 접근 범위는 
//    완전 공개(public)거나 같은 패키지에만 공개(default)하는 이 두가지만 가능하다.
// 
// => private과 protected는 불가능하다!
package bitcamp.java100.ch08.ex1;

// A클래스에는 public이 붙었기 때문에 다른 패키지의 클래스가 사용할 수 있었다.
// 그러나 B클래스는 public 이 붙지 않았기 때문에 오직 같은 패키지의 클래스만 사용할 수 있다.
class B {

}
