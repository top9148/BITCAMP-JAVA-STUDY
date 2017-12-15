// Servlet 인터페이스를 미리 구현한 추상 클래스 사용하기
//
package step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// Servlet 인터페이스를 미리 구현한 추상 클래스를 상속 받게되면
// 당장 구현할 필요가 없는 메서를 만들지 않아서 편하다!
//
@WebServlet("/step2/Servlet01")
public class Servlet01 extends AbstractServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step2.Servlet01.service()");
    }
}









