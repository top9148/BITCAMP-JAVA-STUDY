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
<h1>HttpSession 보관소</h1>
클라이언트 요청이 최초로 들어왔을 때 생성된다.<br>
타임아웃으로 지정된 시간동안 클라이언트 요청이 없으면 제거된다.<br>
또는 명시적으로 세션을 무효화시킬 때 제거된다.<br>
같은 클라이언트일 경우 요청이 다르더라도 세션을 공유한다.<br>
즉 클라이언트 당 한 개의 세션이 생성된다.<br>
클라이언트의 기준? 웹 브라우저이다.<br>
한 사람이 서로 다른 브라우저를 여러 개 띄워 같은 웹서버에 접속한다면,<br>
그 개수만큼 세션이 생성된다.<br>
그러나 같은 브라우저를 여러 개 띄우고 웹서버에 접속한다면,<br>
같은 클라이언트로 인식하여 세션한 한 개만 생성된다.<br>
 
<%
session.setAttribute("name", "홍길동");
%>
<hr>
<p>
<jsp:include page="test04_p2.jsp"></jsp:include>
</p>
<hr>
<%=session.getAttribute("name")%>

</body>
</html>






