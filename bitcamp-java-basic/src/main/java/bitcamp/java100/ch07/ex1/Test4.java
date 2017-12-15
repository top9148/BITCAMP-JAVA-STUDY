// 상속 사용 전 - 기존의 코드를 복사해서 사용할 때 문제점
//
package bitcamp.java100.ch07.ex1;

// 기존 코드에 문제가 있으면 그 코드를 사용해서 만든 모든 코드를 변경해야 한다.
//   
public class Test4 {

    public static void main(String[] args) {
        // 기존의 Calculator를 사용하여 작업을 수행한다.
        Calculator calc = new Calculator();
        calc.result = 1;
        calc.multiple(5);
        
        // 무심코 0으로 나눈다.
        // => 기존의 divide()는 0으로 나누는 경우를 처리하지 않았기 때문에
        //    즉시 실행 오류(RuntimeException)를 발생시킨다.
        // => JVM은 실행 오류를 보고 받으면 즉시 프로그램 실행을 멈춘다.
        calc.divide(0);
        // => 이 버그를 해결하기 위해 기존의 Calculator.java 클래스를 변경하였고,
        //    이 클래스를 복사해서 기능을 추가한 CalculatorA와 CalculatorB도 변경하였다.
        //
        // 이렇게 기존 코드를 복사해서 새 기능을 추가하는 방식은 
        // 유지보수하기가 매우 어렵다.

        
        calc.multiple(17);
        
        System.out.println(calc.result);
        
        
        
    }

}
