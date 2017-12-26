// 클래스 멤버와 인스턴스 멤버의 활용 
package bitcamp.java100.ch06.ex4;

// 4단계: 클래스 분리
//        계산을 수행하는 코드를 별도의 클래스로 분류해두면
//        다른 프로그램을 개발할 때 재사용하기 쉬울 것이다.
//        그래서 각각의 기능별로 클래스로 묶어서 관리하는 것이다.
public class Test4 {
    
    public static void main(String[] args) {
        // 2 + 5 * 3 - 7 / 2 = ?
        // => 단 연산자 우선순위는 적용하지 않고 그냥 순서대로 계산하라!
        
        // 다른 클래스에 소속된 메서드를 호출할 때는 클래스 이름을 붙여야 한다.
        Calculator1.plus(2);
        Calculator1.plus(5);
        Calculator1.multiple(3);
        Calculator1.minus(7);
        Calculator1.divide(2);
        
        System.out.println(Calculator1.result);

    }

}
