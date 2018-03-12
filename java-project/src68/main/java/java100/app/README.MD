## ver 68
- 로그인 기능을 구현하라!
- JSP에 대한 직접 접근을 막아라! 
- 학습목표
  - 쿠키와 세션을 활용하여 로그인을 처리하는 방법을 익힌다.
  - 필터를 이용하여 사용자 권한을 검사하는 방법을 연습한다.
  - JSP의 직접 접근을 막는 방법을 배운다.

## 작업 목록 

### 클라이언트가 JSP를 직접 요청하는 것을 막기
- JSP 파일을 WEB-INF 폴더로 옮긴다.
- 왜? WEB-INF/ 폴더에 있는 파일은 클라이언트가 요청할 수 없다.
- 스프링 설정 파일(dispatch-servlet.xml)에서 JSP 폴더 위치를 변경한다.

### 로그인 화면 만들기
- /webapp/auth/loginform.jsp 작성 

### 페이지 컨트롤러를 만들기
- java100.app.web.LoginController 클래스 작성

### MemberDao에 사용자 인증 기능 추가
- findByEmailAndPassword() 메서드 추가(MemberDao)
- 이 메서드가 사용할 SQL 문을 추가(MemberDao.xml)











