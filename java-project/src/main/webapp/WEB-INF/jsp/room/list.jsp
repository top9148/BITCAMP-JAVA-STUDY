<%@page import="java100.app.domain.Room"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>강의실관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>강의실 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>지역</th><th>강의실명</th><th>수용인원</th><th>삭제</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="room">
        <tr>
        <td>${room.no}</td>
        <td>${room.location}</td>
        <td>${room.name}</td>
        <td>${room.capacity}</td>
        <td><a href='delete?no=${room.no}' class='btn btn-danger btn-sm'>삭제</a></td>
        </tr>
</c:forEach>

</tbody>
</table>

<jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
