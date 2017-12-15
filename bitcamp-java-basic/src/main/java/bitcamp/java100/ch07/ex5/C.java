package bitcamp.java100.ch07.ex5;

public class C extends A {
    
    C(String msg) {
        // 수퍼클래스 A에는 3개의 생성자가 있다.
        // 그중 어떤 생성자를 호출할지 지정하지 않으면 
        // 컴파일러는 다음과 같이 무조건 기본 생성자를 호출하는 문장을 추가한다.
        // super();
        
        // 만약 수퍼 클래스의 기본 생성자가 아닌 다른 생성자를 호출하고 싶다면 
        // 그 생성자를 명시적으로 지정해야 한다.
        //super("hello"); // 파라미터로 문자열을 주면 String을 받는 생성자를 호출한다.
        super(100); // 파라미터로 int 값을 주면 int를 받는 생성자를 호출한다.
        
        System.out.println("C(String) 생성자 호출 - " + msg);
    }
}
