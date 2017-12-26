//: ## ver 30
//: - 추상 클래스의 한계
//: - 학습목표
//:   - 추상 클래스의 한계를 이해하자!

//: 
package java100.app;

import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.GenericController;
import java100.app.control.MemberController;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;
 
// 강의실 관리 기능을 수행하는 RoomController를 다시 작성해보자!
// 강의실 목록을 관리해야 하기 때문에
// 내부 필드로 ArrayList 객체를 사용한다.
// 그런데 필드가 아니라 ArrayList를 상속 받아서 RoomController를 
// 구현해보자!
// 그리고 추상 클래스를 이용한 상속의 한계점을 알아보자!
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
        
        // RoomController는 GenericController를 상속 받지 않고
        // 객체 관리를 편하게 하기 위해 ArrayList를 상속 받았다.
        // 문제는 controllerMap에 저장할 수 없다는 것이다.
        // controllerMap은 오직 GenericController 계열의 객체만
        // 저장할 수 있도록 선언하였기 때문이다.
        // 그렇다고 RoomController가 ArrayList와 GenericControler를
        // 동시에 다중 상속 할 수는 없다.
        // 왜? 자바는 다중상속을 지원하지 않기 때문이다.
        //
        // 이것이 상속으로 컨트롤러를 만드는 방법의 한계이다.
        // 
        // 상속의 문제는 반드시 그 서브 클래스만 등록할 수 있다는 것이다.
        // 너무 제한적이다.
        // 이런 제한을 해결하는 방법으로 나온 것이 "인터페이스" 문법이다.
        // 다음 버전을 확인하라!
        // 
        controllerMap.put("4", new RoomController()); // 컴파일 오류!
        
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




