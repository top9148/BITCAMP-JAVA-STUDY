## ver 67
- 퍼시스턴스 프레임워크 "mybatis"를 적용하라!
- 학습목표
  - mybatis 프레임워크를 사용하여 데이터를 다루는 방법을 연습한다.

## 작업 목록 

### Spring WebMVC 프레임워크 적용 방식을 변경한다.
- 애노테이션 설정 방식 대신 XML 설정 방식을 적용한다.
- WEB-INF/dispatch-servlet.xml 준비
- WEB-INF/web.xml에서 DispatcherServlet 설정을 변경한다.
- 페이지 컨트롤러의 패키지명을 conrol 에서 web 으로 바꾼다.
- 파일 업로드 라이브러리 추가한다.
- Json 데이터를 처리할 jackson 라이브러리 추가한다.

### @ControllerAdvice 클래스 등록
- 클래스 @ControllerAdvice 애노테이션이 붙어 있다.
- 페이지 컨트롤러를 실행할 때 마다 옆에서 작업을 보조해주는 객체이다. 
- 문자열로 날짜값이 넘어온 경우 java.util.Date 객체로 변환시키는 작업 등을 수행한다.
- java100.app.web.bind.DefaultControllerAdvice 클래스 추가한다.

### 페이지 컨트롤러를 변경한다.
- Spring WebMVC에 기본으로 설정되어 있는 view resolver 대신에 InternalResourceViewResolver에 맞춰 요청 핸들러의 리턴 값을 변경한다.
- view component(ex: JSP)에게 전달할 값을 직접 ServletRequest에 담는 대신에 Model 객체에 담는다.

### JSP 변경한다.
- 접미사 .do 를 제거한다.
- url이 /app/* 으로 변경되었기 때문에 이에 따라 css, javascript 파일의 경로도 변경해준다.

### mybatis 적용
- mybatis 라이브러리 추가
- mybatis-spring 연동 라이브러리 추가
- apache-dbcp2 DataSource 라이브러리 추가
- spring-jdbc 라이브러리 추가
- jdbc.properties 파일 추가
- /WEB-INF/dispatch-servlet.xml 파일에 mybatis 관련 객체 등록
- /src/main/resources/java100/app/jdbc.properties 파일 준비
- /src/main/resources/java100/app/dao/*Dao.xml 파일 준비
- DAO 인터페이스의 메서드명 변경
  - selectList() ==> findAll()
  - selectOne() ==> findByNo()
- 페이지 컨트롤러 변경
- DAO 구현체 제거 













