// Spring IoC(Inversion of Control) 컨테이너 - 셋터 호출 II
// 
package bitcamp.java100.ch20.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex3/application-context2.xml");

    }
}








