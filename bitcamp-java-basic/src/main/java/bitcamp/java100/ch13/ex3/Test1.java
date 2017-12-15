// finally 블록이 필요한 경우
package bitcamp.java100.ch13.ex3;

import java.io.FileReader;

public class Test1 {

    public static void main(String[] args) {
        
        // 객체의 예외를 처리할 때 finally 블록이 필요한 경우가 있다.
        // 객체를 사용한 후에 반드시 자원을 해제시켜야 하는 경우가 있다.
        // 정상적으로 실행하든, 예외가 발생했든 상관없이 
        // 자원 해제를 시켜야 하는 경우가 있는데,
        // 그럴 경우에 사용하라고 만든 문법이 finally이다.
        //
        FileReader in = null;
        try {
            in = new FileReader("./build.gradle2");
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
            
        } finally {
            System.out.println("finally 실행!");
            // try 블록이 정상적으로 실행되든
            // 오류가 발생하여 catch 블록이 실행되든 상관없이 
            // finally 블록은 반드시 실행된다.
            // 그래서 이 블록에는 
            // 주로 사용한 자원을 해제시키는 코드를 둔다.
            try { 
                in.close(); // close() 메서드도 예외를 던질 수 있기 때문에
                            // try...catch... 블록 안에서 실행해야 한다.
            } catch (Exception e) {
                // 물론 close()하다가 예외가 발생한 것은 처리할 필요가 없다.
                // 사용한 파일을 해제시키다가 오류가 발생했는데
                // 처리할 것이 뭐가 있겠는가? 그냥 둔다.
            }
        }

    }

}
