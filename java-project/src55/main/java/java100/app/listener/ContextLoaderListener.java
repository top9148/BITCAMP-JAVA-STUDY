package java100.app.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java100.app.util.DataSource;

// 웹 애플리케이션이 시작될 때 
// 스프링 IoC 컨테이너를 준비시키는 일을 한다.
//@WebListener <== 스프링 설정 클래스 정보를 DD File에서 받기 위해 
                   // 애노테이션을 제거한다. 대신 DD File에 선언한다.
public class ContextLoaderListener implements ServletContextListener {
    
    public static AnnotationConfigApplicationContext iocContainer;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행!");
        
        // DD File에서 Spring IoC 컨테이너의 설정 작업을 도와줄
        // 클래스 이름을 가져온다.
        ServletContext webApplicationInfo = sce.getServletContext();
        String configClassName = webApplicationInfo.getInitParameter(
                "contextConfigLocation");
        
        try {
        
            // 클래스 이름으로 클래스 정보를 다루는 객체를 얻는다.
            Class<?> configClass = Class.forName(configClassName);
            
            // 웹 애플리케이션이 시작될 때 
            // AppConfig 클래스에 설정된 대로
            // Spring IoC 컨테이너를 준비한다.
            iocContainer = new AnnotationConfigApplicationContext(configClass);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 웹 애플리케이션이 종료될 때 DB 커넥션 풀에 저장된 
        // 모든 커넥션을 닫는다.
        DataSource ds = iocContainer.getBean(DataSource.class);
        ds.close();
        
    }
}
