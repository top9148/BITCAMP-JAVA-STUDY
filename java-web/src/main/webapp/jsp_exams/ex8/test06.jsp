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
<h1>EL(Expression Language) 사용법</h1>
OGNL 표기법을 이용하여 자바 객체의 프로퍼티 값을 꺼내는 문법이다.<br>
OGNL(Object Graph Navigation Language) 이란?<br>
점(.)이나 대괄호([]) 등을 이용하여 객체의 변수 값을 쉽게 꺼내게 해주는 문법이다.

<%
application.setAttribute("name2", "임꺽정");
session.setAttribute("name2", "홍길동");
request.setAttribute("name2", "유관순");
pageContext.setAttribute("name2", "김구");
%>

<h2>보관소를 지정하지 않고 값 꺼내기</h2>
먼저 PageContext에서 찾는다.<br>
없으면, ServletRequest에서 찾는다.<br>
없으면, HttpSession에서 찾는다.<br>
없으면, ServletContext에서 찾는다.<br>
즉 가장 가까운 보관소에서 먼저 찾는다.<br>

<p>${name2}</p>
<p>PageContext: ${pageScope.name2}</p>
<p>ServletRequest: ${requestScope.name2}</p>
<p>HttpSession: ${sessionScope.name2}</p>
<p>ServletContext: ${applicationScope.name2}</p>

</body>
</html>






