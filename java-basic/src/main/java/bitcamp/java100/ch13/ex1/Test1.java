// 예외 처리 문법을 사용하기 전
package bitcamp.java100.ch13.ex1;

import java.io.Console;

public class Test1 {

    public static void main(String[] args) {
        
        // 사용자로부터 키보드로 값을 입력 받아 계산 하는 프로그램
        Console console = System.console();
        
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
        
        // 이 예제의 문제점?
        // => 콘솔 모드로 입력한 값을 읽어들일 수 없는 상황에서는
        //    System.console()의 리턴 값 null 이 된다.
        // => 그런 경우 readLine() 메서드를 호출하지 못한다.
        // => 이런 예외 상황이 발생했을 때 사용자에게 그 상황에 대해 
        //    부드럽게 안내할 필요가 있다.
        // => 그래서 개발자들이 취하는 방식은,
        //    리턴 값을 사용하기 전에 항상 그 리턴 값이 유효한지 여부를
        //    검사하는 것이다.
        //    즉 System.console()의 리턴 값이 유효한지 검사할 필요가 있다.
        //    검사해야 한다. 안하면 지금 이 예제처럼 실행하다 말고,
        //    프로그램을 멈추게 된다.
        // => 주의!
        //    실행에 치명적인 부분을 모두 찾아서 검사하라는 것이 아니다.
        //    가능한 최대한 찾아서 검사하라는 얘기다.

    }

}






