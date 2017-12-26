// 클래스 멤버와 인스턴스 멤버의 활용 
package bitcamp.java100.ch06.ex4;

// 3단계: static 변수 사용 
public class Test3 {
    
    // static 메서드에서 공유하는 값은 static 변수에 저장한다.
    // static 메서드에서는 같은 static 멤버(변수,메서드)를 사용할 수 있다.
    // 
    static int result;
    // 인스턴스 변수나 static 변수(클래스 변수)는 따로 초기화시키지 않으면,
    // 기본적으로 0으로 초기화 된다.
    // 정수는 0, 논리는 false, 부동소수점은 0.0, char는 '\u0000'

    // 계산 결과는 static 변수 result에 저장하기 때문에 리턴할 필요가 없다.
    //
    static void plus(int value) {result += value;}
    static void minus(int value) {result -= value;}
    static void multiple(int value) {result *= value;}
    static void divide(int value) {result /= value;}

    public static void main(String[] args) {
        // 2 + 5 * 3 - 7 / 2 = ?
        // => 단 연산자 우선순위는 적용하지 않고 그냥 순서대로 계산하라!
        
        plus(2);
        plus(5);
        multiple(3);
        minus(7);
        divide(2);
        // 메서드가 계산한 결과를 저장하기 위해 변수를 선언할 필요가 없다.
        // 각 메서드들이 static 변수를 공유하기 때문에 결과 값을 관리하기 편하다! 
        
        System.out.println(result);

    }

}
