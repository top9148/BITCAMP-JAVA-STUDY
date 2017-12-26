// 예외처리 문법정리 : finally 사용
package bitcamp.java100.ch13.ex6;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();
        
        try {
            System.out.println("try 블록 실행");
            
        } finally {
            // finally 블록은 try 블록을 나가기 전에 반드시 실행한다.
            System.out.println("finally 블록 실행");
            
            // catch 블록 없이 사용할 수 있다.
            // 예외를 처리하는 것과 상관없이 사용한 자원을 
            // 자동으로 해제시키고 싶을 때 사용한다.
        }

    }

}
