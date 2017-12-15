import java.util.Scanner;

//: ## ver 13
//: - ScoreDao 클래스의 스태틱 멤버를 인스턴스 멤버로 전환하라!
//: - 학습 목표
//:   - 스태틱 변수를 인스턴스 변수로 바꿨을 때 어떤 이점이 있는지 이해한다.
//: 
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```
 
public class App {
    
    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("y") || response.equals("yes"))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        
        ScoreDao scoreDao = new ScoreDao();
        
        while (true) {
            Score score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
            
            scoreDao.add(score);

            if (!confirm("계속하시겠습니까? "))
                break;
        }
        
        for (int i = 0; i < scoreDao.size(); i++) {
            scoreDao.get(i).print();
        }
    }
}




