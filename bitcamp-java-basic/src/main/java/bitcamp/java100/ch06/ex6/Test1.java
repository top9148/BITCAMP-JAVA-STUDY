// 스태틱 변수와 인스턴스 변수의 활용 
package bitcamp.java100.ch06.ex6;

public class Test1 {

    public static void main(String[] args) throws Exception {
        Car[] cars = new Car[6];
        cars[0] = new Car("티코", 900);
        cars[1] = new Car("티코", 900);
        cars[2] = new Car("티코", 900);
        
        cars[3] = new Car("소나타", 1980);
        cars[4] = new Car("소나타", 1980);
        cars[5] = new Car("소나타", 1980);
        
        // 특정 인스턴스의 고유 정보가 아니라, 
        // 모든 인스턴스가 공유하는 정보는 스태틱 변수(클래스 변수)에 저장한다.
        System.out.printf("총 생산량 = %d 대\n", Car.count);
        
        // 각각의 인스턴스 정보를 출력해보자!
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%d, %s, %d\n", cars[i].no, cars[i].model, cars[i].cc);
        }

    }

}
