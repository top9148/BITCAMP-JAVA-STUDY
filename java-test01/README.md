# 연습 프로젝트
도서관리 시스템을 구현하라!

## 요구사항 
- 도서 정보 등록
  - 도서명, 출판사, 출판일, 가격, 설명, 사진
- 도서 정보 목록 출력
  - 도서사진, 도서명, 출판사, 가격
- 도서 상세 정보 출력
  - 도서번호, 도서명, 출판사, 출판일, 가격, 설명, 사진 
- 도서 정보 변경
  - 도서명, 출판사, 출판일, 가격, 설명, 사진 
- 도서 정보 삭제

## 작업 순서

### 도서관리에 사용할 테이블 작성
- book.sql

### 프로젝트 폴더 준비
- "gradle init --type java-application" 실행
- src/main/resources 폴더 생성
- src/main/webapp 폴더 생성
- src/test/resources 폴더 생성
- 기존 build.gradle 파일을 가져오기 
- "gradle eclipse" 실행하여 이클립스 설정 파일 생성

### 웹프로젝트 배치하기
- webapp/index.html 작성 
- 테스트용 톰캣 서버 구축
- 웹프로젝트 배치
- 실행 및 테스트

### 스프링 WebMVC 준비
- webapp/WEB-INF/web.xml 준비.
  - 기존 프로젝트에서 가져오기.
  - 현재 프로젝트에 맞춰 편집하기
- 프론트 컨트롤러(DispatcherServlet)의 스프링 설정 파일 준비. 
  - 기존 프로젝트에서 dispatch-servlet.xml 파일 가져오기.
  - 현재 프로젝트에 맞춰 편집하기
- jdbc 연결 정보 프로퍼티 파일 준비
  - 기존 프로젝트에서 가져오기.
  - 현재 프로젝트에 맞춰 편집하기
- 테스트용 페이지 컨트롤러 생성 
  - java100.app.web.HelloController 클래스 작성 
  - webapp/WEB-INF/jsp/hello.jsp 작성
- 페이지 컨트롤러 동작 테스트
  - http://localhost:9999/bitcamp-java-test01/app/hello 요청
  - JSP 실행결과 확인

### 도서정보 등록 기능 구현
- BookController 생성
- form() 메서드 추가
- WEB-INF/jsp/book/form.jsp 작성
  - 기존 프로젝트에서 가져와서 편집하기.
- WEB-INF/jsp/공통 JSP 파일 작성
  - 기본 프로젝트에서 가져와서 편집하기.
- CSS, JavaScript 라이브러리 준비
  - webapp/package.json 파일 준비. 기존 프로젝트에서 가져오기.
  - "npm install" 실행하여 라이브러리 가져오기.
  - 기존 프로젝트에서 만든 공통 css, javascript 파일 가져오기.
- 테스트
  - http://localhost:9999/bitcamp-java-test01/app/book/add 요청
  - CSS, JavaScript 연동 확인.
  - JSP including 확인
- 도서정보 입력폼 변경
  - 다른 프로젝트에서 가져온 form.jsp를 현재 기능에 맞게 변경하기.
- 도서정보 도메인 클래스 추가
  - java100.app.domain.Book 클래스 작성 
- BookController 변경
  - add() 메서드 추가
  - 도서정보 파라미터 값 확인
- 테스트 
  - 도서정보 입력폼에 값을 입력한 후 등록 버튼 클릭
  - 서버 콘솔 창에 파라미터 값 출력 확인!
- 업로드 파일 저장
  - 기존 프로젝트에서 파일 저장 코드 가져오기.
  - 파일을 저장하기.
- 테스트
  - 도서정보 등록 후 파일 저장 여부 확인
  - 톰캣 서버의 임시 배치 폴더에서 직접 확인한다.
- Service 컴포넌트 준비
  - BookService 인터페이스 작성
  - add() 메서드 추가 
  - DefaultBookService 구현체 작성
  - add() 메서드 구현
- DAO 컴포넌트 준비
  - BookDao 인터페이스 작성
  - insert() 메서드 추가
  - BookDao.xml SQL 맵퍼 파일 작성. 기존 파일 가져와서 편집.
  - <insert> 태그 추가  
- BookController 변경
  - BookService 객체를 주입
  - 서비스 객체를 이용하여 도서정보 등록
- 테스트
  - 도서정보를 등록한다.
  - 업로드된 파일이 잘 저장되었는지 또 확인하기.
  - DB 테이블에 데이터가 정확하게 들어갔는지 확인하기.

### 도서정보 목록보기 기능 구현
### 도서정보 상세보기 기능 구현
### 도서정보 변경 기능 구현
### 도서정보 삭제 기능 구현







