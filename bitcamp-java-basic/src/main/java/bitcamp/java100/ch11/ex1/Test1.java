// 상속: specialization
package bitcamp.java100.ch11.ex1;

public class Test1 {

    public static void main(String[] args) {
        // 자동차 역할을 수행할 객체가 필요해서 Car 클래스를 만들었고,
        // 다음과 같이 Car 클래스를 사용하였다.
        Car c = new Car();
        c.model = "티코";
        c.cc = 900;
        
        c.run();
        c.stop();

    }

}
