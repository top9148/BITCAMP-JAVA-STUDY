// # 자바에서 값 표현(literal)하기 - 문자열 표현
//
package bitcamp.java100.ch02;

public class Test11_12 {

    public static void main(String[] args) {
// 문자열은 항상 큰 따옴표("")로 표현한다.
// 단 한개의 문자라 할지라도 큰 따옴표로 표현한다.
        System.out.println("ABC");
        System.out.println("가각간");

// => 자바는 문자열과 문자를 구분한다.
        System.out.println("가"); // 문자열
        System.out.println('가'); // 문자

// => 문자열 안에 이스케이프 문자를 포함할 수 있다.
        System.out.println("ABC\n가각간");
        System.out.println("ABC\uAC00\uac00똘똠똥");

// => 빈 문자열도 문자열이다.
        System.out.println("");
    }
}