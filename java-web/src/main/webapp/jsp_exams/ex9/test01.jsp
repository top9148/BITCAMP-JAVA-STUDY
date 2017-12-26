<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>JSTL(JSP Standard Tag Library) 사용법</h1>
특정 자바 코드를 생성하는 태그이다.<br>

<h2>사용 절차</h2>
<pre>
1. JSTL 라이브러리 다운로드
  - JSTL API와 이 API를 구현한 라이브러리를 다운로드 받는다.
  - build.gradle에 라이브러리 정보 추가한다.
  - "gradlew eclipse" 실행하여, 이클립스 설정 파일을 갱신한다.
2. JSP 페이지에 사용할 태그 라이브러리 정보를 추가한다.
  - &lt;%@ taglib uri="사용할 태그 라이브러리 이름" prefix="별명"%>
3. JSTL 태그를 사용한다.
  - &lt;별명:태그명 ..../>    
</pre>

<h2>JSTL 태그 라이브러리 목록</h2>
<pre>
1. Core
  - 태그라이브러리 이름: "http://java.sun.com/jsp/jstl/core"
  - 주로 사용하는 별명: "c"
2. XML
  - 태그라이브러리 이름: "http://java.sun.com/jsp/jstl/xml"
  - 주로 사용하는 별명: "x"
3. I18N
  - 태그라이브러리 이름: "http://java.sun.com/jsp/jstl/fmt"
  - 주로 사용하는 별명: "fmt"
4. Database
  - 태그라이브러리 이름: "http://java.sun.com/jsp/jstl/sql"
  - 주로 사용하는 별명: "sql"
5. Functions
  - 태그라이브러리 이름: "http://java.sun.com/jsp/jstl/functions"
  - 주로 사용하는 별명: "fn"
</pre>

<h2>용어</h2>

<h3>I18N</h3>
<p>
Internationalization 의 약자이다.<br>
프로그램을 개발할 때 다국어를 지원할 것을 대비해 개발하는 것을 말한다.<br>
즉 영어를 사용하는 경우 모든 라벨이나 메뉴가 영어로 출력하고,<br>
쿠르드어를 사용하는 경우 모든 라벨이나 메뉴가 그 언어로 출력되게 하는 것<br>
</p> 

<h3>L10N</h3>
<p>
</p>
Localization 의 약자이다.<br>
국제화를 지원하도록 만든 프로그램에서는 각 언어 별로 텍스트 파일을 만든다.<br>
이 때 각 언어 별로 라벨이나 메뉴에 출력될 텍스트 파일을 만드는 것을 말한다.<br>
</body>
</html>

















