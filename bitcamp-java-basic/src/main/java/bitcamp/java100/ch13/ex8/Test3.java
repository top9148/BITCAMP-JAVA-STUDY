// 예외처리 문법정리 : RuntimeException을 이용한 예외 체인 관리
package bitcamp.java100.ch13.ex8;

public class Test3 {

    // m2() 메서드와 같다. 
    static void m1() {
        m2();
    }
    
    // m3() 메서드와 같다. 
    static void m2() {
        m3();
    }
    
    // m4()가 던지는 예외는 RuntimeExeption 예외다. 
    // 메서드 선언부에 적을 필요 없다.
    static void m3() {
        m4(); 
    }
    
    // Error나 RuntimeException 계열의 예외를 던지면,
    // 메서드 선언부에 따로 예외 타입을 나열할 필요가 없다.
    // 물론 나열해도 되지만, 굳이 나열할 필요가 없다는데
    // 코드를 적는 것은 낭비다.
    // 주의!
    // => 메서드 선언부에 예외 타입을 나열하지 않아도
    //    RuntimeException 예외가 발생하면 호출자에게 그 예외를 던진다.
    // => "스텔스 예외"
    static void m4() {
        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        // m4()에서 발생된 스텔스 예외가 여기까지 전달된다면,
        // RuntimeException 예외이기 때문에 
        // main()에서도 물론 try~ catch~를 안써도 된다.
        // 하지만,
        // main()이 예외를 처리할 수 있는 마지막 보루다. 
        // 여기에서 처리하지 않으면 JVM에 전달되고,
        // JVM은 무조건 프로그램을 종료하기 때문에 
        // 최소한 main()에서는 예외의 종류에 상관없이 처리하라!
        //
        try {
            m1();
        } catch (Exception e) {
            // 예외가 발생했을 때 제대로 종료할 수 있도록 
            // 최소한 main() 메서드에서는 예외를 처리하라!
        }
        
        // RuntimeException 예외는 개발자에게 예외를 처리하라
        // 강요하지 않기 때문에 부담이 없다.
        // Exception 계열의 예외가 발생되는 경우에는
        // 개발자가 그 예외를 처리해야 하기 때문에 부담이 된다.
        // 하지만, 부담이 되더라도 예외 처리를 명확하게 하는 것은 
        // 코드의 유지보수를 더 좋게 만들기 때문에
        // 가능한 Exception을 다루라고 대부분 권장한다.
        // 즉 메서드에서 예외가 발생하면 
        // RuntimeException 계열의 예외를 던지기 보다는
        // 가능한 Exception 계열의 예외를 던지라는 것이다.
        //
        // 그러나 다른 개발자를 위한 라이브러리를 만들 때는
        // 그 라이브러리를 사용하는 개발자의 부담을 덜어주기 위해
        // 주로 예외 상황에 대해 RuntimeException을 던지는 것이 보통이다.
        
    }

}










