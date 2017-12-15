// 클래스 멤버와 인스턴스 멤버의 활용 2
package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

// 4단계: 여러 개의 성적 데이터를 다룰 때 문제점
//        => 성적 데이터를 저장하는 변수는 static이기 때문에 
//           오직 한 명의 성적 정보만 저장할 수 있다.
//           여러 명의 성적을 다루려면 순차적으로 처리해야 한다.
//           절대 동시에 여러 명의 데이터를 보관할 수 없다.
public class Test4 {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("y") || response.equals("yes"))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        // 성적 데이터를 저장할 변수가 스태틱이기 때문에 한 명의 데이터만 저장할 수 있다.
        // 그래서 여러명의 데이터를 처리하려면 순차적으로 해야 한다.
        while (true) {
            Score1.inputScore();
            Score1.computeScore();
            Score1.printScore();
            
            if (!confirm("계속하시겠습니까? "))
                break;
        }
    }
}






