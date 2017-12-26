// 상속 사용 전 - 기존의 Calculator에 더하기와 빼기 기능을 추가한다.
//
package bitcamp.java100.ch07.ex1;

// 기능확장
// 방법 1) 기존 클래스에 기능을 추가한다.
//         => 기존 소스 코드에 새 코드를 추가하다보면 기존 코드를 건드릴 수도 있다.
//         => 그러면 새로운 버그가 발생할 가능성이 있다.
//         => 그래서 가능한 기존 소스를 손대지 않는 것이 유지보수에 좋다.
//
// 방법 2) 새 클래스를 만들어 기존 클래스의 코드를 복사하고 새 기능을 추가한다.
//         => 기존 소스를 손대지 않기 때문에 버그가 발생할 가능성은 줄어든다.
//         => 문제는, 
//            - 기존 코드를 복사/붙여넣기 해야 하는 번거로움이 있다.
//            - 기존 코드에 버그가 있을 때, 
//              그 코드를 복사해서 만든 모든 새 코드도 같은 버그를 갖는다.
//              버그를 잡으려면 기존 코드 뿐만 아니라 복사해서 사용한 모든 
//              코드를 찾아서 바꿔야 하는 번거로움이 있다.
//   
public class Test2 {

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
