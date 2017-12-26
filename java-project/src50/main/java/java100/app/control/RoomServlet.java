package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

//urlPatterns 속성
//- 클라이언트가 "/room/xxx" URL을 요청할 때 이 서블릿을 실행하라고 표시한다.
//- /room/xxx 요청이 들어오면 서블릿 컨테이너는 이 서블릿 객체를 실행한다.
//
@WebServlet(urlPatterns="/room/*")
public class RoomServlet implements Servlet {
    
    // init()가 호출될 때 받은 파라미터 값을 저장할 변수
    ServletConfig servletConfig;
    
    // RoomServlet 객체는 스프링 IoC 컨테이너가 더이상 관리하지 않는다.
    // 대신 서블릿 컨테이너가 관리한다.
    // 따라서 RoomDao 객체를 자동으로 주입 받을 수 없다.
    // 해결책?
    // init()가 호출될 때 직접 스프링 IoC 컨테이너에서 
    // RoomDao 객체를 꺼내 주입하라!
    //
    RoomDao roomDao;
    
    @Override
    public void destroy() {}
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        roomDao = ContextLoaderListener.iocContainer.getBean(RoomDao.class);
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "강의실관리 서블릿";
    }
    
    
    @Override
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {
        
        // 파라미터로 넘어오는 request 에는 원래 
        // ServletRequest의 하위 인터페이스인 HttpServletRequest 객체가 넘어온다.
        // 그러니 원래 타입으로 바꾼 후 사용하라!
        // 그냥 사용하면 안되나요?
        // => ServletRequest에는 웹 브라우저가 요청한 URL에서 
        //    서블릿의 경로를 리턴해주는 메서드가 없다.
        // => 그러니 귀찮더라도 원래 타입으로 바꿔야 한다.
        //    HttpServletRequest에는 URL에서 서블릿 경로를 추출해주는 
        //    getServletPath()라는 메서드가 있다.
        //
        // => request의 주소를 원래 타입으로 바꾼김에 아예,
        //    response 또한 원래 타입으로 바꾸자!
        // => 그래서 doAdd()나 doList() 등을 호출할 때
        //    쓰기 편하도록 원래 타입의 값을 넘기자!
        //
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // 출력하는 콘텐츠의 문자표 이름(character set)을 웹브라우저에게 알려줘라!
        httpResponse.setContentType("text/plain;charset=UTF-8");
        
        
        switch (httpRequest.getPathInfo()) {
        case "/list": this.doList(httpRequest, httpResponse); break;
        case "/add": this.doAdd(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doList(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");
        
        try {
            List<Room> list = roomDao.selectList();
            
            for (Room room : list) {
                out.printf("%d, %s, %s, %d\n", 
                        room.getNo(),
                        room.getLocation(),
                        room.getName(),
                        room.getCapacity());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doAdd(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[강의실 등록]");
        
        try {
            Room room = new Room();
            room.setLocation(request.getParameter("location"));
            room.setName(request.getParameter("name"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            
            roomDao.insert(room);
            
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[강의실 삭제]");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));
            
            if (roomDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'의 강의실 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
}










