// 요청 핸들러의 파라미터
//
package java100.app.web.v02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v02/test10")
public class Test10 {

    // 요청 핸들러에서 선언 가능한 파라미터
    // => 프론트 컨트롤러(DispatcherServlet)가 줄 수 있는 파라미터
    // => HttpServletRequest, HttpServletResponse, HttpSession,
    //    HttpMethod, InputStream, Reader, OutputStream, Writer, 
    //    HttpEntity, Map/Model/ModelMap, Error/BindingResult, 
    //    SessionStatus, 파라미터, 경로의 일부 추출 값 등
    // 
    // => 프론트 컨트롤러는 페이지 컨트롤러의 메서드(요청 핸들러)를 
    //    호출하기 전에 그 메서드의 파라미터를 분석하여 
    //    원하는 값을 넘겨준다.
    // 
    @RequestMapping("m1")
    public String m1() {
        // 아무것도 원하지 않으면 프론트 컨트롤러는 
        // 아무것도 넘겨주지 않는다.
        return "/hello.jsp";
    }
    
    @RequestMapping("m2")
    public String m2(HttpServletRequest request) {
        // 프론트 컨트롤러가 줄 수 있는 것을 요구하라!
        // 그러면 줄 것이다.
        return "/hello.jsp";
    }
    
    @RequestMapping("m3")
    public String m3(HttpServletResponse response) {
        // 프론트 컨트롤러가 줄 수 있는 것을 요구하라!
        // 그러면 줄 것이다.
        return "/hello.jsp";
    }
}










