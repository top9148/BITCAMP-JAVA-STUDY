// Spring IoC(Inversion of Control) 컨테이너 - singleton 범위
// 
package bitcamp.java100.ch20.ex7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex7/application-context3.xml");
        
        System.out.println("---------------------------------");
        // prototype으로 설정된 경우,
        // getBean()을 호출할 때마다 생성된다.
        //
        Engine obj1 = (Engine) appCtx.getBean("e1");
        Engine obj2 = (Engine) appCtx.getBean("e1");
        Engine obj3 = (Engine) appCtx.getBean("e1");
        
        if (obj1 != obj2)
            System.out.println("obj1 != obj2");
        
        if (obj1 != obj3)
            System.out.println("obj1 != obj3");
        
        if (obj2 != obj3)
            System.out.println("obj2 != obj3");
    }
}








