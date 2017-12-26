// # 자바에서 값 표현(literal)하기 - 정수의 표현
//
package bitcamp.java100.ch02;

public class Test11_4 {

    public static void main(String[] args) {
// 10진수 정수 값 표현
        System.out.println(100);

// 8진수 정수 값 표현: 0으로 시작한다.
        System.out.println(0144); // = 100(10진수)

// 16진수 정수 값 표현: 0x 또는 0X 로 시작한다.
        System.out.println(0x64); // = 100(10진수)
        System.out.println(0X64); // = 100(10진수)

// 2진수 정수 값 표현: 0b 또는 0B 로 시작한다.
        System.out.println(0b01100100); // = 100(10진수)
        System.out.println(0B01100100); // = 100(10진수)
        System.out.println(0B1100100); // 앞쪽의 0은 생략가능
    }
}