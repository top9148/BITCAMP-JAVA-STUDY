## ver 74
- 요청에 대한 응답으로 HTML 대신 JSON 형식의 문자열을 보내라!
- 즉 RESTful API를 구현하라!
- 학습목표
  - 프론트 컨트롤러를 여러 개 사용하는 방법을 배운다.
  - 프론트 컨트롤러들이 공유하는 객체를 분리하는 방법을 배운다.
  - RESTful API를 만드는 방법을 배운다.
  - Back-end 와 Front-end를 분리하는 방법을 배운다.
  - JavaScript의 DOM API와 AJAX 활용을 익힌다.
  
### 작업 목록

#### JSON 결과를 리턴할 페이지 컨트롤러를 분리한다.
- web.xml 에 프론트 컨트롤러를 추가한다.
- 프론트 컨트롤러가 사용할 스프링 설정 파일을 추가한다.
  - app-servlet.xml (기존의 dispatch-servlet.xml의 이름을 바꾼 것이다.)
  - json-servlet.xml
- app-servlet.xml에서 JSON 관련 페이지 컨트롤러 생성을 제외한다.
- json-servlet.xml에서는 app관련 페이지 컨트롤러 생성을 제외한다.

#### 여러 프론트 컨트롤러들이 공유할 객체는 별도의 컨테이너로 분리한다.
- web.xml에 ContextLoaderListener를 추가한다.
- ContextLoaderListener가 사용할 스프링 설정 파일을 만든다.
  - application-servlet.xml 파일을 추가한다.
  - Service, DAO 등 웹 이외의 공통 객체를 이 컨테이너에서 관리한다.

#### JSON 결과를 리턴하는 페이지 컨트롤러를 만든다.
- 기존의 컨트롤러를 복사하여 @RestController로 만든다.
- 요청 핸들러는 jsp url을 리턴하는 대신 DBMS에서 가져온 데이터 객체를 리턴한다.

#### 데이터를 받아서 출력할 HTML 페이지를 만든다.
- /webapp/score/list.html
- /webapp/score/form.html














