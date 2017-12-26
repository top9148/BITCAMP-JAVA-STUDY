package java100.app.control;

import java.io.PrintWriter;

import org.springframework.stereotype.Component;

@Component("/hello")  // 이 클래스의 객체를 자동 생성해야 함을 표시!
public class HelloController implements Controller {
    
    @Override
    public void destroy() {}
    
    @Override
    public void init() {}
    
    
    @Override
    public void execute(Request request, Response response) {
        switch (request.getMenuPath()) {
        case "/hello/hi": this.doHi(request, response); break;
        case "/hello/hi2": this.doHi2(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doHi(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("하이루~~~");
    }
    
    private void doHi2(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("오호라... 안녕!");
        
    } 
}










