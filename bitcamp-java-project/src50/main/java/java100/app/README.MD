# ver 50 작업 목록

## 웹 프로젝트로 전환
build.gradle 파일을 편집하여 이클립스 웹 프로젝트 관련 설정 파일을 생성하게 한다.
- 'eclipse-wtp' 플러그인 추가
- 'war' 플로그인 추가
- 명령창에서 `gradlew eclipse` 실행하여 설정 파일을 갱신한다.  
- 프로젝트를 `refresh` 하여 웹프로젝트 전환 여부를 확인한다.

## 웹 프로젝트를 서블릿 컨테이너에 배치
- 톰캣 테스트 실행 서버에 웹 애플리케이션을 추가한다.
- 서버 실행하고 웹브라우저로 확인한다.

## 리스너를 이용하여 Spring IoC 컨테이너를 준비
- ServletContextListener 구현체를 만든다.
  - 웹 애플리케이션이 시작될 때 Spring IoC 컨테이너를 준비한다.
  - ContextLoaderListener 클래스 작성
- AppInitServlet 클래스 변경
  - 이 클래스는 더이상 서블릿이어야 할 이유가 없다.
  - 그냥 DataSource 객체를 만들어주는 설정 객체로 역할을 축소한다.
  - 그래서 이름도 AppConfig 라고 변경한다.
- DD File을 생성
  - src/main/webapp 폴더를 만든다.
  - webapp/WEB-INF/web.xml 파일을 다른 프로젝트에서 복사해 온다.
    그리고 적절하게 편집한다.
  - web.xml에 컨텍스트 파라미터로 AppConfig 클래스의 이름을 등록한다.
  - ContextLoaderListener 클래스는 이 파라미터에 설정된 클래스 이름을 가져와서
    로딩하여 Spring IoC 컨테이너를 준비한다.
- 이클립스 설정 파일을 갱신한다.
  - src/main/webapp 폴더를 새로 추가했으면 
    콘솔창에서 `gradlew eclipse`를 실행하여 이클립스 설정 파일을 갱신하라!
  - 프로젝트 `Refresh` 하고, 톰캣 서버를 다시 실행하여 확인한다.  











