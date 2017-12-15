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
<h1>jsp:setProperty, jsp:getProperty</h1>
객체에 대해 셋터/겟터 메서드를 호출할 때 사용한다.<br>
단 객체는 로컬 변수가 아닌 보관소에 저장되어 있어야 한다.<br>

<h2>JSP 코드</h2>
<pre class="jsp">
&lt;jsp:setProperty name="member" property="name" value="홍길동"/>
</pre>

<h2>자바 코드</h2>
<pre class="java">
member.setName("홍길동");
</pre>

</body>
</html>






