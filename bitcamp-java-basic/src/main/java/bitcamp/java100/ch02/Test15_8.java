// ## 연산자 - 논리 연산자(&&, ||, &, |)
// - 관계 연산자의 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_8 {

    public static void main(String[] args) {
// AND 연산자 : 둘 다 true일 때만 결과가 true이다.
        System.out.printf("true && true = %b\n", true && true);
        System.out.printf("true && false = %b\n", true && false);
        System.out.printf("false && true = %b\n", false && true);
        System.out.printf("false && false = %b\n", false && false);

// OR 연산자 : 둘 중 한 개라도 true일 때 결과가 true이다.
        System.out.printf("true || true = %b\n", true || true);
        System.out.printf("true || false = %b\n", true || false);
        System.out.printf("false || true = %b\n", false || true);
        System.out.printf("false || false = %b\n", false || false);

// AND 연산자 : 둘 다 true일 때만 결과가 true이다.
        System.out.printf("true & true = %b\n", true & true);
        System.out.printf("true & false = %b\n", true & false);
        System.out.printf("false & true = %b\n", false & true);
        System.out.printf("false & false = %b\n", false & false);

// OR 연산자 : 둘 중 한 개라도 true일 때 결과가 true이다.
        System.out.printf("true | true = %b\n", true | true);
        System.out.printf("true | false = %b\n", true | false);
        System.out.printf("false | true = %b\n", false | true);
        System.out.printf("false | false = %b\n", false | false);        

// && vs &
        boolean b1 = false;
        boolean result = false && (b1 = true);
        System.out.printf("b1=%b, result=%b\n", b1, result);

        b1 = false;
        result = false & (b1 = true);
        System.out.printf("b1=%b, result=%b\n", b1, result);


    }
}
