// Spring IoC(Inversion of Control) 컨테이너 - @Qualifier
// 
package bitcamp.java100.ch20.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex11/application-context1.xml");
        
        // 같은 타입의 의존 객체가 여러 개 있을 경우 오류 발생!
        // 해결책?
        // @Qualifier를 사용하여 주입할 객체를 지정하라!
        Car car = (Car) appCtx.getBean("c1");
        System.out.println(car);
        
        System.out.println("------------------------------------------");
        // <context:annotation-config/> 태그가 등록시키는 클래스를 알아보자!
        // => 현재 Spring IoC 컨테이너에 등록된 모든 객체를 출력해보면 알 수 있다.
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(appCtx.getBean(name));
        }
        
        
    }
}








