package bitcamp.java100.ch06.ex4;

public class Calculator3 {
    // 계산결과를 여러 개 개별적으로 관리하기 위해 
    // 인스턴스 변수로 전환한다!
    int result;

    // 인스턴스 멤버를 보다 쉽게 다루기 위해 인스턴스 메서드로 전환한다.
    // => static을 붙이지 않는다.
    // => 인스턴스 주소를 받기 위한 파라미터 변수를 선언할 필요가 없다.
    // => 이미 this라는 이름의 변수가 내장되어 있다.
    // => 이 변수에 호출할 때 넘겨준 인스턴스 주소가 보관되어 있다.
    void plus(int value) {this.result += value;}
    void minus(int value) {this.result -= value;}
    void multiple(int value) {this.result *= value;}
    void divide(int value) {this.result /= value;}
}
