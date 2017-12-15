// 스태틱 멤버 - 클래스 로딩과 스태틱 블록 실행 시점
package bitcamp.java100.ch06.ex3;

public class Test7 {
    
    // 스태틱 멤버 main()에서 사용할 클래스이기 때문에
    // 클래스 A, B에 대해 static을 붙였다.
    // 
    static class A {
        static int a = 100;
        
        static {
            System.out.println("A의 스태틱 블록 실행!");
            System.out.printf("A==> a = %d\n", A.a);
            B.b = 222;
            System.out.printf("A==> a = %d\n", A.a);
            System.out.println("A의 스태틱 블록 종료!");
        }
    }
    
    static class B {
        static int b = 200;
        
        static {
            System.out.println("B의 스태틱 블록 실행!");
            System.out.printf("B==> b = %d\n", B.b);
            A.a = 111;
            System.out.printf("B==> b = %d\n", B.b);
            System.out.println("B의 스태틱 블록 종료!");
        }
    }
    
    public static void main(String[] args) {
        new A();
        
        
    }
}








