// 상속(inheritance) - 상속을 이용하면 기존 코드를 변경하기 쉽다. 
//
package bitcamp.java100.ch07.ex2;

// 기존 코드에 문제가 있으면 그 코드를 수정하는 즉시 서브 클래스들은 
// 수정된 코드를 사용하게 된다.
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
        // => 이 버그를 해결하기 위해 기존의 Calculator.java 클래스를 변경하였다.
        //    그러면 CalculatorA와 CalculatorB를 손대지 않고도 변경 내용을
        //    적용할 수 있어 유지보수에 매우 좋다!
        //
        // 상속에 대한 오해!
        // => 상속이라는 단어가 갖는 뜻 때문에 개발자들이 많은 오해를 한다.
        // => 즉 "서브 클래스는 수퍼 클래스의 코드를 자동으로 복사해올 것이다" 라는 오해!
        // => 절대 아니다. 서브 클래스는 단지 수퍼 클래스에 대한 링크 정보만 갖고 있는다.
        //    수퍼 클래스의 멤버(변수나 메서드)를 사용할 때 마다
        //    그 수퍼 클래스에 찾아가서 코드를 실행한다.
        // => 그래서 서브 클래스를 사용하려면 반드시 그 서브 클래스가 링크하는 
        //    모든 수퍼 클래스가 있어야 한다.
        // 

        
        calc.multiple(17);
        
        System.out.println(calc.result);
        
        
        
    }

}
