// AOP(Aspect-Oriented Programming) - AOP 필터 적용 후
// 
package bitcamp.java100.ch21.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex2/application-context4.xml");
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n", 
                    name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------------------------");
        
        // AOP?
        // => 기존의 코드를 손대지 않고 기능을 삽입하는 기술
        // => 메서드 호출 앞,뒤로 코드를 삽입할 수 있다.
        // => 일종의 필터를 추가하는 기술이다.
        //
        Front obj = (Front) appCtx.getBean(Front.class);
        obj.test();
        
        // 작업 순서
        // 0) AOP 관련 라이브러리 가져오기
        //    - mvnrepository.com 에서 "aspectjweaver"로 검색한다.
        //    - 라이브러리 정보를 build.gradle 파일에 추가한다.
        //    - "gradle eclipse" 실행하여 이클립스 설정 파일을 갱신한다.
        //    - 이클립스 프로젝트를 "refresh"한다.
        // 1) Advice를 수행할 클래스를 만든다.
        // 2) XML 설정 파일에 코드 삽입 정보를 지정한다.
    }
}

// [용어 정리]
// Advice
// => 메서드 호출 앞,뒤에 삽입하는 코드이다.
//
// Pointcut
// => 코드를 삽입할 메서드의 위치정보.
// 
// Join point
// => 코드가 삽입되는 곳. 메서드를 말한다.
//
// Target object
// => 코드가 삽입될 대상이 되는 객체.
//
// Aspect
// => 어떤 위치(pointcut)에 어떤 코드(advice)를 삽입할 것인지를 
//    가리키는 정보.







