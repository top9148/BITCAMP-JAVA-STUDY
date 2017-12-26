// 상속을 이용한 기능 확장
// 
package bitcamp.java100.ch07.ex2;

// 기존 클래스의 링크 정보를 등록한다.
// 문법:
// class 클래스명 extends 기존클래스명 {...}
//
public class CalculatorA extends Calculator {

    // 기존의 Calculator가 갖고 있는 코드는 이 클래스에 복사해올 필요가 없다.
    // 단지 다음과 같이 새 기능만 추가하면 된다.
    // => 이것이 상속의 장점이다.
    // 
    void plus(int value) {
        this.result += value;
    }
    
    void minus(int value) {
        this.result -= value;
    }
    
}
