# 웹 애플리케이션

## 웹 애플리케이션의 발전 역사
- 문서 교환을 원활하게 하기 위함
    - HTML, HTTP
    - HTTP Client(Web Browser), HTTP Server(Web Server)
- 제품 및 회사 홍보용 
    - 제품 카달로그 
    - 회사 홈페이지
- 고객과의 상호작용
    - CGI 프로그램 
    - 방명록, Q&A, 게시판, 주문 등
- 웹 애플리케이션으로 성장
    - 글로벌 비즈니스의 가속화 => 무한 경쟁 => 제품의 생명주기가 짧아짐
      => 조직과 업무의 변화가 잦아짐 => 프로그램의 변경이 잦아짐
      => 프로그램 배포가 잦아짐 => PC에 프로그램 업데이트가 번거로워 짐 
      => Client 설치 형에서 서버에 접속해서 사용하는 방식으로 전환
    - 기업용 프로그램이 빠르게 웹 애플리케이션으로 전환
    - Thin Client 방식의 등장 => 대부분의 작업을 서버에서 실행하기 때문에 PC의 성능이 높지 않아도 된다. => 작업의 결과를 PC가 아닌 서버에 저장한다.
- 모바일의 등장
    - 다양한 해상도의 지원이 필요 => 반응형 웹 등장 => 해상도에 따라 화면의 배치를 자동화시키는 기법을 사용
    - 설치형 애플리케이션이 재조명 => 서버에서 화면을 만들어 제공하는 방식의 문제점이 발생 => 서버에서는 데이터만 제공하는 방식이 등장 => RESTful 방식으로 개발 => AJAX 등 비동기 기술이 등장.

## CGI 프로그램
### CGI 개념
### CGI 프로그램
### Java CGI 프로그램

## JavaEE

## Java EE vs WAS

## Java EE 와 컨테이너

## 학습에서 사용할 시스템 아키텍처

## 웹 애플리케이션과 서블릿

## 웹 애플리케이션 디렉토리 구조 

## 톰캣 서버에 웹 애플리케이션 배치

## 이클립스 개발 환경에서 웹 애플리케이션을 배치하고 실행하는 방법
1) 이클립스에 톰캣 서버의 위치를 설정한다.
  - 메뉴 > Window > Preferences...
2) 톰캣 테스트 실행 환경을 추가한다.
  - Server 뷰 > 톰캣 실행 환경 추가
3) 톰캣 실행 및 임시 배치 폴더 확인
  - 웹브라우저로 http://localhost:9999 실행
  - c:\workspace\.metadata\.plugins\...server.core\tmp0 폴더 확인
4) 웹 프로젝트 생성
  - c:\workspace 폴더로 이동
  - mkdir java-web (웹프로젝트 폴더 생성)
  - gradle init --type java-application (자바 프로젝트 구조 생성)
  - src\main\resources 폴더를 생성한다.
  - src\main\webapp 폴더를 생성한다. (웹애플리케이션 프로젝트일 경우)
  - src\test\resources 폴더를 생성한다. 
5) build.gradle 파일 편집
  - 이클립스 WTP(Web Tool Plugin) 설정 파일을 위한 플러그인 추가 
    - apply plugin: 'eclipse-wtp'
    - 이 플러그인을 추가하면 'eclipse' 플러그인을 따로 추가할 필요가 없다.
  - WAR 파일을 다루는 플러그인 추가
    - apply plugin: 'war'
    - 이 플러그인을 추가하면 war 파일을 생성할 수 있다.
  - servlet-api 의존 라이브러리 정보 추가
    - providedCompile 'javax.servlet:javax.servlet-api:3.1.0'
    - 이 라이브러리를 추가해야만 서블릿 관련 클래스나 인터페이스를 사용하여 코드를 작성하고 컴파일 할 수 있다.
6) gradle을 실행하여 이클립스 설정 파일을 생성하거나 갱신한다.
  - gradle eclipse 또는 gradlew eclipse 실행한다.
7) 이클립에서 'java-web' 프로젝트를 import 하라!
8) 배포 테스트 하기 
  - src/main/webapp/hello.html 만들라!
  - Servers 뷰 > 톰캣 테스트 환경 > 컨텍스트 메뉴 > 웹 프로젝트 추가
  - 톰캣 테스트 환경을 재시작한다.
9) 웹브라우저로 접속 테스트
  - http://localhost:9999/java-web/hello.html

