// 예외 처리 문법을 사용하여 예외 상황을 처리하기
package bitcamp.java100.ch13.ex1;

import java.io.Console;

public class Test3 {

    public static void main(String[] args) {
        
        // 사용자로부터 키보드로 값을 입력 받아 계산 하는 프로그램
        Console console = System.console();
        
        // 콘솔을 사용할 수 있는지 여부를 검사한 후 사용하자!
        // => 이전 Test1 예제보다 훨씬 더 예외 상황을 부드럽게 처리한다.
        if (console == null) {
            System.out.println("콘솔 입력을 지원하지 않습니다.");
            System.exit(1);
        }
        
        while (true) {
            try { 
                // 예외 상황이 발생할 가능성이 있는 코드는 
                // try 블록에 둔다.
                int a = Integer.parseInt(console.readLine("a? "));
                String op = console.readLine("연산자? ");
                int b = Integer.parseInt(console.readLine("b? "));
                
                switch (op) {
                case "+": System.out.printf("결과=%d\n", a + b); break;
                case "-": System.out.printf("결과=%d\n", a - b); break;
                case "*": System.out.printf("결과=%d\n", a * b); break;
                case "/": System.out.printf("결과=%d\n", a / b); break;
                case "%": System.out.printf("결과=%d\n", a % b); break;
                default: System.out.println("지원하지 않는 연산자입니다.");
                }
            } catch (Throwable err) {
                // 예외 상황이 발생할 경우 어떻게 처리할 지 
                // 그 코드를 둔다.
                // => 이 예제에서는 오류가 발생했을 때 
                //    간단히 안내를 출력하고 
                //    프로그램 멈춤없이 계속 실행한다.
                // => 이것이 try...catch... 문법을 사용하는 이유이다.
                System.out.println("숫자 형식이 올바르지 않습니다.");
            }
            
            // 예외가 발생할 가능성이 있는 코드를 
            // try...catch... 블록에 묶어두면 
            // 다음 두 가지의 이익을 얻을 수 있다. 
            // 
            // 1) 예외가 발생하더라도
            //    프로그램을 멈추지 않고 계속 실행할 수 있다.
            // 
            // 2) 예외를 처리하는 코드와 원래 실행 코드를 분리함으로써
            //    코드의 가독성을 높여준다.
            // 
            // 이것이 예외처리 문법을 사용하는 이유이다!
            
        }

    }

}






