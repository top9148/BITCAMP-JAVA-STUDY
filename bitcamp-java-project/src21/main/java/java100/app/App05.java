//: ## ver 21
//: - 메뉴 기능을 추가하라!
//: - 요구사항 명세는 App.java 주석을 보라!
//: - 학습목표
//:   - 클래스 문법을 사용하여 관련 기능을 묶어서 분류하는 기법을 익한다.
//:   - 콘솔에서 사용자 입력을 다루는 방법을 연습한다.
//: 
//: 
//: 요구사항 
/*
명령> menu
1 성적관리
2 회원관리
3 게시판

명령> help
[명령]
menu        - 메뉴 목록 출력한다.
go 번호     - 메뉴로 이동한다.
quit        - 프로그램을 종료한다.

명령> quit
프로그램을 종료합니다.

명령> ok
잘못된 명령입니다.

명령> go 1

성적관리> list
...

 */
package java100.app;

import java.util.Scanner;
 
// => 성적 관리 명령을 처리하는 메서드를 관리하기 쉽게 
//    별도의 클래스로 분리한다. (ScoreController 클래스)
// => 사용자로부터 확인이나 입력을 받는 메서드를 
//    별도의 클래스로 분리한다. (Prompts 클래스)
//

// 5단계 
// => go 1 명령을 처리한다.
public class App05 {
    
    static Scanner keyScan = new Scanner(System.in);
    static ScoreController scoreController = new ScoreController();
    
    public static void main(String[] args) {
        
        loop:
        while (true) {
            System.out.print("명령> ");
            String[] input = keyScan.nextLine().toLowerCase().split(" ");
            
            try {
                switch (input[0]) {
                case "menu": doMenu(); break;
                case "help": doHelp(); break;
                case "quit": doQuit(); break loop;
                case "go": doGo(input[1]); break;
                default:
                    doError();
                }
            } catch (Exception e) {
                System.out.println("명령 처리 중 오류 발생!");
            }
            System.out.println();
        } // while
        
    }
    
    private static void doGo(String menuNo) {
        
        switch (menuNo) {
        case "1":
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
                case "main": break loop;
                default: doError();
                }
            }
            break;
        case "2":
            System.out.println("회원관리");
            break;
        case "3":
            System.out.println("게시판");
            break;
        default:
            System.out.println("해당 번호의 메뉴가 없습니다.");
        }
        
    }

    private static void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu        - 메뉴 목록 출력한다.");
        System.out.println("go 번호     - 메뉴로 이동한다.");
        System.out.println("quit        - 프로그램을 종료한다.");
    }

    private static void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
    }

    private static void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }




        
}




