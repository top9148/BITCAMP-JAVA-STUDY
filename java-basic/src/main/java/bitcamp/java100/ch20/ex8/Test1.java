// Spring IoC(Inversion of Control) 컨테이너 - 의존 객체 주입
// 
package bitcamp.java100.ch20.ex8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex8/application-context1.xml");
        
        // XML 설정으로 의존 객체를 주입하기
        Car car = (Car) appCtx.getBean("c1");
        System.out.println(car);
    }
}








