// 클래스 멤버와 인스턴스 멤버의 활용 
package bitcamp.java100.ch06.ex4;

// 7단계: 인스턴스 메서드의 활용
//        => 인스턴스 메서드를 사용하면 인스턴스 멤버를 보다 쉽게 다룰 수 있다.
//        => 왜? 인스턴스 메서드에서 인스턴스 주소를 보관하는 내장 변수 this가 있다.
//               또한 메서드를 호출할 때도 메서드 앞에 인스턴스 주소를 주기 때문에
//               어떤 인스턴스에 대해 작업을 수행하는지 보다 직관적으로 알 수 있다.
public class Test7 {
    
    public static void main(String[] args) {
        // 다음 두 개의 식을 동시에 계산해보자!
        // 2 + 5 * 3 - 7 / 2 = ?
        // 3 * 6 - 5 + 11 / 2 = ?
        // => 단 연산자 우선순위는 적용하지 않고 그냥 순서대로 계산하라!

        // 각 식의 계산 결과를 개별적으로 관리하기 위해 
        // result 변수가 들어 있는 인스턴스를 준비한다.
        Calculator3 c1 = new Calculator3();
        Calculator3 c2 = new Calculator3();
        
        // 인스턴스 메서드를 호출할 때는 메서드 앞에 인스턴스 주소를 줘야 한다.
        // => 파라미터로 인스턴스를 가리키는 것 보다 훨씬 더 직관적이다.
        // 
        c1.plus(2);
        c2.plus(3);
        c1.plus(5);
        c2.multiple(6);
        c1.multiple(3);
        c2.minus(5);
        c1.minus(7);
        c2.plus(11);
        c1.divide(2);
        c2.divide(2);

        System.out.println(c1.result);
        System.out.println(c2.result);
        

    }

}
