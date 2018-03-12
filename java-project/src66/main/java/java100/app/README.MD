## ver 66
- 프론트 컨트롤러를 Spring WebMVC 라이브러리로 교체하라!
- 학습목표
  - Spring WebMVC를 설정하는 방법을 익힌다.
 
## 작업 목록 

### Spring WebMVC 프레임워크를 다운로드 받는다.
- mvnrepository.com 에서 spring-webmvc를 검색한다.
- 프레임워크 정보를 build.gradle에 추가한다.
- 'gradlew eclipse'를 실행하여 프레임워크 관련 파일을 다운로드 받고, 이클립스 설정 파일을 갱신한다.
- 이클립스의 프로젝트를 "Refresh"한다.

### Spring WebMVC에서 제공하는 프론트 컨트롤러 서블릿을 DD 파일에 등록
- web.xml 파일에 DispatcherServlet 서블릿 파일을 등록한다.
- Java 객체를 이용하여 IoC 컨테이너의 설정 정보를 다루도록 변경한다.
- 기존에 만든 DispatcherServlet은 제거한다.
- IoC 컨테이너를 프론트 컨트롤러가 직접 관리하기 때문에 
  기존에 작성한 ContextLoaderListener를 제거한다.
  마찬가지로 web.xml에 설정된 이 리스너에 대한 정보도 제거한다.

### 클라이언트가 보낸 파라미터의 문자집합을 처리하는 필터를 교체한다.
- 우리가 만든 CharacterEncodingFilter를 제거한다.
- 대신 스프링에서 제공하는 필터는 web.xml 파일에 적용한다. 
  
### 페이지 컨트롤러에 붙인 애노테이션을 Spring Web-MVC 애노테이션으로 변경하라!
- 기존에 만든 애노테이션을 제거한다.
- 각 컨트롤러의 애노테이션을 다시 import 한다.

















