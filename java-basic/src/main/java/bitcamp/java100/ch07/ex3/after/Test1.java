// ## 상속 - Generalization 적용
// 상속은 크게 두 가지의 기법이 있다.
//
// 1) Specialization
//    - 수퍼 클래스를 상속 받아 기능을 추가하여 더 특별한 서브 클래스를 만드는 것.
//
// 2) Generalization
//    - 서브 클래스들의 공통 변수나 공통 메서드를 추출하여 수퍼 클래스를 정의하는 것.
// 
// 이 예에서는 CalculatorA와 CalculatorB의 공통 변수와 공통 메서드를 추출하여
// Calculator 수퍼 클래스를 만들 것이다.
// 그리고 기존의 CalculatorA와 CalculatorB는 그 클래스의 서브 클래스로 선언할 것이다.
// 
package bitcamp.java100.ch07.ex3.after;

public class Test1 {

    public static void main(String[] args) {
        CalculatorA calc = new CalculatorA();
        calc.plus(10);
        calc.plus(20);
        calc.minus(7);
        calc.multiple(2);
        calc.divide(3);
        
        System.out.println(calc.result);
        
    }

}
