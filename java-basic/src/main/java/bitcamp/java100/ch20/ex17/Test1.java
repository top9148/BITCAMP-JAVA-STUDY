// Spring IoC 컨테이너 - @Bean 애노테이션 
// 
package bitcamp.java100.ch20.ex17;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext appCtx = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        //@Bean 애노테이션을 이용하여 객체 준비하기 
        
        System.out.println("------------------------------------------");
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", name, appCtx.getBean(name));
        }
    }
}








