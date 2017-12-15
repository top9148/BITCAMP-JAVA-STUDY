// Spring IoC(Inversion of Control) 컨테이너 - Date 프로퍼티 변환기
// 
package bitcamp.java100.ch20.ex5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex5/application-context3.xml");
        
        System.out.println(appCtx.getBean("c1"));
    }
}








