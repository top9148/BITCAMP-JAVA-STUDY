// 상속 : generalization 수행 후
package bitcamp.java100.ch11.ex3;

public class Test4 {

    public static void main(String[] args) {
        // 자동차 기능을 이용하려면,
        // Sedan과 Truck 클래스를 사용해야 한다.
        // 그러나 다음과 같이 이 두 클래스의 수퍼 클래스인 Car를 사용하는
        // 경우가 발생할 수 있다.
        Car car = new Car();
        car.model = "그냥차!";
        car.cc = 300;
        car.run();
        car.stop();
        
        // Car는 서브 클래스들에게 공통 변수나 메서드를 물려주기 위해
        // 만든 클래스이다.
        // 위와 같이 직접 인스턴스를 만들어 사용하라고 만든 클래스가 아니다.
        // 이것을 막을 방법은?
        // ex4 패키지를 보라!

    }

}
