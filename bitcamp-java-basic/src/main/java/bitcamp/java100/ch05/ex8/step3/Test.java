// ## 키보드로부터 입력 받기 - 연습4
// - 다음과 같이 사용자로부터 이름, 이메일, 전화를 입력받아 출력하시오!
// - 실행 예) 
// 이름? 홍길동
// 이메일? hong@test.com
// 전화? 1111-1111
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 임꺽정
// 이메일? leem@test.com
// 전화? 1111-1112
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 유관순
// 이메일? yoo@test.com
// 전화? 1111-1113
// 저장하시겠습니까?(y/n) n
// 저장 취소하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 안중근
// 이메일? ahn@test.com
// 전화? 1111-1114
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) n
// ------------------------------
// 홍길동     hong@test.com 1111-1111
// 임꺽정     leem@test.com 1111-1112
// 안중근      ahn@test.com 1111-1114
// > 

package bitcamp.java100.ch05.ex8.step3;

import java.io.Console;

// 3단계: 계속 입력할지 여부를 묻는 기능 추가
public class Test {

    public static void main(String[] args) {
        // 콘솔 객체를 준비한다.
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
        // 값을 저장할 레퍼런스 배열을 만든다.
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] tels = new String[100];
        
        // 값이 저장될 위치
        int cursor = 0;
        
        // 배열의 개수 만큼 입력을 받는다.
        while (cursor < names.length) {
            names[cursor] = console.readLine("이름? ");
            emails[cursor] = console.readLine("이메일? ");
            tels[cursor] = console.readLine("전화? ");
            cursor++;
            String response = console.readLine("계속 입력하시겠습까?(y/n) ");
            if (!(response.toLowerCase().equals("y") || 
                  response.toLowerCase().equals("yes")))
                break;
        }
        
        // 배열에 저장된 값을 출력한다.
        for (int i = 0; i < cursor; i++) {
            System.out.println(names[i]);
            System.out.println(emails[i]);
            System.out.println(tels[i]);
        }
        
    }
}











