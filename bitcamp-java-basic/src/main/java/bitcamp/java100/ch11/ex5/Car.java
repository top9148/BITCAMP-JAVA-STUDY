package bitcamp.java100.ch11.ex5;

public abstract class Car {
    String model;
    int cc;
    
    public void stop() {
        System.out.println("멈춘다.");
    }
    
    // Car의 모든 서브 클래스가 반드시 run()을 구현하도록 강제하자!
    // 추상 메서드로 만들면 서브 클래스는 반드시 구현해야 한다.
    // 대신 수퍼 클래스에서는 구현하면 안된다.
    public abstract void run();
}








