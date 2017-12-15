// Spring IoC(Inversion of Control) 컨테이너 - @Component
// 
package bitcamp.java100.ch20.ex14;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex14/application-context1.xml");
        
        // @Component 애노테이션 사용
        // => @Component 애노테이션을 이용하여 생성한 객체의 이름은 
        //    <bean> 태그에서 id나 name 없이 생성한 객체 이름과 다르다.
        //
        // => <bean class="bitcamp.java100.ch20.ex14.Car"/>
        //    이렇게 XML 태그로 생성한 객체의 이름은 "클래스명#인덱스"
        //    예) "bitcamp.java100.ch20.ex14.Car#0"
        //
        // => @Component 애노테이션으로 만든 객체는
        //    패키지명을 제외한 클래스명에서 첫 알파벳을 소문자로 한 이름을 사용.
        //    예) "car"
        //
        Car car = (Car) appCtx.getBean("car");
        System.out.println(car);
        
        System.out.println("------------------------------------------");
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", name, appCtx.getBean(name));
        }
        
        
    }
}








