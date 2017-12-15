// 상속 : generalization 수행 후
package bitcamp.java100.ch11.ex3;

public class Test1 {

    public static void main(String[] args) {
        // 프로그램을 만들어 놓고 보니 
        // 코드를 좀 더 쉽게 유지보수하기 위해 정리할 필요가 있었다.
        // 특히 Sedan 클래스와 Truck 클래스에서 
        // 중복되는 변수와 메서드를 발견하였다.
        // 그래서 이 두 클래스의 중복 변수 및 메서드를 추출하여
        // 수퍼 클래스 Car를 정의하였다.
        // 물론 프로그램에 변경이 발생하는 것은 아니다.
        // 그냥 유지보수를 좋게 하기 위해 상속이라는 문법을 이용한 것 뿐이다.
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
