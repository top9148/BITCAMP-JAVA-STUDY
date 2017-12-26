//: ## ver 14
//: - 모든 무소속 클래스를 패키지 멤버 클래스로 만들라! 
//: - Score 클래스에 캡슐화 문법을 적용하라!
//: - 학습목표
//:   - 클래스를 패키지 멤버로 만드는 방법을 학습한다.
//:   - 각 필드나 메서드의 접근을 제한하는 방법을 연습한다.
//:   - 셋터/겟터의 정의와 사용을 연습한다.
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```
package java100.app;

import java.util.Scanner;
 
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




