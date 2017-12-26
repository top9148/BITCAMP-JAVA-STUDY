// 스태틱 변수의 활용 - 상수를 사용하기 전
package bitcamp.java100.ch06.ex6;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Car2[] cars = new Car2[6];
        
        // 자동차가 개인용인지, 영업용인지, 법인 소속인지 지정하기 위해 숫자를 사용한다. 
        // 또한 자동차가 트럭인지, 승용인, 승합인지 지정하기 위해 숫자를 사용한다.
        // 문제는 이 숫자가 무엇을 의미하는지 알아채기 힘들다는 것이다.
        // 
        cars[0] = new Car2("티코", 900, 3, 2);
        cars[1] = new Car2("티코", 900, 2, 1);
        cars[2] = new Car2("티코", 900, 1, 3);
        
        cars[3] = new Car2("소나타", 1980, 1, 1);
        cars[4] = new Car2("소나타", 1980, 2, 2);
        cars[5] = new Car2("소나타", 1980, 3, 3);
        
        System.out.printf("총 생산량 = %d 대\n", Car2.count);
        
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%d, %s, %d\n", cars[i].no, cars[i].model, cars[i].cc);
        }

    }

}
