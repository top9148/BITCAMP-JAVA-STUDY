## ver 65
- 페이지 컨트롤러의 코드 크기가 작은 경우, 
  유지보수 하기 쉽게 서로 관련된 페이지 컨트롤러들을 한 클래스로 묶어라!
- 학습목표
  - Command 패턴에 의해 쪼개진 클래스들을 다시 한 클래스로 합치는 방법을 연습한다.
  - 애노테이션을 다루는 방법을 연습한다.
 
## 작업 목록 

### 페이지 컨트롤러 변경
- ScoreXxxController 클래스들에 있는 요청 핸들러를 ScoreController 클래스로 옮긴다.
- 각각의 요청 핸들러의 @RequestMapping에 URL을 설정한다.
- 각 페이지 컨트롤러에 붙인 @Component 애노테이션 대신, 
  페이지 컨트롤러임을 자세히 명시하는 @Controller를 붙인다.
- @Controller를 붙일 때 URL 값은 뺀다.

### 요청 핸들러를 관리할 클래스를 준비
- 한 페이지 컨트롤러에 요청 핸들러가 여러 개 들어 있다.
- 그래서 URL의 서블릿 경로를 이용하여 요청 핸들러가 들어 있는 페이지 컨트롤러를
  쉽게 찾을 수없다.
- 해결방안?
  - 각 페이지 컨트롤러에 들어있는 메서드를 찾아내서 그 메서드의 붙은 
    URL 정보를 별도로 관리한다.
- RequestMappingHandlerMapping 클래스를 정의한다.

### ContextLoaderListener 변경
- 스프링 IoC 컨테이너에서 객체를 준비한 후 
  RequestMappingHandlerMapping을 이용하여 요청 핸들러 맵을 준비시킨다.

### 프론트 컨트롤러를 변경
- 스프링 IoC 컨테이너에서 직접 요청 핸들러를 찾지 않고,
  RequestMappingHandlerMapping에서 찾아 호출한다.

  



















