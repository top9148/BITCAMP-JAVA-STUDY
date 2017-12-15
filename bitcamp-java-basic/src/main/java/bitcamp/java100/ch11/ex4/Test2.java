// 추상 메서드 사용 전
package bitcamp.java100.ch11.ex4;

import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        // 하이브리드 기능을 수행하는 객체가 필요해 
        // Car를 상속 받은 HybridCar를 만들었다.
        // 그리고 이 객체를 생성하여 운전을 해봤다.
        // 하이브리드 자동차?
        // => 저속일 때는 전기모터로 자동차를 움직인다.
        // => 고속일 때는 엔진으로 움직인다.
        // 
        HybridCar car = new HybridCar();
        car.model = "비트하이드로";
        car.cc = 3000;
        
        car.run(); // 이렇게 운전을 해봤는데...
        car.stop();
        
        // 어? 멈추는 것은 잘하는데 달리는 것을 못한다. 
        // 왜? 
        // => HybridCar는 run() 메서드를 오버라이딩 하지 않았기 때문이다.
        // => 대신 running() 메서드를 만들었다.
        // 
        // 그래... 그럼 running()을 호출하면 되지뭐!
        car.speed = 80;
        car.running();
        car.stop();
        
        car.speed = 120;
        car.running();
        car.stop();
        
        // 문제는 프로그래밍의 일관성이 없다는 것이다.
        // Sedan이나 Truck을 움직일 때는 run()을 호출하고
        // HybridCar를 움직일 때는 running()을 호출해야 한다.
        // 나중에 다른 개발자가 또 다른 자동차를 만든다고 가정하자.
        // 그 개발자가 HybridCar 처럼 지 맘대로 
        // 자동차를 움직이는 새 이름의 메서드를 추가한다면,
        // 우린 또 그 클래스의 메서드 이름을 암기해야 한다.
        // 아~~ 이 얼마나 괴로운 일인가?
        // 자동차 마다 움직이는 방법이 다르다면 
        // 코딩할 때 매우 번거롭고 짜증날 것이다.
        
        // HybridCar를 사용하는 개발자는
        // 자동차를 움직이기 위해 run()을 호출할 것이다.
        // 설마 run() 대신 다른 메서드를 만들었을 것이라
        // 생각하지도 않았다.
        // 물론 API 매뉴얼을 보면 이 자동차를 움직이려면 
        // running()을 호출하라고 기술되어 있을 거지만,
        // 개발자들은 보통 Car 클래스의 메서드를 보고 호출할 것 아닌가?
        // 특히 자동차를 테스트하는 시험 센터의 예를 들어 보자!
        
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
        
        
               
        

    }

}










