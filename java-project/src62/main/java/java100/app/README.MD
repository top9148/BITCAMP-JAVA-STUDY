## ver 62
- 페이지 컨트롤러를 POJO 클래스로 만들라!
- 그리고 Spring IoC 컨테이너로 관리하라!
- 학습목표
  - Spring IoC 컨테이너를 이용하는 방법을 연습한다.

  
## 작업 목록 

### 페이지 컨트롤러를 POJO로 만들기
- 페이지 컨트롤러를 둘 패키지를 생성한다. => java100.app.control
- 프론트 컨트롤러와 페이지 컨트롤러 사이의 호출 규칙을 정의한다. 
  => PageController
- XxxServlet 클래스를 XxxController로 변경하여 control 패키지에 둔다. 
 
### 프론트 컨트롤러가 POJO로 바꾼 페이지 컨트롤러를 호출하게 변경한다.