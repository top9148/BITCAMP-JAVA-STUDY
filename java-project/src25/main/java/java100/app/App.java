//: ## ver 25
//: - 코드 리팩토리2
//: - 학습목표
//:   - 관련 메서드를 적절하게 클래스로 분류하는 방법을 익힌다.

package java100.app;

import java.util.Scanner;
 
// 리팩토링
// 1) Score에 있는 사용자와 상호작용하는 코드를 분리하여 
//    ScoreController로 옮긴다.
//    => Score 클래스는 사용자 정의 데이터 타입의 역할로 제한한다.
//    => Score 클래스에 getter/setter를 정의한다.
//    => add 명령은 한 개의 성적만 입력하도록 변경한다.
// 2) 사용자로부터 문자열이나 숫자를 입력 받아 리턴하는 메서드를 만든다.
//    => Prompts 클래스에 inputString(), inputInt()를 추가한다.
//    => 기존이 input() 메서드는 @Deprecated로 선언하여 
//       사용하지 말라고 경고한다.
// 3) Member에 있는 UI 관련 코드를 모두 MemberController로 옮긴다
// 4) Board에 있는 UI 관련 코드를 모두 BoardController로 옮긴다.
//
//
public class App {
    
    static Scanner keyScan = new Scanner(System.in);
    static ScoreController scoreController = new ScoreController();
    static MemberController memberController = new MemberController();
    static BoardController boardController = new BoardController();
    
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
                e.printStackTrace();
            }
            System.out.println();
        } // while
        
    }
    
    private static void doGo(String menuNo) {
        
        switch (menuNo) {
        case "1": scoreController.execute(); break;
        case "2": memberController.execute(); break;
        case "3": boardController.execute(); break;
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




