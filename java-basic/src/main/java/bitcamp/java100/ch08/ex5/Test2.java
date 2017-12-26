// 다형성 - compute() 오버라이딩 후 
package bitcamp.java100.ch08.ex5;

public class Test2 {
    public static void main(String[] args) {
        ScoreEx2 s1 = new ScoreEx2(1, "홍길동", 100, 100, 100, 80, 80);
        
        System.out.printf("합계=%d\n", s1.getSum());
        System.out.printf("평균=%f\n", s1.getAver());
        // ScoreEx2가 Score로부터 상속 받은 compute()를 재정의하였기 때문에
        // 과학과 사회 점수를 포함한 계산 결과를 출력한다.
        
        
        s1.setKor(80);
        System.out.printf("합계=%d\n", s1.getSum());
        System.out.printf("평균=%f\n", s1.getAver());
        
        // setKor()은 Score 클래스의 메서드이다.
        // setKor()에서 호출하는 compute()는 Score의 compute()인가?
        // 아니면 ScoreEx2의 compute()인가?
        // 결론!
        // => compute()를 호출할 때 어떤 클래스의 인스턴스 주소를 줬는지에 따라 결정된다.
        // => setKor()을 호출할 때 넘겨준 인스턴스는 Score가 아니라 ScoreEx2이다.
        //    따라서 setKor() 메서드의 this 변수에는 ScoreEx2의 주소가 들어 있다.
        //    그리고 그 ScoreEx2를 가지고 compute()를 호출하는 것이기 때문에
        //    compute()를 찾을 때 일단 ScoreEx2부터 찾아 올라온다.
    }
}











