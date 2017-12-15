// 예외처리 문법정리 : try ~ catch ~ 
package bitcamp.java100.ch13.ex5;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();
        
        try {
            System.out.println("try 블록 실행");
            // try 블록은 예외가 발생할 수 있는 코드를 두는 블록이다.
            // 이 블록에서 예외가 발생하면 catch 블록을 실행한다.
            if (str.equals("y")) {
                throw new Exception(); // 예외 발생!
            }
            
            System.out.println(str);
            
        } catch (Exception e) {
            System.out.println("catch 블록 실행");
            // catch 블록은 try 블록에서 예외가 발생했을 때 
            // 실행되는 블록이다.
            // try 블록에서 발생된 예외는 파라미터로 전달된다.
        }

    }

}
