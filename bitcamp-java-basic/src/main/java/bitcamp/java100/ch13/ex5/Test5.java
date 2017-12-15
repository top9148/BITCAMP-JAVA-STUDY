// 예외처리 문법정리 : 예외 클래스의 상속 관계와 catch 블록
package bitcamp.java100.ch13.ex5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test5 {

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
            
        } catch (IOException e) {
            // 예외를 구분해서 처리하고 싶다면,
            // 파라미터를 선언할 때 자식 클래스부터 나열하라!
            // 부모 클래스부터 나열하면 Test4와 같이 컴파일 오류가 발생!
            // 왜? 부모 클래스의 파라미터가 모든 예외를 받기 때문이다.
            System.out.println("IOException 처리");
            
        } catch (Exception e) {
            System.out.println("Exception 처리");
            
        } 

    }

}
