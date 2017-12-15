// 클래스 멤버와 인스턴스 멤버의 활용 
package bitcamp.java100.ch06.ex4;

// 5단계: static 변수의 한계
public class Test5 {
    
    public static void main(String[] args) {
        // 다음 두 개의 식을 동시에 계산해보자!
        // 2 + 5 * 3 - 7 / 2 = ?
        // 3 * 6 - 5 + 11 / 2 = ?
        // => 단 연산자 우선순위는 적용하지 않고 그냥 순서대로 계산하라!
        
        // 안타깝게도 Calculator1의 result 변수는 static이기 때문에
        // 클래스 당 한 개만 존재한다.
        // 그래서 위의 식을 동시에 계산할 수 없다.
        // 한 식의 계산을 완료한 후 다른 식의 계산을 수행해야 한다.
        // 이것이 static 변수의 한계다!
        // 클래스가 로딩될 때 오직 한 번만 변수를 생성하기 때문이다.
        // 
        
        // 첫 번째 식 계산: 2 + 5 * 3 - 7 / 2 = ?
        Calculator1.plus(2);
        Calculator1.plus(5);
        Calculator1.multiple(3);
        Calculator1.minus(7);
        Calculator1.divide(2);
        System.out.println(Calculator1.result);
        
        // 두 번째 식 계산: 3 * 6 - 5 + 11 / 2 = ?
        Calculator1.result = 0;
        Calculator1.plus(3);
        Calculator1.multiple(6);
        Calculator1.minus(5);
        Calculator1.plus(11);
        Calculator1.divide(2);
        System.out.println(Calculator1.result);

    }

}
