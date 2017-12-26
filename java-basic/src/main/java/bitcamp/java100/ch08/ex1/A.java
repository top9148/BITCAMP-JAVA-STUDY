// 캡슐화(Encapsulation)
// - 멤버에 대한 접근을 제어하는 기법을 말한다.
// - 접근 레벨을 4 가지로 조정할 수 있다.
//   - public : 전체 공개 
//   - (default) : 같은 패키지에 소속된 클래스들에게만 공개
//   - protected : 같은 패키지 및 자손 클래스에게 공개
//   - private : 비공개
// 
package bitcamp.java100.ch08.ex1;

public class A {
    static private int v1;
    static int v2;
    static protected int v3;
    static public int v4;
}
