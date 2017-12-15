package step6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 리스너에서 DD File에 선언된 컨텍스트 파라미터 값 사용하기
//
public class Listener01 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹 애플리케이션이 시작될 때 이 메서드가 호출된다.
        // 그러면 이 리스너는 웹 애플리케이션의 멤버들이 사용할
        // 자원을 준비시킨다.
        // 자원을 준비할 때 자원의 path, id, password, character set 등의
        // 값을 사용할텐데, 
        // 그 값을 코드에 직접 넣지 않고 외부에 저장해 두면 
        // 그 값을 변경하기가 편리할 것이다.
        // 
        // 이런 경우를 가정해서 DD File에 작성된 값을 가져오는 방법을 알아보자!
        
        // 파라미터로 받은 이벤트 객체를 통해 웹 애플리케이션 환경 정보를
        // 다루는 객체를 알아낸다.
        ServletContext webApplicationContext = sce.getServletContext();
        
        String driver = webApplicationContext.getInitParameter("driver");
        String url = webApplicationContext.getInitParameter("url");
        
        System.out.printf("driver=>%s\n", driver);
        System.out.printf("url=>%s\n", url);
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}






