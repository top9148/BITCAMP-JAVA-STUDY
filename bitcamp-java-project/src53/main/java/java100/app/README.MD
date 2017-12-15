# ver 53
- 오픈 소스 CSS 라이브러리인 "Bootstrap"을 화면을 꾸며라!
- npm(node package manager)이라는 패키지 관리자를 사용하여 CSS 라이브러리를 관리한다. 
- 학습목표
  - CSS를 활용하는 방법과 그 효과를 이해한다.
  - CSS, JavaScript 라이브러리를 효과적으로 관리하는 방법을 익힌다. 


## 작업 목록 

### Bootstrap CSS 라이브러리를 다운로드 받는다.
- npm 설치 확인
  - `npm -v`   
- 웹애플리케이션 루트 디렉토리에 패키지 설정 파일을 만든다.
  - java-project/src/main/webapp 폴더로 이동한다.
  - `npm init` 실행한다.
  - package.json 파일이 생성되었는지 확인한다.
- Bootstrap 라이브러리를 다운로드 받는다.
  - `npm install bootstrap@4.0.0-beta.2 --save`
  - node_modules 폴더가 생성되고 그 폴더에 라이브러리를 다운로드 받는다.
  - node_modules 폴더를 지우더라도 언제든지 'npm install'을 실행하면,
    package.json 파일에 등록된 라이브러리를 다시 다운로드 받는다.
  - 따라서 소스 파일을 공유할 때 node_modules는 공유하지 말라!
  - 특히 git 서버에 올리지 말라!
- HTML 페이지에 bootstrap을 적용
  - bootstrap 문서에서 설명한 대로 각 HTML 페이지에 적용한다.









  
