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

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test4 {

    public static void main(String[] args) throws FileNotFoundException {
        
        // 2) try...catch...로 예외를 처리해야 하는 경우,
        // 만약 try...catch...를 사용하기 싫다면,
        // 메서드 선언부에 어떤 예외가 발생하는지 
        // 개발자가 직접 명시해야 한다.
        //
        FileReader in = new FileReader("okok.txt");
        System.out.println("파일 읽기 준비 완료!");
        
        // 물론 이 방식은 임시 방편이다.
        // 결국 예외가 발생하면 이 메서드의 호출자에게 전달된다.
        // 즉 여기에서 발생하는 예외는 당장 처리하지 않고,
        // 호출자에게 그 처리를 떠넘기겠다는 의미다.
        
        // 주요 예외 클래스의 상속 관계(계층도)
        // java.lang.Object
        // => java.lang.Throwable (예외 클래스의 최상위 조상)
        //    => java.lang.Error 
        //       - JVM에서 발생되는 치명적인 예외.
        //       - "시스템 예외"라 부른다.
        //       - 이런 예외는 개발자가 처리할 필요가 없다.
        //       - 아니 처리할 수 없는 예외다.
        //       - 예를 들면 메모리가 부족할 때 발생하는 예외 등이다.
        //       - 이런 예외가 발생하면 개발자는 즉시 
        //         현재 작업중인 내용을 저장하고 JVM을 멈춰야 한다.
        //    => java.lang.Exception 
        //       - 애플리케이션 실행 중에 발생되는 예외
        //       - "애플리케이션 예외"라 부른다.
        //       - 이 예외는 개발자가 처리해야 한다.
        //       - 적절한 조치를 취한 후 프로그램을 계속 실행하도록 
        //         해야 한다.
        //       => java.lang.RuntimeException
        //          - 이 클래스는 Exception의 서브 클래스이지만,
        //            Error 예외 동일하게 
        //            try...catch..를 사용하지 않아도 된다.
    }

}











