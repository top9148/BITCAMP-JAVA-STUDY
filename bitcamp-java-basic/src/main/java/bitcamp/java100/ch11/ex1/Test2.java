// 상속: specialization 문법을 사용하는 예
package bitcamp.java100.ch11.ex1;

public class Test2 {

    public static void main(String[] args) {
        // 시스템을 운영하다보니, 
        // 트럭 역할을 수행할 객체가 필요하였다.
        // 그래서 상속을 이용하여 Car 클래스에 기능을 덧붙인
        // Truck 클래스를 만들었다.
        // 즉 자동차는 자동찬데 좀 더 특별한 기능을 갖는 자동차이다.
        Truck c = new Truck();
        c.model = "티코";
        c.cc = 900;
        c.weight = 3.8f;
        
        c.run();
        c.stop();
        c.dump();

        // 처음에 Car 클래스를 정의해놓고 사용하다가,
        // 좀 더 특별한 기능이 필요해 Car를 상속 받은 Truck을 만들었다.
        // Car 클래는 Truck을 위한 수퍼 클래스로 만든게 아니라,
        // 원래부터 사용하던 클래스이다. 
        // 그러다가 Truck과 같은 서브 클래스를 만들어 사용한 것이다.
        // 이런 경우 Car 클래스도 일반 클래스처럼
        // 인스턴스를 만들어 사용하게 된다.
        
        
    }

}












