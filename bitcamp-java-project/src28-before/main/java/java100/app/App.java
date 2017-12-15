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
// 추상 클래스 사용 전
// 1) Room 클래스 정의
// 2) App에 Room 정보를 다루기 위해 
//    GenericController의 인스턴스를 생성하였다.
//    => GenericController는 아무것도 하지 않는다.
//    => 아무런 일도 하지 않는 객체를 만들어 등록하면 뭘 할 것인가?
//    => 특히 상속의 generalization을 통해 만든 수퍼 클래스는 
//       직접 사용하기 위해 만든 것이 아니라
//       서브 클래스들의 공통 변수나 공통 메서드를 추출할
//       목적으로 만든 클래스이기 때문에
//       직접 사용해서는 안된다.
//    => 이런 상황에 대비해 자바에서 제공하는 문법이 있으니,
//       그 이름도 유명한 "추상 클래스"이다.
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
        
        // Room 정보를 다룰 컨트롤러를 따로 만들지 않고 
        // 지금처럼 그냥 GenericController 클래스를 사용하였다.
        // => 현재의 문법으로는 문제 없다.
        // => 문제가 없는 것이 문제다!
        controllerMap.put("4", new GenericController<Room>());
        
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




