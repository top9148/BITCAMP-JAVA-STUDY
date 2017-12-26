// 상속 : generalization 수행 전
package bitcamp.java100.ch11.ex2;

public class Test2 {

    public static void main(String[] args) {
        // 시스템에 트럭 역할을 수행할 객체가 필요해
        // Truck 클래스를 만들어 사용하였다.
        Truck car = new Truck();
        car.model = "타이탄";
        car.cc = 5000;
        
        car.load(3.8f);
        car.move();
        car.stop();
        car.dump();

    }

}
