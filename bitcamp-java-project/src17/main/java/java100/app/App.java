//: ## ver 17
//: - 자바에서 제공하는 컬렉션 API를 사용하라!
//: - 즉 java.util.ArrayList를 사용하여 성적 데이터 목록을 다뤄라.
//: - 학습목표
//:   - 자바의 컬렉션 API 사용법을 익힌다.
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

import java.util.ArrayList;
import java.util.Iterator;
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
        
        // ArrayList로부터 "데이터를 꺼내주는 일을 할 객체"를 얻는다.
        Iterator<Score> iterator = list.iterator();
        
        // "데이터를 꺼내주는 일을 할 객체"를 통해 값을 꺼낸다.
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }
}




