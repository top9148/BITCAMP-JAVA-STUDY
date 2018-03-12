# Spring WebMVC 프로젝트 생성하기

## 웹 프로젝트 폴더를 생성한다.
- "mkdir spring-webmvc" 실행한다.

## 해당 폴더로 이동하여 프로젝트 기본 설정 파일과 폴더를 생성한다.
- "cd spring-webmvc" 실행한다.
- "gradle init --type java-application" 실행한다.

## 기존 웹프로젝트의 build.gradle 파일을 복사해온다.

## 이클립스 IDE에서 import 할 수 있도록 이클립스 관련 파일을 생성한다.
- "gradle eclipse"

## 이클립스 IDE로 웹 프로젝트를 import 한다.

## 웹 리소스(html, css, javascript, jsp, jpg 등)를 저장할 파일을 생성한다.
- /src/main/webapp 폴더 생성

## DD 파일 생성
- /src/main/webapp/WEB-INF 폴더 생성한다.
- /src/main/webapp/WEB-INF/web.xml 파을 생성한다.
- web.xml 파일을 기존 프로젝트에서 복사해온다.
- <welcome-file-list> 태그만 두고 모두 지운다.

## 웹 애플리케이션 컨텍스트 루트 폴더에 환영 메시지를 출력하는 파일 생성.
- /src/main/webapp/index.html 파일 생성

## 이클립스 설정 파일을 다시 갱신한다.
- src/main/webapp 폴더를 생성하였으면, 이클립스 설정 파일을 갱신해야 만 webapp 폴더 정보가 설정 파일에 등록된다.
- "gradle eclipse" 실행한다.
- 이클립스 프로젝트를 "Refresh" 한다.
  
## 웹애플리케이션을 테스트하기 위한 톰캣 테스트 환경 구축
- 이클립스의 "Servers" 뷰에서 새 서버(spring-webmvc)를 추가한다.
- 톰캣 테스트 환경에 "spring-webmvc" 웹프로젝트를 추가한다.

## 톰캣 서버를 실행한 후 컨텍스트 루트의 index.html을 테스트한다.
- 톰캣 서버를 시작시킨다.
- 웹브라우저에서 http://localhost:9999/ 주소를 입력한다.

## spring-webmvc 프레임워크 관련 파일을 프로젝트에 가져온다.
- mvnrepository.com 에서 spring-webmvc 검색하여 라이브러리 이름을 알아낸다.
- build.gradle 파일에 의존 라이브러리 정보를 등록한다.
- "gradle eclipse"를 실행하여 라이브러리를 다운로드하고 이클립스 설정 파일을 갱신한다.
- 이클립스 프로젝트를 "Refresh" 한다.

## DD 파일에 Spring WebMVC에서 제공하는 프론트 컨트롤러를 설정한다.
- web.xml 파일에 DispatcherServlet 서블릿을 등록한다.

## DispatcherServlet의 IoC 컨테이너가 사용할 XML 설정 파일을 만든다.
- /webapp/WEB-INF/app-servlet.xml 파일 생성
- 스프링 레퍼런스 문서에서 복사해온다.

## 요청 파라미터의 문자집합을 설정할 필터를 등록한다.
- web.xml 파일에 CharacterEncodingFilter 필터를 등록한다.

## HelloWorld! 출력 페이지 컨트롤러 생성하기
- "java100.app.web" 패키지 생성 
- 이 패키지에 HelloController 클래스 추가
- /src/main/webapp/hello.jsp 추가

## 톰캣 서버 재시작한 후 페이지 컨트롤러 실행 확인






