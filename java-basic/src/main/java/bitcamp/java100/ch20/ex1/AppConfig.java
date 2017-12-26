package bitcamp.java100.ch20.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스가 스프링 IoC 컨테이너의 설정 정보를 다루는 클래스임을 표시 
public class AppConfig {
    
    @Bean("str1") // 스프링 IoC 컨테이너가 호출해야 할 메서드 표시!
                  // 이 메서드의 리턴 값은 컨테이너에 보관된다.
    String getString1() {
        return new String();
    }
    
    @Bean("str2")
    String getString2() {
        return new String("Hello!");
    }
}
