package java100.app.control;

// 이 규칙은 App 클래스가 컨트롤러 객체를 사용하기 위해 
// 호출하는 메서드를 선언한 것이다.
//
public interface Controller {
    // App 클래스는 컨트롤러에 대해 이 메서드를 호출한다.j
    // 규칙이기 때문에 여기서 메서드를 구현해서는 안된다.
    // 규칙을 따르는 클래스가 구현해야 한다.
    // 그렇다. 다음 메서드는 추상 메서드이다.
    // 어, abstract가 선언되어 있지 않은데?
    // 생략된 것이다. 컴파일할 때 자동으로 붙는다.
    // 자세한 문법 사항은 java-basic 프로젝트에 설명할 것이다.
    /*public abstract*/ void execute();

}
