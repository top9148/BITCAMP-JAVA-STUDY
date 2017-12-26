//: ## ver 29
//: - 추상 메서드를 이용하여 GenericController의 모든 하위 클래스가 
//:   반드시 execute()를 오버라이딩하도록 강제하라!
//: - 학습목표
//:   - 추상 메서드의 의미와 활용법을 익힌다.

//: 
package java100.app;

import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.GenericController;
import java100.app.control.MemberController;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;
 
// 강의실(지역, 강의실번호, 수용인원) 관리 기능 추가
// 
// 추상 메서드 적용 전
// 1) RoomController 클래스를 새로 추가한다.
//    단 GenericController의 execute() 메서드를 오버라이딩 하지 
//    않아서 정상적으로 동작되지 않을 것이다.
//    => execute()를 오버라이딩 하도록 강요하지 않은 상태이다.
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
        
        // RoomController를 등록한다.
        // => 하지만 제대로 동작하지 않을 것이다.
        // => App 클래스는 컨트롤러 객체에 대해 execute()를 호출할 것이지만,
        //    RoomController 클래스는 execute()를 오버라이딩 하지 않았다.
        //    대신 자기 마음대로 execution() 메서드를 만들었다.
        //    말 그대로 App하고 협업하는 것을 고려하지 않고,
        //    지 마음대로 만들었다.
        //    현재 이것을 막지 못했다. 
        controllerMap.put("4", new RoomController());
        
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




