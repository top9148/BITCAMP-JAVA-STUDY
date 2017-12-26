package java100.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test {

    @Bean
    String getName() {
        return "Hello";
    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(Test.class);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", name, iocContainer.getBean(name));
        }
    }

}
