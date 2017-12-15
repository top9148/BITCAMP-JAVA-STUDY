import java.util.Scanner;

//: ## ver 11
//: - 키보드로 성적 정보를 입력 받아 저장하라!
//: - 계속 저장할 지 여부를 물어봐라!
//: - 저장을 완료하면 모든 성적을 출력하라!
//: - 학습 목표
//:   - 생성자의 목적
//:   - 인스턴스 메서드와 스태틱 메서드의 구분
//:   - 메서드를 적절하게 분류하는 방법 
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
        Score[] scores = new Score[100];
        int cursor = 0;
        
        while (true) {
            Score score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
            
            // 인스턴스( 주소)를 배열에 저장한다.
            scores[cursor++] = score;

            if (!confirm("계속하시겠습니까? "))
                break;
        }
        
        for (int i = 0; i < cursor; i++) {
            scores[i].print();
        }
    }
}




