// 상속 : generalization 수행 전
package bitcamp.java100.ch11.ex2;

public class Test1 {

    public static void main(String[] args) {
        // 시스템에 승용차 역할을 수행할 객체가 필요해
        // Sedan 클래스를 만들어 사용하였다.
        Sedan car = new Sedan();
        car.model = "소나타";
        car.cc = 1980;
        
        car.openSunroof();
        car.run();
        car.closeSunroof();
        car.run();
        car.stop();

    }

}
