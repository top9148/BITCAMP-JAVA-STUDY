package bitcamp.java100.ch11.ex3;

// Sedan과 Truck에서 중복되는 코드를 이 클래스로 가져온다.
public class Car {
    String model;
    int cc;
    
    public void stop() {
        System.out.println("멈춘다.");
    }
    
    // Sedan에 있던 run() 메서드를 가져온다.
    // Truck에 있던 것은 move() 이지만 기능상으로 run()과 같기 때문에
    // run()으로 바꾼다.
    public void run() {
        // 어차피 Sedan과 Truck에서 각각의 역할에 맞게끔
        // 구현할 것이기 때문에 여기서는 따로 구현하지 않는다.
    }
}








