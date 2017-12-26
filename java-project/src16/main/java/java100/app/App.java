//: ## ver 16
//: - ArrayList에 generic을 적용하여 저장하는 타입을 지정할 수 있게 한다.
//: - 학습목표
//:   - 제넥릭을 이용하여 클래스를 정의하는 방법
//:   - 제네릭이 적용된 클래스를 사용하는 방법
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
        
        // 제네릭이 적용된 ArrayList를 사용하려면,
        // ArrayList에 다루고자하는 값의 타입 정보를 알려줘야 한다.
        ArrayList<Score> list = new ArrayList<>();
        
        while (true) {
            Score score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
            
            list.add(score);

            if (!confirm("계속하시겠습니까? "))
                break;
        }
        
        for (int i = 0; i < list.size(); i++) {
            // ArrayList에 어떤 값을 저장할 지 알려줬기 때문에
            // 값을 꺼낼 때 따로 형변환할 필요가 없다.
            //
            //((Score)list.get(i)).print();
            list.get(i).print();
        }
    }
}




