// 클래스 멤버와 인스턴스 멤버의 활용 2
package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

// 5단계: 인스턴스 변수와 메서드를 활용하여 여러 개의 성적 데이터를 관리하기
//        => 여러 개의 인스턴스를 보관하기 위해 레퍼런스 배열을 사용한다.
public class Test5 {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("y") || response.equals("yes"))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        
        // 성적 데이터는 Score2 인스턴스에 저장할 것이고,
        // 그 인스턴스는 배열을 보관될 것이다.
        Score2[] scores = new Score2[100];
        int cursor = 0;
        
        while (true) {
            Score2 score = new Score2(); // 성적 데이터를 저장할 메모리를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 인스턴스에 저장한다.
            
            // 인스턴스( 주소)를 배열에 저장한다.
            scores[cursor++] = score;
            
            if (!confirm("계속하시겠습니까? "))
                break;
        }
        
        
        // 레퍼런스 배열에 저장된 각각의 인스턴스 주소로 찾아가서
        // 성적 데이터를 출력한다.
        for (int i = 0; i < cursor; i++) {
            scores[i].print();
        }
    }
}






