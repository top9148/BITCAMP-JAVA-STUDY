// ## 문장(Statement) - 분기문 switch
// - switch 문 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_3 {

    public static void main(String[] args) {
        // ### switch 문법 및 용도
        // - 값에 따라 명령어를 분기시킬 때 유용한다.
        // - 문법
        //   switch (식) {
        //   case 값: 명령어; ... break;
        //   ..
        //   default: 명령어; ... 
        //   }
        
        // => 기본 사용법
        int level = -10;
        switch (level) {
        case 0: System.out.println("손님"); break;
        case 1: System.out.println("회원"); break;
        case 2: System.out.println("관리자"); break;
        default: System.out.println("유효하지 않은 회원입니다."); 
        }
        
        // => switch (expression) 에서 식(expression)으로 가능한 데이터 타입은?
        // - 식의 결과가 4바이트를 초과하지 않는 정수 데이터 타입(byte, short, int, char), 
        // - String, Enum
        byte b = 10;
        short s = 10;
        int i = 10;
        char c = 10;
        long l = 10;
        float f = 10.f;
        double d = 10;
        boolean bool = true;
        String str = "Hello";
        
        switch (b) {} // byte OK!
        switch (s) {} // short OK!
        switch (i) {} // int OK!
        switch (c) {} // char OK!
        switch (str) {} // String OK!
        
        //switch (l) {} // long Error!
        //switch (bool) {} // boolean Error!
        //switch (f) {} // float Error!
        //switch (d) {} // double Error!
        
        System.out.println("--------------------------");
        
        // => break
        // - case 문 다음에 break를 넣지 않으면 다음 문장을 계속 실행한다.
        level = 0;
        switch (level) {
        case 0: System.out.println("손님"); 
        case 1: System.out.println("회원");
        case 2: System.out.println("관리자");
        default: System.out.println("유효하지 않은 회원입니다."); 
        }
        
        System.out.println("--------------------------");
        
        // => break 활용
        // - 일부러 break를 생략하는 경우도 있다.
        String v1 = "어린이";
        switch (v1) {
        case "유아": // break를 만나거나 블록을 나갈 때까지 계속 아래로 실행한다.
        case "노인": System.out.println("무료승차"); break;
        case "어린이":
        case "중학생":
        case "고등학생":
        case "미성년": System.out.println("청소년 요금입니다."); break;
        case "성인":
        case "외국인": System.out.println("일반 요금입니다."); break;
        default: System.out.println("요금 계산 대상이 아닙니다.");    
        }
        
        System.out.println("--------------------------");
        
        // => default는 선택항목이다. 생략가능하다!
        switch (10) {
        case 10: System.out.println("값입니다.");
        }
        
        
    }
}













