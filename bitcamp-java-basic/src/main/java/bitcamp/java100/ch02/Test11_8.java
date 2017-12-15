// # 자바에서 값 표현(literal)하기 - 부동소수점의 표현
//
package bitcamp.java100.ch02;

public class Test11_8 {

    public static void main(String[] args) {
// 고정 소수점의 값을 표현하는 방법 
        System.out.println(3.14);
        System.out.println(.14);
        System.out.println(3.);

// 부동 소수점의 값을 표현하는 방법
// => [값]e|E[10의 거듭제곱]
// => 예) 31.4e-1 = 314e-2 = 3140e-3 = 0.314e1 = 0.0314e2
        System.out.println(31.4e-1); // 31.4 / 10 = 31.4 * 10**-1 = 3.14
        System.out.println(314e-2);
        System.out.println(3140e-3);
        System.out.println(0.314e1);
        System.out.println(0.0314e2);
    }
}
