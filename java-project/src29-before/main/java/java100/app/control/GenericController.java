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

    // 컨트롤러 클래스들이 공통으로 갖는 메서드를 정의한다.
    // => 서브 클래스에서 자신의 역할에 맞게 상세히 정의할 것이기 때문에
    //    이 클래스에서는 그냥 메서드의 규격(prototype)만 정의한다.
    // => 메서드 규격?
    //    메서드명, 리턴타입, 파라미터 타입 및 순서
    // => 자바에서는 메서드 규격을 "메서드 시그너처(method signature)"라
    //    부른다.
    // => C/C++에서는 메서드 규격을 "함수 프로토타입(function prototype)"이라
    //    부른다.
    public void execute() {
        // 왜 이 메서드 안에 아무것도 코딩하지 않는가?
        // => 어차피 서브 클래스에서 자세히 작성할 것이기 때문이다.
        //
        // 서브 클래스에서 작성할 코드를 여기에서 작성하면 안되나요?
        // => 각 컨트롤러마다 명령어가 다를 수 있다.
        //    즉 어떤 컨트롤러는 add와 list, view만 있을 수 있고,
        //    또는 명령어가 add 대신 insert를 사용할 수 있다.
        //    그래서 수퍼 클래스에서 정의하지 않는 것이다.
    }
    
}









