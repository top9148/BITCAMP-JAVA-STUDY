import java.util.Scanner;

//: ## ver 12 
//: - Score 객체의 주소를 저장하고 꺼내는 코드를 별도의 클래스로 분리하라!
//: - 학습 목표
//:   - 기능 별로 클래스를 분류하는 과정을 이해하고 연습한다.
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
        
        while (true) {
            Score score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
            
            ScoreDao.add(score);

            if (!confirm("계속하시겠습니까? "))
                break;
        }
        
        for (int i = 0; i < ScoreDao.size(); i++) {
            ScoreDao.get(i).print();
        }
    }
}




