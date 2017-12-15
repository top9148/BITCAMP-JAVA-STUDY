package bitcamp.java100.ch06.ex6;

public class Car {
    // 모든 차량이 공유하는 변수는 스태틱 변수로 선언해야 한다.
    static int count;
    
    
    // 각 차량마다 고유정보를 저장하는 변수는 인스턴스 변수로 선언해야 한다.
    long no;
    String model;
    int cc;
    
    Car(String model, int cc) {
        // 차량을 만들 때 마다 카운트를 하자!
        count++;
        
        this.model = model;
        this.cc = cc;

        // 차량의 고유 번호는 no라는 변수에 저장된다.
        // 차량의 고유번호로 현재 실행 시간을 저장한다.
        // 현재 실행 시간은 1970년 1월 1일 0시 0분 0초를 기준으로 
        // 지금까지 경과된 시간을 밀리초로 리턴한다.
        this.no = System.currentTimeMillis();
        
        // 1밀리초 동안 여러 개의 객체가 생성될 수 있다.
        // 문제는 이렇게 되면 차량 번호가 같아지는 문제가 발생한다.
        // 그래서 차량 번호가 같지 않게 만들기 위해서는 
        // 객체를 생성한 후 최소 1밀리초는 쉬어야 한다.
        // 다음은 JVM 실행을 0.05초 멈추는 코드이다.
        // 
        try {
            Thread.currentThread().sleep(50);
        } catch (Exception e) {}
    }
}
