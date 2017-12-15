// 상속(inheritance) - 기존의 Calculator에 더하기와 빼기 기능을 추가한다.
//
package bitcamp.java100.ch07.ex2;

// 상속으로 기능 확장하기
// - 상속을 이용하면 기존의 코드를 손대지 않고 기능을 확장할 수 있다.
// - 기존의 기능을 복사할 필요도 없다.
// - 단지 기존 코드의 링크 정보를 기술한 다음에 
//   새 기능을 추가하면 된다.
// - 이때 상속을 해주는 클래스를 "수퍼(super)/부모(parent) 클래스"라고 부른다.
//   상속을 받는 클래스를 "서버(sub)/자식(child) 클래스"라고 부른다.
// 
public class Test2 {

    public static void main(String[] args) {
        // CalculatorA의 인스턴스를 만드는 과정
        // 1) CalculatorA가 참조하는 수퍼 클래스가 있다면 
        //    그 클래스의 코드를 보고 인스턴스 변수를 생성한다.
        //    => int result 변수를 생성한다.
        //
        // 2) CalculatorA의 인스턴스 변수가 있다면 생성한다.
        //    => 없다.
        CalculatorA calc = new CalculatorA();

        // 메서드를 호출하는 과정
        // 1) 현재 클래스(CalculatorA)에서 메서드를 찾는다.
        //    => 있다, 호출한다.
        //    => 없다, 수퍼 클래스(...의 수퍼 클래스, ...의 수퍼 클래스) 에서 찾는다.
        //             있으면, 호출한다.
        //             없으면, 컴파일 오류!
        // 
        calc.plus(10); // 현재 클래스(CalculatorA)에 있다.
        calc.plus(20); // 현재 클래스(CalculatorA)에 있다.
        calc.minus(7); // 현재 클래스(CalculatorA)에 있다.
        calc.multiple(2); // 수퍼 클래스(Calculator)에서 찾았다.
        calc.divide(3); // 수퍼 클래스(Calculator)에서 찾았다.
        
        System.out.println(calc.result);
        
    }

}

// 
// 










