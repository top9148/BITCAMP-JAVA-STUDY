// 다형성 - 오버로딩(overloading)
// => 파라미터의 개수나 타입, 순서가 다르더라도
//    같은 기능을 수행하는 메서드에 대해 
//    같은 이름을 부여함으로써 
//    개발자가 같은 기능에 대해 같은 이름의 메서드를 사용할 수 있도록 
//    일관성을 제공하는 문법이다.  
package bitcamp.java100.ch08.ex8;

public class Test1 {
    
    static int divide(int a, int b) {
        return a / b;
    }
    
    static float divide(float a, float b) {
        return a / b;
    }
    
    public static void main(String[] args) {
        
        // 같은 이름을 갖는 메서드가 여러 개 있을 경우,
        // 메서드를 호출할 때 어떻게 구분하는가?
        // => 파라미터의 타입과 개수, 순서로 구분한다.
        // 
        System.out.println(divide(7, 2));
        System.out.println(divide(7f, 2f));
        
        // 파라미터 타입이 메서드와 다를 때는 
        // 암시적 타입 캐스팅으로 가능한 메서드를 호출한다.
        System.out.println(divide(7, 2f));
        System.out.println(divide(7f, 2));
        
        // 암시적 타입 캐스팅으로 불가능한 경우 컴파일 오류!
        //System.out.println(divide("7", "2")); // 컴파일 오류!
    }
}







