//: ## ver 34
//: - 여러 사람이 동시에 업무를 볼 수 있도록 C/S(Client/Server) 구조로 
//:   프로그램을 변경하라!
//: - 학습목표
//:   - 네트워킹 프로그래밍을 연습한다.
//: 
package java100.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;
 
// 기존의 스태틱 멤버를 인스턴스 멤버로 변경한다.
// => 당장은 스태틱 멤버를 사용해도 상관없지만,
//    향후 여러 개의 인스턴스를 생성할 경우를 고려하여 
//    실무에서는 보통 인스턴스 멤버를 사용한다.
public class App02 {
    
    Scanner keyScan = new Scanner(System.in);
    
    // 이제 HashMap에 보관하는 값은 Controller 규칙을 준수한 객체이다.
    HashMap<String,Controller> controllerMap = 
            new HashMap<>();
    
    void init() {
        controllerMap.put("1", new ScoreController("./data/score.csv"));
        controllerMap.put("2", new MemberController("./data/member.csv"));
        controllerMap.put("3", new BoardController("./data/board.csv"));
        controllerMap.put("4", new RoomController("./data/room.csv")); 
        
    }
    
    void service() {
        
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
    
    
    
    private void doGo(String menuNo) {
        
        // controllerMap에 저장된 컨트롤러 객체는 
        // Controller 규칙을 따르는 객체이기 때문에
        // 레퍼런스를 선언할 때도 Controller 레퍼런스를 사용하라!
        Controller controller = controllerMap.get(menuNo);
        
        if (controller == null) {
            System.out.println("해당 번호의 메뉴가 없습니다.");
            return;
        }
        
        // App 클래스는 컨틀롤러 객체를 사용할 때
        // Controller 규칙에 정의된 메서드를 호출할 뿐이다!
        // 이 규칙을 따르는 객체라면 누구를 상속 받는지 상관없이
        // 호출할 수 있다.
        // 이것이 인터페이스 문법을 사용하는 이유이다.
        // 그 자격을 갖춘 객체라면 상속과 상관없이 호출할 수 있다.
        // 사용하는 객체의 범위를 더 확대시키는 문법이다.
        // 훨씬 코드 확장을 유연하게 도와준다.
        // 이전의 방식이라면 GenericController의 서브 클래스만 
        // 가능하기 때문에 너무 협소적이었다.
        controller.execute();
    }

    private void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu        - 메뉴 목록 출력한다.");
        System.out.println("go 번호     - 메뉴로 이동한다.");
        System.out.println("quit        - 프로그램을 종료한다.");
    }

    private void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
        System.out.println("4 강의실");
    }

    private void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private void doQuit() {
        Collection<Controller> controls = controllerMap.values();
        for (Controller control : controls) {
            control.destroy(); // 각 컨트롤러에게 마무리 기회를 준다.
        }
        System.out.println("프로그램을 종료합니다.");
    }
    
    public static void main(String[] args) throws Exception {
        App02 app = new App02();
        app.init();
        app.service();
    }

}




