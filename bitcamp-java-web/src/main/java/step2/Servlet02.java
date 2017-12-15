// GenericServlet 추상 클래스
//
package step2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 이미 Servlet 라이브러리에 Servlet 인터페이스를 미리 구현한 
// 추상 클래스를 제공하고 있다.
//
@SuppressWarnings("serial")
@WebServlet("/step2/Servlet02")
public class Servlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("step2.Servlet02.service()");
    }
}









