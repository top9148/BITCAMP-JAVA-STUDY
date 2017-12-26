// Car 객체를 생성해주는 역할 수행
package bitcamp.java100.ch20.ex6;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

// "Factory Method" 설계 패턴
// - 객체 생성과정이 복잡할 경우 매번 개발자가 그 코딩을 하기에는 번거롭다.
// - 그런 경우 객체 생성과정이 복잡한 부분을 별도의 메서드에 넣어 놓고
//   호출하는 것이 편하다.
// - 이렇게 메서드를 호출하여 객체를 생성하는 방식을 "팩토리 메서드" 패턴이라 한다.
//
// Spring 규칙에 따라 팩토리 메서드 클래스 만들기
// - FactoryBean 인터페이스 구현하기
//
public class CarFactory3 implements FactoryBean<Car> {
    private Tire[] tires;
    private String model;
    
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Class<?> getObjectType() {
        // Spring IoC 컨테이너가 이 공장 객체에서 어떤 타입의 
        // 객체를 생성하는지 알고자 할 때 호출한다.
        return Car.class;
    }
    
    @Override
    public boolean isSingleton() {
        // Spring IoC 컨테이너가 이 공장에서 만드는 객체가 한 개인지
        // 아니면 매번 요청할 때 마다 새로 생성해주는지 물어본다.
        return true; // 한번 Car 객체를 만들면 그 객체를 리턴한다.
        
        // 만약 false를 리턴하면,
        // 이 공장 객체가 매번 새로 Car 객체를 만들어준다는 의미다.
    }
    
    @Override
    public Car getObject() throws Exception {
        // Spring IoC 컨테이너가 객체를 만들어 달라고 요청할 때 호출한다.
        Car car = null;
        
        switch (this.model) {
        case "티코":
            car = createTico();
            break;
        case "티코 골드": 
            car = createTicoGold();
            break;
        case "소나타": 
            car = createSonata();
            break;
        case "에쿠스": 
            car = createEquus();
            break;
        default: 
            car = createBasic();
        }
        
        car.setTires(tires);
        
        return car;
    }

    private Car createBasic() {
        Car c = new Car();
        
        Engine engine = new Engine();
        engine.setCc(1500);
        engine.setName("비트엔진");
        engine.setValve(16);
        
        c.setEngine(engine);
        
        return c;
    }

    private Car createEquus() {
        Car c = new Car();
        
        Engine engine = new Engine();
        engine.setCc(3500);
        engine.setName("비트스페셜엔진");
        engine.setValve(32);
        
        c.setEngine(engine);
        
        return c;
    }

    private Car createSonata() {
        Car c = new Car();
        
        Engine engine = new Engine();
        engine.setCc(1980);
        engine.setName("비트표준엔진");
        engine.setValve(16);
        
        c.setEngine(engine);
        
        return c;
    }

    private Car createTicoGold() {
        Car c = new Car();
        
        Engine engine = new Engine();
        engine.setCc(900);
        engine.setName("비트엔진");
        engine.setValve(16);
        
        c.setEngine(engine);
        
        Map<String,String> options = new HashMap<>();
        options.put("sunroof", "yes");
        options.put("airbag", "yes");
        options.put("blackbox", "yes");
        
        c.setOptions(options);
        
        return c;
    }

    private static Car createTico() {
        Car c = new Car();
        
        Engine engine = new Engine();
        engine.setCc(900);
        engine.setName("비트엔진");
        engine.setValve(16);
        
        c.setEngine(engine);
        
        return c;
    }
}







