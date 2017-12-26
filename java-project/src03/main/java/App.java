// ## ver 03
// 변수를 이용하여 이름, 국어, 영어, 수학, 총점, 합계를 저장하라!그런 후 다음과 같이 출력하라!

// 출력 내용:
// ```
// 이름: 홍길동
// 국어: 100
// 영어: 100
// 수학: 100
// 총점: 300
// 평균: 100.0
// ```
 
public class App {

    public static void main(String[] args) {
        // 변수를 선언하여 값을 보관한다.
        String name = "홍길동";
        int kor = 100;
        int eng = 97;
        int math = 98;
        int sum = kor + eng + math;
        float aver = sum / 3.0f;

        System.out.printf("이름: %s\n", name);
        System.out.printf("국어: %d\n", kor);
        System.out.printf("영어: %d\n", eng);
        System.out.printf("수학: %d\n", math);
        System.out.printf("총점: %d\n", sum);
        System.out.printf("평균: %.1f\n", aver);
    }
}
