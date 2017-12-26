//: ## ver 20
//: - 성적관리 입출력을 처리하는 메서드를 별도의 블록으로 분류하라!
//: - 공통으로 사용하는 메서드도 별도의 클래스로 분리하라!
//: - 학습목표
//:   - 클래스 문법을 사용하여 관련 기능을 묶어서 분류하는 기법을 익힌다.
//: 
//: 
package java100.app;

import java.util.Scanner;
 
// => 성적 관리 명령을 처리하는 메서드를 관리하기 쉽게 
//    별도의 클래스로 분리한다. (ScoreController 클래스)
// => 사용자로부터 확인이나 입력을 받는 메서드를 
//    별도의 클래스로 분리한다. (Prompts 클래스)
//
public class App {
    
    static Scanner keyScan = new Scanner(System.in);
    
    public static void main(String[] args) {
        ScoreController scoreController = new ScoreController();
        
        loop:
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            
            // 명령어를 처리하는 각 코드를 별도의 메서드로 추출한다.
            switch (input) {
            case "add": scoreController.doAdd(); break;
            case "list": scoreController.doList(); break;
            case "view": scoreController.doView(); break;
            case "update": scoreController.doUpdate(); break;
            case "delete": scoreController.doDelete(); break;
            case "quit": doQuit(); break loop;
            default: doError();
            }
            
            System.out.println();
        }
        
    }
    
    private static void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }




        
}




