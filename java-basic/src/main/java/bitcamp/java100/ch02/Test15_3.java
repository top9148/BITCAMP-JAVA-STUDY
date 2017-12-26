// ## 연산자 - 다른 타입의 변수와 연산하기
// - 타입이 서로 다른 값을 연산하는 방법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_3 {

    public static void main(String[] args) {
        byte b1 = 20, b2 = 22 ;
        short s1 = 30, s2 = 33;
        int i1 = 40, i2 = 44;
        long l1 = 50, l2 = 55;
        float f1 = 3.14f, f2 = 45.32f;
        double d1 = 4567.8988, d2 = 9876.5432;

// byte vs short vs int
// => 특별한 작업없이 두 타입의 값은 자동으로 int 임시 메모리에 저장된 후 계산이 수행된다. 그 결과는 당연히 int이다.
        int r1 = b1 + s1;
        r1 = b1 + i1; // byte는 int 임시 메모리에 저장됨
        r1 = i1 + s1; // short는 int로 자동 변환됨. 오해말라! s1 변수의 타입이 정말 바뀌는 것이 아니라, 임시 int 메모리에 저장되는 것을 짧게 표현한 말이다.

// byte, short, int vs long
// => byte, short, int의 값이 long 임시 메모리에 저장되어 서로 타입을 맞춘다. 그런 후 계산을 수행한다.
        //r1 = i1 + l1; // 계산 결과는 long 타입이다. 컴파일 오류!
        //r1 = b1 + l1; // 계산 결과는 long 타입이다. 컴파일 오류!
        //r1 = s1 + l1; // 계산 결과는 long 타입이다. 컴파일 오류!

        long r2 = i1 + l1; // OK
        r2 = b1 + l1; // OK
        r2 = s2 + l1; // OK

// byte, short, int, long vs float
// => 정수 타입이 부동소수점의 임시 메모리에 저장된 후 계산을 수행한다.
        //long r3 = b1 + f1; // 계산 결과는 float이다. 컴파일 오류!
        //r3 = s1 + f1; // 계산 결과는 float이다. 컴파일 오류!
        //r3 = i1 + f1; // 계산 결과는 float이다. 컴파일 오류!
        //r3 = l1 + f1; // 계산 결과는 float이다. 컴파일 오류!

        float r4 = b1 + f1; // OK
        r4 = s1 + f1;
        r4 = i1 + f1;
        r4 = l1 + f1;
        // 주의!
        // - float 값 다른 값을 추가하면 float의 크기를 넘을 수 있다.
        // - 이 경우 실행 오류가 발생하지 않고 넘어간 값은 짤린다.
        // - 계산 결과가 제대로 float 메모리에 저장되는 지 주의해서 사용하라!
        // - 특히 8바이트 크기를 갖는 long값을 4바이트 크기를 갖는 float 메모리에 저장할 때 주의하라! 짤린 값이 저장될 가능성이 높다.
        // 즉 정수 값이 부동소수점 메모리에 들어갈 때, 메모리 보다 큰 값은 실행 오류 없이 조용히 짤린채로 저장된다는 것을 조심하라!사용

// byte, short, int, long, float vs double
        //float r5 = f1 + d1; // f1의 값이 자동으로 임시 double 메모리에 저장됨. 그런 후 계산. 당연히 계산 결과는 double이다.

        double r6 = f1 + d1; // OK
        r6 = b1 + d1;
        r6 = s1 + d1;
        r6 = i1 + d1;
        r6 = l1 + d1;

    }
}

// ### 암시적 형변환
// - 이렇게 서로 다른 타입의 값을 계산하려할 경우 자동으로 타입을 맞춰주는 것을 "암시적 형변환(implicit type conversion/casting)"이라 부른다.
//
// ### 암시적 형변환 규칙
// - byte,short => int => long => float => double
// - 왼쪽 타입과 오른쪽 타입을 연산할 때는 왼쪽 타입의 값이 오른쪽 타입으로 바뀐다.