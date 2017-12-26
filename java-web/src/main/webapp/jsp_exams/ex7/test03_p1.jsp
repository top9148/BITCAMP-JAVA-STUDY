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
<h1>ServletRequest 보관소</h1>
요청을 들어오면 생성되고 응답을 완료하면 제거된다.<br>
요청을 처리하는 동안에 공유할 데이터를 보관한다.<br>

<%
request.setAttribute("name", "홍길동");
%>
<hr>
<p>
<jsp:include page="test03_p2.jsp"></jsp:include>
</p>
<hr>
<%=request.getAttribute("name")%>

</body>
</html>






