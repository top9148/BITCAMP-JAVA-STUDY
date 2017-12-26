<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="/header.jsp"/>

<h1>게시물 변경 결과</h1>
<jsp:useBean id="count" type="java.lang.Integer" scope="request"></jsp:useBean>
<%
try {
    if (count > 0) {%>
        <p>변경하였습니다.</p>
<%
    } else {%>
        <p>'${param.no}'번 게시물이 없습니다.</p>
<%
    }
} catch (Exception e) {
    e.printStackTrace(); // for developer%>
    <%=e.getMessage() %>
<%
}%>
<p><a href='list' class='btn btn-primary btn-sm'>목록</a></p>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>