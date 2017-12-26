// ## 키보드로부터 입력 받기 II
// - Console 클래스를 사용하여 키보드로부터 입력 받는 방법을 알아보자!
//

package bitcamp.java100.ch05;

import java.io.Console;

public class Test2 {
    public static void main(String[] args) {
        
        // 콘솔 객체를 준비한다.
        Console console = System.console();
        
        // Eclipse에서 바로 실행할 경우 noninteractive 환경으로 인식하여
        // Console 객체를 리턴하지 않는다.
        // 이럴 경우 명령창(콘솔창)에서 바로 프로그램을 실행하라!
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
        // 키보드로부터 한 줄 입력 받는다.
        String line = console.readLine("입력하세요:");
        
        System.out.println(line);
    }
}











