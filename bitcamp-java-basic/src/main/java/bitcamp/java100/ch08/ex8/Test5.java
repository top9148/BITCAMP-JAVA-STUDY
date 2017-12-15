package bitcamp.java100.ch08.ex8;

public class Test5 {

    // 파라미터 타입과 개수, 순서로 호출할 메서드를 구분하기 때문에
    // 파라미터 명은 아무런 상관이 없다.
    static int plus(int a, int b) {
        return a + b;
    }
    
    // 이미 위에 int 값을 두 개 받는 메서드가 있기 때문에
    // 파라미터명만 달리해서 만들 수 없다.
    /*
    static int plus(int v1, int v2) {
        return v1 + v2 + v2;
    }
    */
    
    // 파라미터의 순서에 따라 메서드를 구분할 수 있다.
    static void m1(int a, String b) {
        System.out.println("m1(int, String)");
    }
    
    static void m1(String a, int b) {
        System.out.println("m1(String, int)");
    }
    
    public static void main(String[] args) {
        System.out.println(plus(10, 20));
        m1(10, "aaa");
        m1("aaa", 10);

        // 우리가 실습에서 사용하는 print()이나 println() 등도
        // 오버로딩의 전형적인 예이다.
        System.out.println(10); // println(int)
        System.out.println(10f); // println(float)
        System.out.println(10L); // println(long)
    }

}











