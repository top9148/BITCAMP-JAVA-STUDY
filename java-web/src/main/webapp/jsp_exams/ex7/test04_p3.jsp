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
<h1>HttpServlet 보관소 II</h1>
요청이 다르더라도 같은 클라이언트라면 같은 세션을 사용하기 때문에,<br>
이전 요청 때 저장한 데이터를 꺼낼 수 있다.<br>

<%=session.getAttribute("name")%>

</body>
</html>






