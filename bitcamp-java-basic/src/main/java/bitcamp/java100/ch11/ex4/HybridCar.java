package bitcamp.java100.ch11.ex4;

public class HybridCar extends Car {
    int charge; // 충전퍼센트
    int speed; 
    
    // 상속 받은 run()을 오버라이딩 하지 않고,
    // 다음과 같이 지 마음대로 새로 메서드를 만든다 하더라도
    // 막을 방법이 없다.
    public void running() {
        if (speed < 100)
            System.out.println("전기모터로 움직인다.");
        else 
            System.out.println("엔진으로 움직인다.");
    }
}
