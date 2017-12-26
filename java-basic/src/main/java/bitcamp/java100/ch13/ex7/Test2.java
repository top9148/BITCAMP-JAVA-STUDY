// 예외처리 문법정리 : throw를 이용하여 예외 던지기 
package bitcamp.java100.ch13.ex7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Test2 {

    static void m1(int i) throws SQLException, Exception,  
            IOException, FileNotFoundException {
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        }
    }
    
    public static void main(String[] args) 
            throws IOException, Exception {
        
        // 예외를 던지는 메서드 호출할 때
        
        // 1) try~ catch~ catch~ ...로 예외 받기
        try {
            m1(2);
        } catch (FileNotFoundException e) {
        } catch (SQLException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        
        // 2) try~ catch~ 로 예외 받기
        try {
            m1(1);
        } catch (Exception e) {
        }
        
        // 3) 일부는 받고 일부는 상위 호출자에게 책임을 떠넘기기
        try {
            m1(3);
            // m1() 메서드가 던지는 예외 중에서 2개만 받고 
            // 나머지는 main()을 호출한 쪽에 떠넘기기
            // => main() 메서드 선언부에 떠넘기는 예외를 명시하라!
            // 주의!
            // => main() 메서드의 호출자에게 예외를 전달하는 것은 
            //    바람직하지 않다.
            // => main()의 호출자는 JVM이고 JVM은 예외를 받는 순간
            //    즉시 프로그램을 종료할 것이다.
        } catch (SQLException e) {
        } catch (FileNotFoundException e) {
        }
        
    }

}







