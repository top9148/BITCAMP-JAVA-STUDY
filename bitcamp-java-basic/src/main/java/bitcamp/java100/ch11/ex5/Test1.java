// 추상 메서드 사용 후
package bitcamp.java100.ch11.ex5;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        // 이제 Car의 모든 서브 클래스는 run()을 구현하였다.
        
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
        // ex4 패키지와 달리 HybridCar 객체도 정상적으로 달릴 수 있다.

    }

}










