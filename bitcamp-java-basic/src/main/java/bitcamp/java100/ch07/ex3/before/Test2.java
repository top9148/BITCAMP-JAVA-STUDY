// 상속 적용 전 - CalculatorB 클래스 테스트 하기
//
package bitcamp.java100.ch07.ex3.before;

public class Test2 {

    public static void main(String[] args) {
        CalculatorB calc = new CalculatorB();
        calc.value = 1;
        calc.multiple(10);
        calc.multiple(17);
        calc.divide(3);
        calc.remainder(5);
        
        System.out.println(calc.value);
        
    }

}
