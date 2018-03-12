// AOP - 애노테이션을 이용하여 advice 지정하기 
// 
package bitcamp.java100.ch21.ex6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex6/application-context1.xml");
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", 
                    name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------------------------");
        
        Front obj = (Front) appCtx.getBean(Front.class);
        System.out.println(obj.x.getClass().getName());
        
        System.out.println("------------------------------------------");
        
        obj.test("홍길동");
        
        System.out.println("------------------------------------------");
        
        obj.test(null); // 예외가 발생하는 경우!
        
    }
}








