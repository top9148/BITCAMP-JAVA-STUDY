// 예외처리 문법정리 : throw를 이용하여 예외 던지기 
package bitcamp.java100.ch13.ex7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Test1 {

    static void m1(int i) throws Throwable {
        if (i < 0) {
            // 예외 상태일 때 Throwable 객체를 호출자에게 던진다.
            // ==> 문법) throw Throwable객체;
            // 그리고 메서드 선언부에 어떤 예외를 던지는지
            // 그 타입을 지정해야 한다.
            // ==> 문법) throws 타입명, 타입명
            throw new Throwable();
        }
    }
    
    // 메서드에서 여러 타입의 예외를 던진다면
    // 메서드 선언부에 그 타입을 나열하면 된다.
    // 타입을 나열할 때 순서는 상관없다. 
    // 부모 클래스를 먼저 나열하든 자식 클래스를 먼저 나열하든 
    // 상관없다.
    static void m2(int i) throws SQLException, Exception,  
            IOException, FileNotFoundException {
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        }
    }
    
    // 메서드에서 던지는 모든 예외를 받을 타입을 지정해도 된다.
    static void m3(int i) throws Exception {
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        }
    }
    
    // 물론 그 클래스의 수퍼 클래스를 지정해도 된다.
    static void m4(int i) throws Throwable {
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        }
    }
    
    // 그러나 Throwable 타입이 아닌 것은 안된다.
    /* 컴파일 오류!
    static void m5(int i) throws Object { 
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        }
    }    
    */
    
    // Throwable 타입이 아닌 것은 던질 수 없다.
    /* 컴파일 오류!
    static void m6(int i) throws String { 
        switch (i) {
        case 1: throw new Exception();
        case 2: throw new SQLException();
        case 3: throw new IOException();
        case 4: throw new FileNotFoundException();
        case 5: throw new String();
        }
    }
    */
    
    public static void main(String[] args) {

    }

}
