// ## 새로운 데이터 타입에 대해 사용할 연산자 만들기
// - 새 종류의 메모리를 만들었으면 그 메모리의 값을 다루는 연산자가 필요하다. 즉 새 클래스의 연산자를 만드는 방법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test14_5 {

    public static void main(String[] args) {

        // 사용자 정의 데이터 타입
        class Score {
                String name;
                int kor;
                int eng;
                int math;
                int sum;
                float aver;

                // Score 메모리에 대해 사용할 새 연산자(operator)
                // operator = method = message = function
                void compute() {
                    sum = kor + eng + math;
                    aver = sum / 3.0f;
                }
        }

        Score s1 = new Score();
        s1.name = "홍길동";
        s1.kor = 100;
        s1.eng = 100;
        s1.math = 100;
        s1.compute(); // 연산자 실행 = 메서드 호출 = 메시지 전송

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);

        Score s2 = s1;
        s1 = new Score();
        s1.name = "임꺽정";
        s1.kor = 90;
        s1.eng = 90;
        s1.math = 97;
        s1.compute();

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);

        System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.aver);
    }
}
