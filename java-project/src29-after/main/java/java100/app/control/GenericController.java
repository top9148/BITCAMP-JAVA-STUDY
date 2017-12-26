package java100.app.control;

import java.util.ArrayList;
import java.util.Scanner;


// 이렇게 추상 클래스로 선언함으로써 
// 이 클래스는 직접 인스턴스를 생성할 수 없다.
// 다만 컨트롤러를 만들기 위해 상속 받은 용도로만 쓴다.
// 
public abstract class GenericController<T> {
    
    // 컨트롤러 클래스들이 공통으로 사용하는 객체를 선언한다.
    static Scanner keyScan = new Scanner(System.in);
    
    protected ArrayList<T> list = new ArrayList<>();

    // 추상 메서드로 선언하여 서브 클래스가 반드시 오버라이딩하도록 
    // 강제할 수 있다.
    // => 추상 메서드는 구현할 수 없다.
    public abstract void execute();
    
}









