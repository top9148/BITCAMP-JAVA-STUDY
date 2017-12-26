// Spring IoC(Inversion of Control) 컨테이너 사용
// 1) 라이브러리 준비
//    => mvnrepository.com 또는 spring.io 사이트에서 
//       라이브러리 정보(spring-context)를 얻는다.
//    => build.gradle 파일에 의존 라이브러리 정보를 등록한다.
//    => "gradlew eclipse" 명령을 실행하여 라이브러리 다운로드 및 
//       이클립스 설정 파일을 갱신한다.
//    => 이클립스 프로젝트를 "Refresh" 한다.
// 
// 2) 스프링 IoC 컨테이너 객체 생성
// 
package bitcamp.java100.ch20.ex1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        
        // 1) XML 설정 파일을 읽어서 객체를 준비하는 컨테이너
        // => XML 설정 파일은 자바 클래스 경로에 존재한다.
        //
        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch20/ex1/application-context.xml");

        // 2) bean container에 보관된 객체 조회하기
        System.out.printf("빈 개수 = %d\n", appCtx.getBeanDefinitionCount());
        
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s\n    ----> %s\n", name,
                    appCtx.getBean(name).getClass().getName());
        }
        
        System.out.println("-----------------------");
        
        // 3) 빈을 꺼내 출력해보자!
        String s1 = (String) appCtx.getBean("str1");
        String s2 = (String) appCtx.getBean("str2");
        
        System.out.println(s1);
        System.out.println(s2);
    }

}








