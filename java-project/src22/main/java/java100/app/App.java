//: ## ver 22
//: - 회원관리 기능을 추가하라!
//: - 자세한 요구사항은 App.java의 주석을 확인하라!
//: - 학습목표
//:   - 클래스를 만들고 메서드를 정의하는 것을 연습한다.
//: 
//: 
//: 요구사항 
/*
회원관리> add
이름? 홍길동
이메일? hong@test.com
암호? 1111
입력하였습니다.

회원관리> add
이름? 홍길동2
이메일? hong@test.com
암호? 1111
이미 등록된 이메일입니다.

회원관리> list
홍길동, hong@test.com

회원관리> view
이메일? hong@test.com
이름: 홍길동
이메일: hong@test.com
암호: 1111

회원관리> view
이메일? hong2@test.com
'hong2@test.com'의 회원 정보가 없습니다.

회원관리> delete
이메일? hong@test.com
정말 삭제하시겠습니까?(y/N) y <== 'Y', 'y'를 입력해야 삭제된다.
삭제하였습니다.

회원관리> delete
이메일? hong@test.com
정말 삭제하시겠습니까?(y/N) n
삭제취소하였습니다.

회원관리> delete
이메일? hong2@test.com
'hong2@test.com'의 회원 정보가 없습니다.

회원관리> update
이메일? hong2@test.com
이름?(홍길동) 홍길동2    <== 엔터를 치면 원래 점수 유지
암호?(1111) 2222
변경하시겠습니까?(y/N) y<== 'Y', 'y'를 입력해야 변경된다.
변경하였습니다.

회원관리> update
이메일? hong2@test.com
이름?(홍길동) 홍길동2    <== 엔터를 치면 원래 점수 유지
암호?(1111) 2222
변경하시겠습니까?(y/N) n<== 'Y', 'y'를 입력해야 변경된다.
변경취소하였습니다.

회원관리> update
이메일? hong2@test.com
'hong2@test.com'의 회원 정보가 없습니다.

회원관리> remove
수행할 수 없는 명령입니다.

회원관리> main

명령>
 */
package java100.app;

import java.util.Scanner;
 
// 
// 1) 회원 정보를 담을 메모리를 설계한다.
//    회원 정보를 담을 새로운 데이터 타입을 정의한다.
//    => Member 클래스 정의
//
// 2) 회원관리 메뉴를 처리할 컨트롤러 클래스를 만든다.
//    => MemberController 클래스 정의
//    => execute() 메서드를 만든다.
//    => 일단 list 명령만 처리한다.
// 
// 3) Member 클래스 list 명령을 처리할 때 호출될 print() 추가한다.
// 4) App 클래스에 회원관리 메뉴에 대한 코드를 추가한다.
// 5) 회원관리의 add 기능 추가한다.
// 6) 회원관리의 view 기능 추가한다.
// 7) 회원관리의 update 기능 추가한다.
// 8) 회원관리의 delete 기능 추가한다.
// 
// 복사/붙여넣기를 한 후 변경을 완료하면, 
// 나머지 세세한 요구사항을 처리한다.
// 
// 9) 추가할 때 이메일 중복여부를 검사한다.
// 
public class App {
    
    static Scanner keyScan = new Scanner(System.in);
    static ScoreController scoreController = new ScoreController();
    static MemberController memberController = new MemberController();
    
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
        case "1": scoreController.execute(); break;
        case "2": memberController.execute(); break;
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




