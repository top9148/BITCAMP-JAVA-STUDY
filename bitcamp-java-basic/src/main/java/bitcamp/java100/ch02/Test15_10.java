// ## 연산자 - 비트 연산자 (&, |, ~, ^)
// - 비트 연산자의 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_10 {

    public static void main(String[] args) {
        int v1 = 0b0101_1100;
        int v2 = 0b0110_0110;
        
// &(논리곱 AND)
// => 각 비트끼리 AND 연산을 수행한다. 둘 다 1일 때만 결과는 1이 된다.
        int result = v1 & v2;
        System.out.println(java.lang.Integer.toBinaryString(result));

// |(논리합 OR)
// => 각 비트끼리 OR 연산을 수행한다. 둘 중 한 개가 1일 때 결과는 1이 된다.
        result = v1 | v2;
        System.out.println(java.lang.Integer.toBinaryString(result));

// ^(배타적 논리곱 Eclusive OR(XOR))
// => 각 비트끼리 XOR 연산을 수행한다. 두개 비트의 값이 다를 때 결과는 1이 된다.
        result = v1 ^ v2;
        System.out.println(java.lang.Integer.toBinaryString(result));

// ~(부정 NOT)
// => 비트값을 반대 값으로 바꾼다. 0이면 1, 1이면 0으로 바꾼다.
        result = ~v1;
        System.out.println(java.lang.Integer.toBinaryString(result));
        
    }
}




















