// 상속 사용 전 - 기존의 Calculator에 나눈 나머지 구하는 기능 추가
//
package bitcamp.java100.ch07.ex1;

// 기능확장
// 방법 2) 새 클래스를 만들어 기존 클래스의 코드를 복사하고 새 기능을 추가한다.
//   
public class Test3 {

    public static void main(String[] args) {
        CalculatorB calc = new CalculatorB();
        calc.result = 1;
        calc.multiple(10);
        calc.multiple(17);
        calc.divide(0);
        calc.remainder(5);
        
        System.out.println(calc.result);
        
    }

}
