// 스태틱 멤버 - 스태틱 멤버는 인스턴스 멤버를 사용할 수 없다.
package bitcamp.java100.ch06.ex3;

public class Test5 {
    static int v1 = 100;
    static void m1() {
        System.out.println("m1()");
    }
    
    int v2 = 200;
    void m2() {
        System.out.println("m2()");
    }
    
    public static void main(String[] args) {
        // main() 메서드는 static으로 선언되어 있다.
        // 따라서 스태틱 멤버이다.
        // 즉 Test5의 인스턴스를 생성하지 않아도 호출되는 메서드이다.
        // Test5의 인스턴스를 생성하지 않고 main()을 호출할 수 있도록 하기 위해  
        // main()을 static으로 선언하도록 규칙을 만든 것이다.
        
        // 스태틱 멤버는 당연히 다른 스태틱 멤버를 사용할 수 있다.
        System.out.println(v1); //OK!
        m1(); // OK
        
        // 인스턴스 변수는 인스턴스 주소를 통해서만 접근할 수 있다.
        //System.out.println(v2); //컴파일 오류!
        
        // 인스턴스 메서드는 호출할 때 반드시 인스턴스 주소를 메서드 앞에 줘야 한다.
        //m2(); // 컴파일 오류!
        
        // 스태틱 멤버에서 인스턴스 멤버를 사용하려면?
        // => 인스턴스를 만들라!
        Test5 obj1 = new Test5();
        obj1.v2 = 300; // OK!
        obj1.m2(); // OK!
        
        
        
        
    }
}








