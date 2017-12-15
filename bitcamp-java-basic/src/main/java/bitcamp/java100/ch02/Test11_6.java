// # 자바에서 값 표현(literal)하기 - 정수의 크기
//
package bitcamp.java100.ch02;

public class Test11_6 {

    public static void main(String[] args) {
// 정수 값은 기본으로 4바이트 크기를 갖는다.
// -2**31 ~ +2**31 = -2147483648 ~ +2147483647
        System.out.println(-21_4748_3648);
        System.out.println(21_4748_3647);

// 다음과 같이 숫자가 1이라도 증가하면 4바이트 크기로 표현할 없기 때문에,
// 컴파일 오류가 발생한다.
        //System.out.println(-21_4748_3649);
        //System.out.println(21_4748_3648);

// 해결책?
// 자바는 8바이트 크기의 정수 값도 표현할 수 있다.
// 숫자 뒤에 l 또는 L을 붙여라!
        System.out.println(-21_4748_3649L); // 대문자 L을 주로 쓴다.
        System.out.println(21_4748_3648l); // 이유? 소문자 l은 1과 헷갈림.

        System.out.println(10); // 4바이트 정수 값
        System.out.println(10L); // 8바이트 정수 값

// 8바이트 크기의 가장 작은 정수값과 가장 큰 정수 값
        System.out.println(-922_3372_0368_5477_5808L);
        System.out.println(922_3372_0368_5477_5807L);
    }
}

// ## 비트 개수로 표현할 수 있는 최대 값?
// 11 = 100 - 1
// 2**1 + 2**0 = 2**2 - 1
// 공식: 2**(비트수) - 1 = 그 비트로 표현할 수 있는 최대 값
//       음수까지 고려한다면 2로 나누면 된다.