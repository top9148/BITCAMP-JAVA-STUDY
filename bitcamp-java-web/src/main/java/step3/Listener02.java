// 리스너의 배치 
//
package step3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

// ServletRequestListener 
// - 클라이언트로부터 요청이 들어오면 보고 받는다.
//
// 리스너는 
// 1) 애노테이션을 이용하여 배치하거나,
//    - @WebListener 
// 2) DD 파일에 배치 정보를 설정할 수 있다.
//    - src/main/webapp/WEB-INF/web.xml 파일
//
public class Listener02 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sce) {
        // 이 메서드는 클라이언트 요청이 들어오면 호출된다.
        System.out.println("Listener02.requestInitialized()");
        
        // 이 메서드에서
        // - 요청 기록을 남기거나
        // - 요청 횟수를 계산하거나
        // - 클라이언트가 보낸 데이터를 서블릿이 사용하기 쉽게 가공하거나 
        // 등의 일을 할 수 있다.
        // 
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sce) {
        // 이 메서드는 클라이언트 요청 처리가 완료되면 호출된다.
        System.out.println("Listener02.requestDestroyed()");
    }
}












