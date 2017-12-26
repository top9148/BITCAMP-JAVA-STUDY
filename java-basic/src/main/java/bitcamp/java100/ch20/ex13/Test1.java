// Spring IoC(Inversion of Control) 컨테이너 - 필드에 애노테이션 붙이기
// 
package bitcamp.java100.ch20.ex13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex13/application-context1.xml");
        
        // @Resource,@Autowired, @Qualifier를 셋터 대신에 필드에 붙일 수 있다.
        // 필드에 붙이게 되면 셋터가 필요없다.
        Car car = (Car) appCtx.getBean("c1");
        System.out.println(car);
        
        System.out.println("------------------------------------------");
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(appCtx.getBean(name));
        }
        
        
    }
}








