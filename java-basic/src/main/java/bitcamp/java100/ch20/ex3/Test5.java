// Spring IoC(Inversion of Control) 컨테이너 - 셋터 호출할 때 객체 생성하기
// 
package bitcamp.java100.ch20.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex3/application-context5.xml");

    }
}








