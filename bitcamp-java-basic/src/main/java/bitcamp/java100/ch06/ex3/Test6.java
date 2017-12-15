// 스태틱 멤버 - 클래스 안에 선언된 static 클래스
package bitcamp.java100.ch06.ex3;

public class Test6 {
    
    // 인스턴스 멤버
    class A {
        
    }
    
    // 스태틱 멤버
    static class B {
        
    }
    
    public static void main(String[] args) {
        // 레퍼런스를 선언할 때는 스태틱 멤버 안에서 인스턴스 멤버의 클래스를 언급할 수 있다.
        A obj1;
        B obj2;
        
        // 그러나 실제 인스턴스를 만들기 위해 new 연산자를 사용할 때는
        // 스태틱 블록에서 인스턴스 멤버 클래스를 사용할 수 없다.
        //obj1 = new A(); // 컴파일 오류!
        obj2 = new B(); // OK!
        
        
    }
}








