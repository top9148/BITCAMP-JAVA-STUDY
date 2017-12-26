// 다형성 - 오버로딩(overloading)
// => 파라미터의 개수나 타입, 순서가 다르더라도
//    같은 기능을 수행하는 메서드에 대해 
//    같은 이름을 부여함으로써 
//    개발자가 같은 기능에 대해 같은 이름의 메서드를 사용할 수 있도록 
//    일관성을 제공하는 문법이다.  
package bitcamp.java100.ch08.ex8;

public class Test2 {
    
    static void m1(byte a, byte b) {
        System.out.println("m1(byte, byte)");
    }
    
    static void m1(short a, short b) {
        System.out.println("m1(short, short)");
    }
    
    static void m1(int a, int b) {
        System.out.println("m1(int, int)");
    }
    
    public static void main(String[] args) {
        // 자바의 정수 리터럴의 기본 타입은 int이다.
        m1(10, 20); //m1(int, int)
        
        // 정수의 다른 타입의 파라미터를 가지는 메서드를 호출하고 싶다면,
        // 명시적으로 형변환하라!
        m1((short)10, (short)20);
        m1((byte)10, (byte)20);
    }
}







