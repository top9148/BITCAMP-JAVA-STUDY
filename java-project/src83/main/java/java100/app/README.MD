## ver 83
- 폰갭 프레임워크로 배포하라!
- 학습목표
  - 폰갭 프레임워크를 사용하여 웹앱을 배포하는 방법을 배운다.

### 작업 목록

#### 서버 주소를 별도의 자바스크립트 파일로 분리하라.
- 기존의 자바스크립트 코드에서는 ajax를 실행할 때 상대주소를 사용하였다.
- 앱에서 서버에 접근하려면 상대주소를 사용할 수 없다.
- 정확하게 서버의 주소를 지정해야 한다.
- /webapp/js/context.js 파일 추가

#### 기존의 Ajax 코드에서 URL의 주소를 절대 주소로 바꿔라.
- /webapp/header.html 변경
- /webapp/auth/form.html 변경
- /webapp/score/form.html 변경
- /webapp/score/list.html 변경

#### Ajax Cross-Domain 지원
- 다른 도메인 요청 ajax 서비스를 허락한다.
- 응답 헤더에 "Access-Control-Allow-Origin" 추가 
- web.interceptor.AjaxAccessOriginInterceptor.java 파일 추가
- /webapp/WEB-INF/json-servlet.xml 파일에 interceptor 추가

#### Phonegap 서버에 배치
- HTML 리소스를 폰갭 프로젝트의 www 폴더에 복사한다.
- /webapp/auth/*
- /webapp/css/*
- /webapp/footer.html
- /webapp/header.html
- /webapp/images/*
- /webapp/index.html
- /webapp/js/*
- /webapp/package.json
- /webapp/score/*
- 복사한 후 폰갭 프로젝트의 www 폴더로 가서 "npm install"을 실행하여 노드 모듈을 가져온다.
- 폰갭서버를 재실행
- 스마트 폰에서 앱 재실행 및 서버에 접속
- 테스트!









