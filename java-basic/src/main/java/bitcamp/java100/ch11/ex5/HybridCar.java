package bitcamp.java100.ch11.ex5;

public class HybridCar extends Car {
    int charge; // 충전퍼센트
    int speed; 
    
    // Car를 상속 받는 모든 서브 클래스는 
    // 반드시 상속 받은 추상 메서드를 구현해야 한다.
    // 구현하지 않으면 이 클래스도 추상 클래스로 선언해야 한다.
    // 그래서 ex4 패키지에서처럼 run() 대신 다른 메서드를 
    // 만들어서는 안된다.
    @Override
    public void run() {
        if (speed < 100)
            System.out.println("전기모터로 움직인다.");
        else 
            System.out.println("엔진으로 움직인다.");
    }
}
