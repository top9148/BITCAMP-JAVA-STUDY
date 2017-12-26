//: ## ver 26
//: - 코드 리팩토링3
//: - 학습목표
//:   - 역할에 따라 클래스를 여러 패키지에 분류하는 것을 연습한다.
//: 
package java100.app;

import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.MemberController;
import java100.app.control.ScoreController;
 
// 리팩토링
// 1) 사용자 정의 데이터 타입 클래스는 보통 "domain"이라는 패키지에 둔다.
//    "business domain(업무 영역)에서 사용하는 값이다"라는 의미이다.
//    또는 값을 표현하는 클래스라고 해서 "value object"의 약자인 
//    "vo" 패키지에 두는 경우도 있다.
// 2) UI를 담당하는 컨트롤러 클래스는 "control"이라는 패키지에 둔다.
// 3) 기타 여러 곳에서 사용된느 클래스는 "util"이라는 패키지에 둔다.
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




