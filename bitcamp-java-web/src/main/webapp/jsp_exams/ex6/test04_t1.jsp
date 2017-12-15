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
<h1>jsp:setProperty 테스트</h1>
셋터 호출하기

<%
// 객체 생성
domain.Member m = new domain.Member();
%>

<%-- 보관소에 저장하지 않았기 때문에 NullPointerException 발생! --%>
<jsp:setProperty name="m" property="name" value="홍길동"/>

<h2>Member 객체 내용</h2>
<%=m.toString()%>

</body>
</html>






