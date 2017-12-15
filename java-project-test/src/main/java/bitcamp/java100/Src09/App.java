package bitcamp.java100.Src09;

public class App {

    public static void main(String[] args) {
        // Score 설계도에 따라 메모리를 준비한다.
        Score[] scores = { new Score(), new Score(), new Score() };

        // Score 클래스에 따로 분류된 메서드를 호출한다.
        // - Score 클래스에 소속된 메서드를 호출할 때는
        // 반드시 클래스명을 지정해야 한다.
        // - 단, Score 클래스는 현재 App 클래스와 같은 패키지에 있기 때문에
        // 전체 패키지명을 적을 필요는 없다.
        Score.init(scores[0], "홍길동", 100, 90, 80);
        Score.init(scores[1], "임꺽정", 80, 80, 80);
        Score.init(scores[2], "유관순", 100, 100, 100);

        for (Score s : scores) {
            Score.print(s);
        }
    }
}