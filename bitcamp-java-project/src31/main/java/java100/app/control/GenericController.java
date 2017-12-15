package java100.app.control;

import java.util.ArrayList;
import java.util.Scanner;


// ScoreController와 MemberController, BoardController가 
// 이 클래스를 상속 받는다.
// 따라서 이 클래스가 Controller 규칙을 따른다면,
// 나머지 서브 클래스들은 자동으로 Controller 규칙을 따르게 되는 것이다.
// 그래서 GenericController가 Controller 규칙을 따르도록 정의하자!
// 
public abstract class GenericController<T> implements Controller {
    
    // 컨트롤러 클래스들이 공통으로 사용하는 객체를 선언한다.
    static Scanner keyScan = new Scanner(System.in);
    
    protected ArrayList<T> list = new ArrayList<>();

    // Controller 인터페이스로부터 execute()라는 추상 메서드를 
    // 물려 받았기 때문에 여기서 또 선언해서는 안된다.
    //public abstract void execute();
    
}









