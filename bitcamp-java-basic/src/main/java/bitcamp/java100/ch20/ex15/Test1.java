// Spring IoC(Inversion of Control) 컨테이너 - @Component에 이름 명시하기
// 
package bitcamp.java100.ch20.ex15;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex15/application-context1.xml");
        
        // @Component 애노테이션에 이름 지정하기
        Car car = (Car) appCtx.getBean("tico");
        System.out.println(car);
        
        System.out.println("------------------------------------------");
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", name, appCtx.getBean(name));
        }
        
        
    }
}








