// 예외처리 문법정리 : try-with-resources 블록
package bitcamp.java100.ch13.ex6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
    
    static class MyClass implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("close() 호출됨!");
        }
    }
    
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();
        
        try (// AutoCloseable 구현체를 여기에 선언하면
             // 개발자가 따로 close()를 호출하지 않아도 된다.
             // try 블록을 벗어나면 JVM이 자동으로 close() 메서드를 
             // 호출할 것이다.
             MyClass obj = new MyClass()
        ) {
            System.out.println("try 블록 실행");
            
            switch (str) {
            case "a": throw new Exception();
            case "b": throw new IOException();
            case "c": throw new FileNotFoundException();
            case "d": throw new SQLException();
            }
            
            System.out.println(str);
        } catch (Exception e) {
            // try 블록에서 예외발생하면 실행한다.
            System.out.println("catch 블록 실행");
            
        } 

    }

}
