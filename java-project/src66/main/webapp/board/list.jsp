<%@page import="java100.app.domain.Board"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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

<h1>게시물 목록</h1>

<p><a href='form.do' class='btn btn-primary btn-sm'>추가</a></p>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>등록일</th><th>조회수</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="board">
        <tr>
        <td>${board.no}</td>
        <td><a href='view.do?no=${board.no}'>${board.title}</a></td>
        <td>${board.regDate}</td>
        <td>${board.viewCount}</td>
        </tr>
</c:forEach>

</tbody>
</table>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>
    