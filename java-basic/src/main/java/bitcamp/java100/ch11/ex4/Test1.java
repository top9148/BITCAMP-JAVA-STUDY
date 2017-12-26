// 추상 클래스
package bitcamp.java100.ch11.ex4;

public class Test1 {

    public static void main(String[] args) {
        // Car 클래스를 만든 개발자가 
        // 오로지 서브 클래스에게 공통 필드와 메서드를 물려줄 목적으로
        // 만들었고 직접 사용하지 못하도록 하기 위해 
        // 추상 클래스로 선언하였기 때문에 
        // 다음과 같이 직접 인스턴스를 생성할 수 없다.
        //Car car = new Car(); // 컴파일 오류!
        
        // Car 클래스를 사용하는 올바른 방법은
        // 오직 서브 클래스를 만들어 사용하는 것이다.
        Sedan car1 = new Sedan();
        car1.run();
        car1.stop();
        
        Truck car2 = new Truck();
        car2.run();
        car2.stop();
        
    }

}
