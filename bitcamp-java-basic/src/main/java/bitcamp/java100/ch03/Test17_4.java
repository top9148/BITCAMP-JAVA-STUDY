// ## 메서드 - 메서드 정의 문법 III
// - 메서드 정의 기본 문법을 알아 보자!
//

package bitcamp.java100.ch03;

public class Test17_4 {

    // 3) 0개 이상의 아규먼트를 받을 수 있는 파라미터 선언하기
    // - 아규먼트의 개수를 확정할 수 없는 경우에 유용하다.
    // - 단 아규먼트의 타입은 같아야 한다.
    // - 해당 파라미터는 메서드 안에서 배열로 취급한다.
    // - 문법: 
    //   메서드명(타입... 변수명) {...}
    //
    static void m1(int... values) {
        System.out.printf("아규먼트 개수: %d\n", values.length);
        for (int v : values) {
            System.out.println(v);
        }
        System.out.println("-------------------------");
    }
    
    // 가변 길이 파라미터는 오직 한 개만 사용할 수 있다.
    //static void m2(int... values, int... values2) {} // 컴파일 오류!
    //static void m2(int... values, String... values2) {} // 컴파일 오류!
    
    // 가변 길이 파라미터와 일반 파라미터를 섞어 쓸 때는 
    // 반드시 일반 파라미터가 먼저 와야 한다.
    static void m3(String name, int age, int... values) {}
    //static void m4(int...values, String name, int age) {} //컴파일 오류!
    //static void m5(String name, int...values, int age) {} //컴파일 오류!
    //static void m6(String name, int...values, String tel) {} //컴파일 오류!
   
    // 가변 길이 파라미터의 응용
    static void sum(int... values) {
        int s = 0;
        for (int v : values) {
            s += v;
        }
        System.out.printf("합계: %d\n", s);
    }
    
    public static void main(String[] args) {
        // 메서드 호출하여 값 전달하기
        m1();
        m1(10);
        m1(10, 20);
        m1(10, 20, 30);
        
        sum();
        sum(1, 2, 3, 4, 5);
        sum(100, 80, 70, 90);
        
        
        // 컴파일 오류!
        // 1) 다른 타입의 값을 넣을 수 없다.
        //m1(10, "hello");
        
        
    }
}














