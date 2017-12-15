package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreController {
    
    static Scanner keyScan = new Scanner(System.in);
    
    // ArrayList 객체와 메서드들을 스태틱으로 둘 것인지,
    // 아니면 인스턴스로 변경할 것인지 결정해야 한다.
    // => 만약 프로그램에서 성적 목록을 동시에 다룰 일이 없다면
    //    그냥 스태틱 멤버로 둔다.
    // => 프로그램에서 성적 목록을 여러 개 생성할 일이 있다면
    //    인스턴스 멤버로 선언해야 한다.
    //    즉 개별적으로 다룰 데이터라면 인스턴스 멤버로 만들라!
    // => 실무!
    //    실무에서는 나중에 여러 개 사용할 것을 대비해 
    //    보통 인스턴스 멤버로 선언한다.
    //    물론, Prompts 클래스의 메서드처럼 인스턴스 변수를 
    //    사용할 일이 확실히 없는 경우에는 스태틱으로 선언한다.
    // 
    
    // 성적 데이터를 보관하는 목록 객체는 외부 노출을 막는다.
    private ArrayList<Score> list = new ArrayList<>();
    
    public void execute() {
        loop:
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            
            // 명령어를 처리하는 각 코드를 별도의 메서드로 추출한다.
            switch (input) {
            case "add": this.doAdd(); break;
            case "list": this.doList(); break;
            case "view": this.doView(); break;
            case "update": this.doUpdate(); break;
            case "delete": this.doDelete(); break;
            case "main": break loop;
            default: 
                System.out.println("해당 명령이 없습니다.");
            }
        }
    }
    
    // 이전에는 App 클래스에서 doXxx() 메서드를 호출하기 때문에
    // 공개하였다.
    // 지금은 App 클래스에서 직접 doXxx()를 호출하는 게 아니라,
    // 같은 멤버인 execute()에서 호출하기 때문에 공개할 필요가 없다.
    // => 객체지향 프로그래밍에서는 가능한 공개 범위를 줄이는 것이
    //    유지보수에 좋다.
    //    즉 공개할 필요가 있을 때만 공개하라!
    // 
    private void doDelete() {
        System.out.println("[학생 삭제]");
        String name = Prompts.input("이름? ");
        
        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                list.remove(score);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }
    }

    private void doUpdate() {
        System.out.println("[학생 정보 변경]");
        String name = Prompts.input("이름? ");
        
        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            score.update();
        }
    }

    private void doView() {
        System.out.println("[학생 정보]");
        String name = Prompts.input("이름? ");
        
        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }
        
        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            score.printDetail();
        }
    }

    private void doList() {
        System.out.println("[학생 목록]");
        
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    private void doAdd() {
        System.out.println("[학생 등록]");
        
        Score score;
        while (true) {
            score = new Score(); // 성적 데이터를 저장할 빈 객체를 준비한다.
            score.input(); // 사용자로부터 입력받은 데이터를 빈 객체에 저장한다.
            
            list.add(score);
            
            if (!Prompts.confirm("계속하시겠습니까?(Y/n) "))
                break;
        }
        
    }
}
