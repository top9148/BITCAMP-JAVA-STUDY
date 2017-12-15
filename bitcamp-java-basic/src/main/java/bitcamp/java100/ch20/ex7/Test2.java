// Spring IoC(Inversion of Control) 컨테이너 - singleton 범위
// 
package bitcamp.java100.ch20.ex7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex7/application-context2.xml");
        
        System.out.println("---------------------------------");
        // singleton 으로 설정된 경우 Spring IoC 컨테이너가 생성될 때 
        // 해당 객체도 함께 준비된다.
        
        Engine obj1 = (Engine) appCtx.getBean("e1");
        Engine obj2 = (Engine) appCtx.getBean("e1");
        Engine obj3 = (Engine) appCtx.getBean("e1");
        
        if (obj1 == obj2)
            System.out.println("obj1 == obj2");
        
        if (obj1 == obj3)
            System.out.println("obj1 == obj3");
    }
}








