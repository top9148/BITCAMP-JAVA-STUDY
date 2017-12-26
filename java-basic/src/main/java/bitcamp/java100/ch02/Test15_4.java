// ## 연산자 - 암시적 형변환으로 해결이 안되는 경우 계산 방법은?
// - 명시적으로 형변환 하는 방법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_4 {

    public static void main(String[] args) {
// 암시적 형변환으로 해결할 수 없는 경우
        float f1 = 3.141592f;
        int i1 = 7654321;
        System.out.printf("f1=%f, i1=%d\n", f1, i1);

        double r1 = f1 + i1; // 7654324.141592
        // float 과 int는 서로 타입이 다르기 때문에 연산 불가!
        // 암시적 형변환 규칙에 따라 int를 float으로 바꾼다.
        // 그리고 float과 float의 연산을 수행한다.
        // 당연히 그 결과는 float이다.
        // 3.141592 + 7654321 = 7654324.141592 이지만,
        // 결과가 float이기 때문에 앞의 7자리까지는 유효하고
        // 뒤의 수는 반올림되어 짤린다.
        // 그리고 그 짤린 값이 double에 저장된다.
        // 결론, 짤린 후에 저장되기 때문에 값이 제대로 나오지 않는다.
        System.out.println(r1);

// 명시적 형변환으로 위의 문제를 해결하자!
// 문법:
// 1) (바꾸고자하는타입) 변수명
// 2) (바꾸로자하는타입) 값
        r1 = (double) f1 + (double) i1; // 7654324.141592
        System.out.println(r1);

// 명시적 형변환과 암시적 형변환을 섞어 쓰기
        r1 = (double) f1 + i1;
        System.out.println(r1);

        r1 = f1 + (double) i1;
        System.out.println(r1);
    }
}

// ### 형변환
// - "type conversion"이라 부른다.
// - "type casting" 이라고도 부른다.