// 상속 - Generalization을 이용
// CalculatorB와 CalculatorA의 공통 변수나 공통 메서드를 추출하여
// Calculator 클래스를 정의하였다.
// 그리고 CalculatorB는 Calculator 클래스를 상속 받았다.
//
package bitcamp.java100.ch07.ex3.after;

public class Test2 {

    public static void main(String[] args) {
        CalculatorB calc = new CalculatorB(1);
        calc.multiple(10);
        calc.multiple(17);
        calc.divide(3);
        calc.remainder(5);
        
        System.out.println(calc.result);
        
    }

}
