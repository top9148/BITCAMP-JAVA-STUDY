// 요청 핸들러의 파라미터 - 파일 업로드
//
package java100.app.web.v02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/v02/test13")
public class Test13 {

    // 테스트 하는 방법
    // => http://localhost:9999/spring-webmvc/v02/test13.html
    
    
    // 클라이언트가 멀티파트 형식으로 보낸 데이터를 파라미터 받기
    // 
    @RequestMapping
    public String fileupload(
            String name,
            int age,
            boolean working,
            MultipartFile photo) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(working);
        System.out.println(photo.getOriginalFilename());
        System.out.println("--------------------");
        return "/hello.jsp";
    }
}

// 멀티파트 데이터 처리 방법
// 1) apache의 commons-fileupload 라이브러리를 사용하여 처리
//    - apache commons-fileupload 라이브러리를 가져온다.
//      => mvnrepository.com 에서 'commons-fileupload' 라이브러리 검색
//      => 라이브러리 정보를 build.gradle 에 추가
//      => "gradlew eclipse"를 실행
//      => 웹프로젝트 "Refresh"
//    - 멀티파트 데이터를 처리할 객체를 스프링 IoC 컨테이너에 등록한다.
//      => app-servlet.xml 에 CommonsMultipartResolver 클래스의 객체를
//         "multipartResolver"라는 이름으로 객체를 등록한다.
//    - 요청 핸들러에 파라미터 선언
//      => 파일을 받으려면 MultipartFile 타입의 변수를 선언한다.
// 2) Servlet 3.0의 기능을 이용하는 방법
//    - DD 파일에 프론트 컨트롤러(DispatcherServlet)가 멀티파트 데이터를 처리해야 
//      한다고 설정하라!
//      => web.xml 파일의 DispatcherServlet 선언에 "multipart-config" 태그 추가
//    - 멀티파트 데이터를 처리할 객체를 스프링 IoC 컨테이너에 등록한다.
//      => app-servlet.xml 에 StandardServletMultipartResolver 클래스의 객체를
//         "multipartResolver"라는 이름으로 객체를 등록한다.
//    - 요청 핸들러에 파라미터 선언
//      => 파일을 받으려면 MultipartFile 타입의 변수를 선언한다.
//      => 또는 표준 타입인 Part 변수를 선언해도 된다.









