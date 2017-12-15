// 추상 메서드 사용 전
package bitcamp.java100.ch11.ex4;

import java.util.ArrayList;

public class Test3 {

    public static void main(String[] args) {
        // 자동차마다 자동차를 움직이기 위해 호출하는 메서드가 다를 때
        // 발생하는 상황 II
        
        // 자동차를 테스트하는 시험 센터의 예를 들어 보자!
        
        // => 자동차 시험 센터 객체 준비
        ArrayList<Car> carTestCenter = new ArrayList<>();
        
        // => 승용차를 만들어 입고 시킨다.
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 900;
        carTestCenter.add(car1);
        
        // => 트럭을 만들어 입고 시킨다.
        Truck car2 = new Truck();
        car2.model = "타이탄";
        car2.cc = 5000;
        carTestCenter.add(car2);
        
        // => HybridCar를 만들어 입고 시킨다.
        HybridCar car3 = new HybridCar();
        car3.model = "비트하이드로";
        car3.cc = 2000;
        carTestCenter.add(car3);
        
        // => 이제 자동차를 테스트 해보자!
        for (Car car : carTestCenter) {
            System.out.printf("모델명: %s\n", car.model);
            System.out.printf("cc: %d\n", car.cc);
            car.run();
            car.stop();
        }
               
        // => 테스트 결과
        // Sedan과 Truck은 정상적으로 달리고 멈춘다.
        // 그러나 HybridCar는 멈추는 것은 잘하는데
        // 달리는 것은 하지 못한다.
        // 이유?
        // => HybridCar는 보통 자동차가 움직이는 방법(run())과 다르게
        //    움직인다. 즉 running()으로 움직인다.
        // => 이런 이유로 자동차 테스트 센터에서는 
        //    하이브리드 자동차를 올바르게 테스트 할 수 없는 것이다.
        //
        // 자동차라면 일반적으로 가지는 기능을 
        // 하이브리드자동차가 구현하지 않았기 때문에
        // 사용하기가 매우 까다롭다.
        // 즉 프로그래밍이 불편하다!
        // 이를 해결하는 방법은?
        // ex5 패키지를 보라!
        
        // 추상 클래스로 Car를 직접 사용하지 못하게는 막았는데,
        // 서브 클래스들이 run()을 오버라이딩하도록 강제하지는 못했다.
        // 그래서 이런 상황이 발생한 것이다.

    }

}










