// 오버라이딩 규칙
// => 접근 범위: 같거나 확장
// => 리턴 타입: 반드시 일치
// => 메서드명 : 반드시 일치
// => 파라미터 타입 및 개수 및 순서: 반드시 일치
// => 파라미터명: 상관없음
package bitcamp.java100.ch08.ex7;

public class B2 extends B {
    // 오버라이딩을 바르게 한 것!
    //void m1(int a, String s) {} // OK!
    //protected void m1(int a, String s) {} // OK!
    //public void m1(int a, String s) {} // OK!
    //void m1(int x, String y) {} // OK! 파라미터명은 달라도 된다.
    
    // 리턴 타입 불일치
    //int m1(int a, String s) {} // 컴파일 오류!
    void m1_1(int a, String s) {} // 새 메서드 추가한 것!
    
    void m1(String a, String s) {} // 파라미터의 타입이 다르면 새 메서드 추가한 것!
    void m1(String s, int a) {} // 파라미터의 순서가 다르면 새 메서드 추가한 것!
    void m1(int a) {} // 파라미터의 개수가 다르면 새 메서드 추가한 것!
    
    // 이렇게 메서드명은 같지만 파라미터의 타입이 다르거나 개수, 순서가 다른 경우
    // 새로 메서드를 추가한 것으로 본다. 
    // 즉 같은 이름을 갖는 새 메서드가 추가된 것이다.
    // 이것을 "오버로딩(overloading)"이라 한다.
}












