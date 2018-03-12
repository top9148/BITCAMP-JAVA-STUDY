## ver 81
- 페이스북 로그인을 추가하라!
- 학습목표
  - 페이스북 로그인 API를 사용하는 방법을 배운다.
  - 페이스북 로그인 후 시스템 로그인을 자동화시키는 방법을 배운다.

### 작업 목록

#### /WEB-INF/jsp/auth/loginform.jsp 변경
- 자바스크립트용 페이스북 로그인 API를 이용하여 페이스북 로그인 기능을 추가한다. 

#### web.LoginController 페이지 컨트롤러 변경
- facebookLogin() 요청 핸들러 추가한다.

#### FacebookService 컴포넌트 추가
- service.FacebookService 인터페이스 추가
- service.FacebookServiceImpl 클래스 추가

#### MemberService 컴포넌트 변경 
- service.MemberService 인터페이스에 get(String email) 메서드 추가
- service.MemberServiceImpl 클래스에 get(String email) 메서드 구현

#### MemberDao 컴포넌트 변경
- findByEmail() 메서드 추가
- MemberDao.xml 에 findByEmail() 메서드가 사용할 select 문 추가

#### /webapp/auth/form.html 변경
- 페이스북 로그인 버튼 및 자바스크립트 추가

#### web.json.LoginController RESTful 페이지 컨트롤러 변경
- facebookLogin() 요청 핸들러 추가한다.
 




