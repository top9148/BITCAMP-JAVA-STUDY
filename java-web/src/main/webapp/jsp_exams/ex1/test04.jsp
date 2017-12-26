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
<h1>템플릿 데이터</h1>
<p>JSP 파일에 그냥 작성하는 모든 텍스트는 자바의 출력 코드로 만들어진다.</p>
<%-- JSP 페이지에 주석을 넣고 싶은가? 이렇게 하라!
이것은 자바 소스 코드로 바뀌지 않는다. 그냥 버려진다. --%>
<!-- 근데 간혹가다가 개발자가 이렇게 주석을 다는 경우가 있다.
이것은 HTML 주석으로 웹브라우저가 무시하는 것이다. 
JSP 엔진 입장에서는 그냥 템플릿 데이터일 뿐이다.
따라서 웹브라우저로 출력하기 위해 출력문으로 바꾼다.
그러니 JSP에 주석을 넣고 싶으면 이렇게 하지 말라! -->
<h2>JSP 코드</h2>
<pre class="jsp">
안녕하세요!
JSP에 오신 걸 환영합니다.
</pre>

<h2>생성된 자바 코드</h2>
<pre class="java">
out.write("안녕하세요!\n");
out.write("JSP에 오신 걸 환영합니다.\n");
</pre>
</body>
</html>






