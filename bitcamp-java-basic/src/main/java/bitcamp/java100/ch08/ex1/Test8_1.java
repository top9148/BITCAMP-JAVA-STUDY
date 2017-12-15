// 캡슐화 활용 - 접근 제한하기 전
// 
package bitcamp.java100.ch08.ex1;

class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
}

public class Test8_1 {
    public static void main(String[] args) {
        Score s = new Score();
        s.name = "홍길동";
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        
        // 다음의 경우처럼 sum 값을 직접 넣게 되면,
        // 실제 국,영,수의 합계가 아닌 무효한 값이 들어갈 수 있다.
        // 이런 문제를 해결하려면, 
        // sum에 직접 값을 넣지 못하게 막아야 한다.
        // 그래서 필요한 문법이 접근제어를 하는 문법이다!
        s.sum = 280;
        s.aver = s.sum / 3f;
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.name, s.kor, s.eng, s.math, s.sum, s.aver);
    }
}











