package bitcamp.java100.ch20.ex17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 객체를 만들어 리턴하는 함수를 정의하고,
    // 그 함수에 @Bean 애노테이션을 붙이면,
    // 스프링 IoC 컨테이너가 해당 함수를 호출하여 
    // 그 리턴 값을 컨테이너에 보관한다.
    // XML 설정에서 <bean> 태그와 같은 용도이다.
    //
    @Bean // 빈의 이름을 지정하지 않으면 메서드명을 빈의 이름으로 사용한다. 
    public Car getCar() {
        Car c = new Car();
        c.setModel("티코");
        c.setColor("검정");
        c.setCapacity(5);
        
        return c;
    }
    
    @Bean("engine") // 빈의 이름을 지정하면 그 이름을 사용하여 저장한다.
    public Engine getEngine() {
        Engine e = new Engine();
        e.setName("비트엔진");
        e.setValve(16);
        e.setCc(800);
        
        return e;
    }
}












