//: ## ver 28
//: - 추상 클래스 문법을 이용하여 GenericController의 인스턴스를 만들지 
//:   못하게 막아라!
//: - 학습목표
//:   - 추상 클래스의 활용법을 익힌다.

//: 
package java100.app;

import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.GenericController;
import java100.app.control.MemberController;
import java100.app.control.ScoreController;
import java100.app.domain.Room;
 
// 강의실(지역, 강의실번호, 수용인원) 관리 기능 추가
// 
// 추상 클래스 사용 후
// 1) GenericController 클래스를 추상 클래스로 선언하여
//    직접 인스턴스를 생성하지 못하도록 막는다.
// 
public class App {
    
    static Scanner keyScan = new Scanner(System.in);
    
    static HashMap<String,GenericController<?>> controllerMap = 
            new HashMap<>();
    
    public static void main(String[] args) {
        
        // go 명령어를 수행할 컨트롤러를 등록한다.
        controllerMap.put("1", new ScoreController());
        controllerMap.put("2", new MemberController());
        controllerMap.put("3", new BoardController());
        
        // GenericController는 추상 클래스이기 때문에 
        // 인스턴스를 생성할 수 없다.
        // 즉 어떤 클래스가 추상 클래스라면,
        // 인스턴스를 만들지 말라는 얘기다.
        // 상속 받아 서브 클래스를 만들어 사용하라는 의미다!
        // => 컴파일 오류!
        //controllerMap.put("4", new GenericController<Room>());
        
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
        
        GenericController<?> controller = controllerMap.get(menuNo);
        
        if (controller == null) {
            System.out.println("해당 번호의 메뉴가 없습니다.");
            return;
        }
        
        controller.execute();
        
        // 이제 새로운 컨트롤러가 추가되더라도 
        // 이 메서드를 변경할 필요가 없다.
        // 그냥 main() 시작 부분에 새로 추가한 컨트롤러를
        // Map에 등록하기만 하면 된다.
        // 새로운 기능이 추가되더라도 코드 변경을 최소화시키는 기법이다.
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




