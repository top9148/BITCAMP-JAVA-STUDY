// 상속 : generalization 수행 후
package bitcamp.java100.ch11.ex3;

public class Test3 {

    public static void main(String[] args) {
        Truck car = new Truck();
        car.model = "타이탄2";
        car.cc = 6000;
        
        car.load(3.8f);
        // 신규 프로젝트에서는 Truck을 사용할 때 
        // move() 대신 run()을 사용한다.
        // 다음과 같이 예전의 move()를 사용하면,
        // deprecated 경고가 발생한다.
        //car.move();

        // 물론 기능은 정상적으로 동작하겠지만,
        // 가능한 새 규칙에 맞춰 run()을 사용하라는 의미다.
        car.run();
        
        car.stop();
        car.dump();

    }

}
