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
<h1>ServletContext 보관소</h1>
웹 애플리케이션이 시작될 때 생성된다.<br>
웹 애플리케이션이 종료될 때 제거된다.<br>
웹 애플리케이션이 실행되는 동안 공유할 데이터는 이 보관소에 저장한다.<br>
보통 여러 서블릿/JSP에서 공통으로 사용하는 객체를 주로 저장한다.<br> 
 
<%
application.setAttribute("name", "홍길동");
%>
<hr>
<p>
<jsp:include page="test05_p2.jsp"></jsp:include>
</p>
<hr>
<%=application.getAttribute("name")%>

</body>
</html>






