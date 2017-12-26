// 다형성 - compute() 오버라이딩 전 
package bitcamp.java100.ch08.ex5;

public class Test1 {
    public static void main(String[] args) {
        ScoreEx s1 = new ScoreEx(1, "홍길동", 100, 100, 100, 80, 80);
        
        System.out.printf("합계=%d\n", s1.getSum());
        System.out.printf("평균=%f\n", s1.getAver());
        
        // ScoreEx는 Score로부터 상속 받은 compute()를 오버라이딩 하지 않았기 때문에
        // 사회, 과학 점수를 제외한 국,영,수 점수만 계산한다.
        // 그래서 우리가 원하는 결과를 얻지 못한다.
        // 
        // 이런 경우가 특히 오버라이딩을 해야 하는 상황이다.
    }
}











