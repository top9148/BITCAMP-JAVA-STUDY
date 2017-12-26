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

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;
import java100.app.listener.ContextLoaderListener;

// urlPatterns 속성
// - 클라이언트가 "/score/"로 시작하는 URL을 요청할 때 
//   이 서블릿을 실행하라고 표시한다.
// - /score/로 시작하는 요청이 들어오면 서블릿 컨테이너는 이 서블릿 객체를 실행한다.
//
@WebServlet(urlPatterns="/score/*")   
public class ScoreServlet implements Servlet {
    
    // init()가 호출될 때 받은 파라미터 값을 저장할 변수
    ServletConfig servletConfig;
    
    // ScoreServlet 객체는 스프링 IoC 컨테이너가 더이상 관리하지 않는다.
    // 대신 서블릿 컨테이너가 관리한다.
    // 따라서 ScoreDao 객체를 자동으로 주입 받을 수 없다.
    // 해결책?
    // init()가 호출될 때 직접 스프링 IoC 컨테이너에서 
    // ScoreDao 객체를 꺼내 주입하라!
    //
    ScoreDao scoreDao;
    
    @Override
    public void destroy() {}
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        scoreDao = ContextLoaderListener.iocContainer.getBean(ScoreDao.class);
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "성적관리 서블릿";
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
        case "/add": this.doAdd(httpRequest, httpResponse); break;
        case "/list": this.doList(httpRequest, httpResponse); break;
        case "/view": this.doView(httpRequest, httpResponse); break;
        case "/update": this.doUpdate(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 삭제]");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            
            if (scoreDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no);
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 변경]");
        
        try {
            Score score = new Score();
            score.setNo(Integer.parseInt(request.getParameter("no")));
            score.setName(request.getParameter("name"));
            score.setKor(Integer.parseInt(request.getParameter("kor")));
            score.setEng(Integer.parseInt(request.getParameter("eng")));
            score.setMath(Integer.parseInt(request.getParameter("math")));
            
            if(scoreDao.update(score) > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", score.getNo());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doView(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 상세 정보]");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Score score = scoreDao.selectOne(no);
            
            if (score != null) {
                out.printf("번호: %d\n", score.getNo());
                out.printf("이름: %s\n", score.getName());
                out.printf("국어: %d\n", score.getKor());
                out.printf("영어: %d\n", score.getEng());
                out.printf("수학: %d\n", score.getMath());
                out.printf("합계: %d\n", score.getSum());
                out.printf("평균: %.1f\n", score.getAver());
            } else {
                out.printf("'%d'의 성적 정보가 없습니다.\n", no); 
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 목록]");
        
        try {
            List<Score> list = scoreDao.selectList();
            
            for (Score score : list) {
                out.printf("%4d, %-4s, %4d, %6.1f\n",
                        score.getNo(),
                        score.getName(), 
                        score.getSum(), 
                        score.getAver());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 등록]");
        
        try {
            Score score = new Score();
            score.setName(request.getParameter("name"));
            score.setKor(Integer.parseInt(request.getParameter("kor")));
            score.setEng(Integer.parseInt(request.getParameter("eng")));
            score.setMath(Integer.parseInt(request.getParameter("math")));
            
            scoreDao.insert(score);
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
}













