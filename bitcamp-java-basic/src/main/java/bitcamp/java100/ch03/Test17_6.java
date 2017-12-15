// ## 메서드 - 메서드 정의 문법 V
// - 메서드 정의 기본 문법을 알아 보자!
//

package bitcamp.java100.ch03;

public class Test17_6 {

    // 5) 여러 개의 값을 반환하는 방법 
    // - 자바는 여러 개의 값을 반환하는 문법이 없다.
    //   예를 들면, 다음과 같이 작성할 수 없다.
    //   int, int, String m1() {
    //      return 10, 20, "hello";
    //   }
    // - 해결책?
    //   배열이나 객체에 담아서 반환한다.
    //

    // 배열을 이용하여 값을 여러 개 반환하기
    static int[] m1() {
        // 배열을 초기화시키는 문법은 배열 레퍼런스 변수 선언문과 함께 사용해야 한다.
        int[] values = {100, 90, 80};
        
        // 만약 레퍼런스 변수를 먼저 선언한 다음에 초기화시키려면 
        // 반드시 명시적으로 new 명령을 작성해야 한다.
        int[] values2;
        //values2 = {100, 90, 80}; // 컴파일 오류!
        values2 = new int[] {100, 90, 80}; // OK!
        
        // 따라서 값이 들어 있는 배열을 바로 만들어 리턴할 경우
        // 다음과 같이 해서는 안된다.
        //return {100, 90, 80}; // 컴파일 오류!
        
        return new int[] {100, 90, 80};
        
        // 주의!
        // 사실 배열이 리턴되는 것이 아니라 배열의 주소가 리턴된다.
        // primitive type(byte, short, int, long, float, double, boolean, char)을 제외한
        // 나머지 모든 타입은 무조건 값이 아닌 주소를 주고 받는 것이다.
    }
    
    public static void main(String[] args) {
        // 여러 개의 값이 들어 있는 배열의 주소 받기
        int[] arr = m1();
        for (int i : arr) {
            System.out.println(i);
        }
    }
}














