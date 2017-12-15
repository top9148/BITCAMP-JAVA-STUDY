// ## 연산자 - 정수의 기본 연산 단위는 int이다.
// - byte, short의 연산 결과가 int임을 확인하자!
//

package bitcamp.java100.ch02;

public class Test15_2 {

    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;

// 자바의 기본 연산 단위는 int이기 때문에 byte나 short의 값을 계산할 때 내부적으로 int형 임시 메모리가 만들어져서 byte나 short의 값을 복사해온 다음에 계산을 수행한다.
// 그래서 b1과 b2의 연산 결과는 int가 된다.         
        //byte b3 = b1 - b2; // 컴파일 오류!

        short s1 = 10;
        short s2 = 20;
        //short s3 = s1 + s2; // s1과 s2의 연산 결과는 int이다. 컴파일 오류!

        int r = s1 + s2; // OK
        long r2 = s1 + s2; // 물론 결과 타입 보다 더 큰 메모리는 OK!
    }
}
