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
<h1>jsp:useBean 테스트 II</h1>
인스턴스 꺼내기.

<jsp:useBean id="list" type="java.util.ArrayList"/>

<%--
// PageContext 보관소에서 객체를 찾는다. 
java.util.ArrayList list = pageContext.getAttribute("list");

// 없으면 예외를 발생시킨다.
if (list == null) {
    throw new Exception("객체 없네요..");
}
--%>


</body>
</html>






