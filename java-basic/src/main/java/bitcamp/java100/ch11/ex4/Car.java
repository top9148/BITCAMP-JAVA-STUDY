package bitcamp.java100.ch11.ex4;

// Car 클래스는 자동차가 기본으로 가져야할 필드와 메서드를 선언하고 있다.
// 목적은 서브 클래스에 이들을 물려주기 위함이다.
// 이런 목적으로 만든 클래스는 직접 인스턴스를 생성하지 못하도록 
// 막아야 한다. 
// 어떻게?
// 추상 클래스로 선언하라!
public abstract class Car {
    String model;
    int cc;
    
    public void stop() {
        System.out.println("멈춘다.");
    }
    
    public void run() {}
}








