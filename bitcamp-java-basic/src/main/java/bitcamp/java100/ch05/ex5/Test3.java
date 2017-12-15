// ## 키보드로부터 입력 받기 - 연습1
// - 다음과 같이 사용자로부터 구구단 번호를 입력 받아 출력하라!
// - 실행 예) 
// 구구단? 2
// 2 * 1 = 2
// 2 * 2 = 4
// 2 * 3 = 6
// ...
// 2 * 9 = 18
// --------------------------
// 구구단? 10
// 2에서 9단까지만 가능합니다!
// 구구단? 1
// 2에서 9단까지만 가능합니다!
// 구구단? 0    <===== 0이하의 수를 입력하면 종료하라!
// 다음에 또 봐요!
// > 

package bitcamp.java100.ch05.ex5;

import java.io.Console;

// 3단계: 메서드 분리
public class Test3 {
    
    // 클래스 변수
    // => 클래스를 실행하기 위해 HDD에서 메모리로 로딩할 때 생성되는 변수이다.
    // => new 명령으로 생성되는 변수가 아니다.
    static Console console;
    
    static void prepareInput() {
        console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
    }
    
    static int promptGugudan() {
        int i = Integer.parseInt(console.readLine("구구단? "));
        
        if (i >= 10 || i == 1) {
            System.out.println("2에서 9단까지만 가능합니다!");
            System.exit(1);

        } else if (i == 0) {
            System.out.println("다음에 또 봐요!");
            System.exit(1);
        }
        
        return i;
    }
    
    static void printGugudan(int i) {
        for (int j = 1; j < 10; j++) {
            System.out.printf("%d * %d = %d\n", i, j, i*j);
        }
    }
    
    public static void main(String[] args) {
        
        prepareInput();
        
        int i = promptGugudan();
        
        printGugudan(i);
    }
}









