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
<h1>ServletRequest 보관소 II</h1>
요청이 다르면 ServletRequest도 다르기 때문에 데이터를 공유할 수 없다.<br>

<%=request.getAttribute("name")%>

</body>
</html>






