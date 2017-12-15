// 웹 애플리케이션 멤버 - XxxListener
//
package step3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 리스너?
// 서블릿 컨테이너에 특정 사건이 발생했을 때 
// 보고받는 역할을 한다.
//
// 구현 방법
// - 보고 받고자 하는 사건에 따라 정해진 규칙을 준수하여 클래스를 작성한다.
//
// 예) 웹 애플리케이션을 시작하거나 종료할 때 보고 받고 싶다! 
// => ServletContextListener 인터페이스를 구현하라!
//
@WebListener // <== 따로 URL을 지정하지 않는다.
public class Listener01 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 이 메서드는 이 리스너가 소속된 웹 애플리케이션이 시작될 때 
        // 호출된다.
        System.out.println("Listener01.contextInitialized()");
        
        // 이 리스너의 경우 웹 애플리케이션에 소속된 모든 멤버들이 
        // 사용할 자원을 여기에서 준비하면 된다.
        // 예를 들어, 스프링 IoC 컨테이너를 여기에서 준비하면 좋다.
        // 
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 이 메서드는 이 리스너가 소속된 웹 애플리케이션이 종료될 때 
        // 호출된다.
        System.out.println("Listener01.contextDestroyed()");
    }
}












