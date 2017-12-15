package java100.app;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreController {
    
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
    
    
    // 대신 목록 객체에 값을 저장하고 꺼내는 메서드는 완전 공개한다.
    public void doDelete() {
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

    public void doUpdate() {
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

    public void doView() {
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

    public void doList() {
        System.out.println("[학생 목록]");
        
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    public void doAdd() {
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
