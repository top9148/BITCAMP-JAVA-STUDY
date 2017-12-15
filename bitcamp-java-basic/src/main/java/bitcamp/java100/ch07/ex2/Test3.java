// 상속(inheritance) - 기존의 Calculator에 나눈 나머지 구하는 기능 추가
//
package bitcamp.java100.ch07.ex2;

// 상속 문법을 이용하여 어떤 클래스의 코드를 사용할 것인지 지정한다.
// 그리고 새 기능을 추가한다.
// 
public class Test3 {

    public static void main(String[] args) {
        // CalculatorB의 인스턴스를 생성할 때,
        // => 수퍼 클래스를 찾아 올라가서 그 클래스에 정의된 인스턴스 변수를 확인하여 
        //    만든다.
        // 
        CalculatorB calc = new CalculatorB();
        
        calc.result = 1;

        // 현재 클래스에 해당 메서드가 없으면, 수퍼 클래스에서 찾아 본다.
        calc.multiple(10); // 수퍼 클래스(Calculator)에서 찾았다. 
        calc.multiple(17); // 수퍼 클래스(Calculator)에서 찾았다.
        calc.divide(3); // 수퍼 클래스(Calculator)에서 찾았다.
        calc.remainder(5); // 현재 클래스(CalculatorB)에서 찾았다.
        
        System.out.println(calc.result);
        
    }

}
