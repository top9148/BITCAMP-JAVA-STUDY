// # 자바에서 값 표현(literal)하기 - 이스케이프(escape) 문자
//
package bitcamp.java100.ch02;

public class Test11_3 {

    public static void main(String[] args) {
// 특정 명령을 수행하는 문자
// 
        System.out.print("ABC");
        System.out.print('\b'); // Backspace : 커서를 뒤로 한 칸 이동
        System.out.println("123");

        System.out.println("ABC\t123"); // Tab : 커서를 OS의 기본 칸 수 만큼 이동 
        System.out.println("ABC\u0009123"); // Tab에 대해 유니코드 값을 직접 지정해도 된다.
        System.out.println("ABC\n123"); // Line Feed(LF; 0x000a) : 커서를 처음으로 되돌리고 다음 줄로 이동한다.
        System.out.println("ABC\r123"); // Carrage Return(CR; 0x000d) : 커서를 처음으로 옮긴다. 
        System.out.println("ABC\f123"); // Form Feed : 커서를 다음 줄로 이동한다.
        System.out.println("ABC\"123"); // double quote
        System.out.println("ABC'123"); // single quote 
        System.out.println('\''); // single quote 
        System.out.println('"'); // double quote 
        System.out.println("c:\\workspace\\test"); // backslash 
    }
}