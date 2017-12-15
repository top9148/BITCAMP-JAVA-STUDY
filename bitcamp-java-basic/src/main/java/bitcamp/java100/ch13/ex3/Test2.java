// finally 보다 자원을 해제시키는 더 쉬운 방법
package bitcamp.java100.ch13.ex3;

import java.io.FileReader;
import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        
        // 자원을 해제시키기 위해 개발자가 직접 
        // finally 블록에 코드를 작성해야 하는 번거로움이 있다.
        // 이를 간편하게 해주는 문법이 있다.
        // try-with-resources 문법이다.
        //
        
        try (
                // 이 괄호 안에 넣을 수 있는 객체는 
                // 반드시 java.lang.AutoCloseable 규칙에 따라 만든 
                // 클래스의 객체여야 한다.
                // 즉 AutoCloseable 인터페이스를 구현한 클래스는 
                // 사용할 수 있다.
                // AutoCloseable 인터페이스에 뭐가 선언되어 있길래?
                // => close() 메서드가 있다.
                // 즉 try 블록이나 catch 블록 실행을 완료하면
                // JVM이 자동으로 이 괄호 안에 생성한 객체에 대해
                // AutoCloseable 규칙에 따라 close() 메서드를 
                // 자동으로 호출한다.
                //
                // => FileReader는 AutoCloseable 구현체이기 때문에
                //    이 괄호 안에 둘 수 있다.
                //
                FileReader in = new FileReader("./build.gradle");
                
                // String 클래는 AutoCloseable 구현체가 아니기 때문에
                // 이 괄호 안에서 사용할 수 없다.
                //String s = new String("test.."); // 컴파일 오류!
                //ArrayList<String> list = new ArrayList<>();
            ) {
            System.out.println("파일 읽기 준비 완료!");
            
            int ch;
            while (true) {
                ch = in.read();
                if (ch == -1) break;
                System.out.print((char)ch);
            }
            System.out.println("--------------------------");
            
        } catch (Exception e) {
            System.out.println("파일 읽기 중 오류 발생!");
            
        } 

    }

}
