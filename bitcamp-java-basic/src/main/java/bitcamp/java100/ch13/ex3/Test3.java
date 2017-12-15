// try-with-resources 테스트
package bitcamp.java100.ch13.ex3;

import java.io.FileReader;
import java.util.ArrayList;

public class Test3 {

    public static void main(String[] args) {
        
        class MyClass {}
        
        class MyClass2 implements AutoCloseable {
            @Override
            public void close() throws Exception {
                System.out.println("close() 호출되었음!");
            }
        }
        
        try (
                // 이 괄호 안에 넣을 수 있는 객체는 
                // 반드시 java.lang.AutoCloseable 규칙에 따라 만든 
                // 클래스의 객체여야 한다.
                // 
                // 정말 close() 메서드가 자동 호출되는 지 확인하자!
                
                // MyClass는 AutoCloseable을 구현하지 않았기 때문에
                // 이 괄호 안에 둘 수 없다.
                //MyClass obj = new MyClass();
                
                // MyClass2는 AutoCloseable을 구현했기 때문에
                // 이 괄호 안에 둘 수 있다.
                MyClass2 obj2 = new MyClass2();
        ) {
            
            System.out.println("try 블록 실행!");
            
            int r = 20 / 0; // 0으로 나누기 때문에 예외 발생한다.
            
        } catch (Exception e) {
            System.out.println("catch 블록 실행!");
            
        } 

    }

}
