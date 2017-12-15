// 예외처리 문법정리 : 예외 클래스의 상속 관계와 catch 블록
package bitcamp.java100.ch13.ex5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();
        
        try {
            System.out.println("try 블록 실행");
            
            switch (str) {
            case "a": throw new Exception();
            case "b": throw new IOException();
            case "c": throw new FileNotFoundException();
            case "d": throw new SQLException();
            }
            
            System.out.println(str);
            
        } catch (Exception e) {
            // 다형적 변수라는 문법에 따라
            // Exception 파라미터는 try 블록에서 발생하는
            // 모든 예외 객체를 담을 수 있다.
            //
            System.out.println("catch 블록 실행");
            
        } catch (IOException e) {
            // try 블록에서 발생되는 예외 중에서 IOException만 
            // 따로 처리하고 싶다면 catch 블록을 분리하라!
            // 단, catch 블록의 순서는 다형적 변수를 고려하여 정하라!
            // 
            // Exception 파라미터는 IOException 객체도 담을 수 있기 때문에
            // 이 블록으로 도달 할 수 없다.
        }

    }

}
