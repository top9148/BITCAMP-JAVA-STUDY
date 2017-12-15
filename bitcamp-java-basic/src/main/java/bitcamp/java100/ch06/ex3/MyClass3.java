package bitcamp.java100.ch06.ex3;

public class MyClass3 {
    // static member
    
    // 스태틱 변수 = 클래스 변수
    static int v1 = 100;
    
    // 스태틱 메서드 = 클래스 메서드
    static void m1() { 
        System.out.println(v1);
        // 같은 스태틱 멤버라서 클래스 이름을 붙이지 않는다.
    }
    
    // 스태틱 블록
    // => 스태틱 변수가 생성된 후 자동으로 실행되는 블록
    // => 그래서 보통 스태틱 변수를 초기화시키는 코드를 이 블록에 둔다.
    static {
        System.out.println("MyClass3의 static 블록 실행!");
        v1 = 300;
        // 같은 클래스 멤버이기 때문에 굳이 앞에 클래스명을 적지 않는다.
    }
    
    // 한 클래스에 스태틱 블록을 여러 개 만들 수 있지만,
    // 만든다면 가능한 한 개만 만들라!
    // 많이 만들면 코드를 이해하는데 방해된다.
    static {
        System.out.println("MyClass3의 static 블록 실행22222!");
    }
    
}









