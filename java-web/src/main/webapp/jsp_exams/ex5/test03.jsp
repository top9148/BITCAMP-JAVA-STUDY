<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<h1>지시부(directive element)</h1>
서블릿 클래스에 특별한 작업을 지시할 때 사용한다.<br>

<h2>JSP 코드 - taglib</h2>
JSP 에서 제공하는 태그 외에 외부에서 확장 태그를 가져올 때 사용한다.<br>
확장 태그의 예로 JSTL(JSP Standard Tag Library) 태그 라이브러리가 있다.<br>
또한 개발자가 추가로 정의한 태그를 가져올 때도 사용한다.<br> 
<pre class="jsp">
&lt;%@ taglib  uri="URL" prefix="네임스페이스명"%>
</pre>

<p>
외부 태그 라이브러리를 사용할 때는<br>
그 태그들을 정의한 그 라이브러리 파일(.jar)을 가져와야 한다.
</p>

</body>
</html>






