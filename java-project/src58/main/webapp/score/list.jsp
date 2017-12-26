<%@page import="java100.app.domain.Score"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="/header.jsp"/>

<h1>성적 목록</h1>

<p><a href='form' class='btn btn-primary btn-sm'>추가</a></p>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>합계</th><th>평균</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="java.util.List<Score>" scope="request"></jsp:useBean>
<%
try {
    for (Score score : list) {
        pageContext.setAttribute("score", score);
%>
    <tr>
        <td>${score.no}</td>
        <td><a href='view?no=${score.no}'>${score.name}</a></td>
        <td>${score.sum}</td>
        <td>${score.aver}</td>
    </tr>
<%
    }
    
} catch (Exception e) {
    e.printStackTrace(); // for developer%>
    <%=e.getMessage()%>
<%
}%>

</tbody>
</table>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>











