// ## 연산자 - 증가/감소 연산자
//

package bitcamp.java100.ch02;

public class Test15_5 {

    public static void main(String[] args) {
// 증가/감소 연산자 사용 전
        int a = 10;
        int b = 10;

// => 값을 1 증가시키기
        a = a + 1;

// => 값을 1 감소시키기
        b = b - 1;
        
        System.out.printf("a=%d, b=%d\n", a, b);

// 좀 더 간단히 1씩 증가시키고, 1씩 감소시키는 연산자
// 1) 전위(prefix) 증감연산자
        a = 10;
        b = 10;

        ++a; // a = a + 1
        --b; // b = b - 1
        System.out.printf("a=%d, b=%d\n", a, b);

// 2) 후위(postfix) 증감연산자
        a = 10;
        b = 10;

        a++; // a = a + 1
        b--; // b = b - 1
        System.out.printf("a=%d, b=%d\n", a, b);

// ### prefix vs postfix
// => prefix는 변수의 값을 1 증가시킨 후 그 자리에 변수의 값을 놓는다.
        a = 10;
        b = 10;

        int r1 = ++a;
        int r2 = --b;
        System.out.printf("a=%d, b=%d, r1=%d, r2=%d\n", a, b, r1, r2);

// => postfix는 변수의 값을 그 자리에 먼저 놓은 후 변수를 증가시킨다.
        a = 10;
        b = 10;

        // 할당 연산자(=)는 항상 r-value 쪽이 다 실행된 후에 수행된다.
        r1 = a++;
        r2 = b--;
        System.out.printf("a=%d, b=%d, r1=%d, r2=%d\n", a, b, r1, r2);

// => postfix의 또 다른 예
        a = 10;
        a = ++a;
        System.out.println(a);

        b = 10;
        b = b++;
        System.out.println(b);

// 다른 연산자와 섞었을 때
        a = 5;
        r1 = ++a + ++a * ++a;
        System.out.printf("a=%d, r1=%d\n", a, r1);

        a = 5;
        r1 = a++ + a++ * a++;
        System.out.printf("a=%d, r1=%d\n", a, r1);

    }
}