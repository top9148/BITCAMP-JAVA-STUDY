// 예외의 종류: 
// 1) try...catch... 사용을 강제하지 않는 예외
//    => Error와 RuntimeException 계열의 예외
//    => try...catch...로 예외를 처리하지 않더라도 컴파일 오류는 아니다!
// 
// 2) try...catch... 사용을 강제하는 예외
//    => Exception 계열의 예외 
//    => 즉 try...catch로 예외를 처리하지 않으면 컴파일 오류 발생!
// 
package bitcamp.java100.ch13.ex2;

import java.io.FileReader;

public class Test3 {

    public static void main(String[] args) {
        
        // 2) try...catch...로 예외를 처리해야 하는 경우,
        // Exception 계열의 예외는 반드시 try...catch...로 
        // 예외를 처리해야 한다.
        
        // 예) FileReader 객체를 생성할 때 발생한다.
        // => 생성자를 호출할 때 파라미터로 넘겨준 
        //    파일 경로가 유효하지 않을 때,
        //    FileNotFoundException이 발생한다.
        // => 이런 예외(Exception 계열의 예외)를 던지는 
        //    코드를 작성할 때는 반드시 try...catch...를 사용하여
        //    예외를 어떻게 처리할 것인지 명시해야 한다.
        //
        // 다음과 같이 명시하지 않으면 컴파일 오류가 발생한다.
        //
        //FileReader in = new FileReader("okok.txt");
        
        // try...catch...를 사용하여 예외 처리 코드를 추가하자.
        try {
            FileReader in2 = new FileReader("okok.txt");
            System.out.println("파일 읽기 준비 완료!");
            
        } catch (Exception e) {
            System.out.println("FileReader 객체 준비 중 오류 발생!");
        }
        
    }

}










