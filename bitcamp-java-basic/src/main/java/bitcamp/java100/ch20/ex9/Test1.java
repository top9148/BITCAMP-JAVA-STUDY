// Spring IoC(Inversion of Control) 컨테이너 - @Autowired
// 
package bitcamp.java100.ch20.ex9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex9/application-context1.xml");
        
        // 애노테이션으로 의존 객체를 주입하기
        Car car = (Car) appCtx.getBean("c1");
        System.out.println(car);
    }
}








