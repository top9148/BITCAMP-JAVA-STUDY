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
// 추상 메서드 적용 후
// 1) GenericController의 execute() 메서드를 추상 메서드로 선어하였다.
//    따라서 이 클래스를 상속 받는 서브 클래스들은 
//    반드시 이 메서드를 오버라이딩 해야 한다.
//    만약 오버라이딩을 하지 않는다면,
//    그 클래스 또한 추상 클래스가 되어야 한다.
//    왜? 오직 추상 클래스만이 추상 메서드를 가질 수 있다.
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
        // => GenericController에는 execute()라는 추상 메서드가 있고,
        // => RoomController가 GenericController의 서브 클래스라면,
        //    반드시 execute()를 오버라이딩 했을 것이다.
        // => 왜? 오버라이딩하지 않으면 컴파일 오류이다!
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
        
        // 다시 한번,
        // GenericController 클래스에는 execute() 추상 메서드가 있다.
        // 이 클래스의 서브 클래스들은 반드시 execute()를 
        // 재정의해야 한다.
        // 따라서 우리는 안심하고 execute()를 호출할 수 있다.
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




