package bitcamp.java100.ch11.ex3;

// Sedan에 있던 변수와 메서드 중에서 
// Truck과 중보되는 일부를 Car 클래스에 옮기는 대신에
// 이 클래스에서는 Car에 옮겨놓은 코드를 사용하겠다는 의미에서
// 상속 문법을 적용한다.
public class Sedan extends Car {
    
    boolean isOpen;
    
    // 오버라이딩 하는 메서드는 가능한 애노테이션을 붙여 
    // 컴파일러가 검사하도록 요청하라!
    @Override
    public void run() {
        if (isOpen) {
            System.out.println("시원하게 달린다.");
        } else {
            System.out.println("포근하게 달린다.");
        }
    }
    
    public void openSunroof() {
        isOpen = true;
        System.out.println("썬루프 연다.");
    }
    
    public void closeSunroof() {
        isOpen = false;
        System.out.println("썬루프 닫는다.");
    }
}











