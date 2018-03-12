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

<h1>게시물 상세정보</h1>

<c:if test="${not empty board}">
        <form action='update.do' method='post'>
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
                name='no' value='${board.no}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='title' class='col-sm-2 col-form-label'>제목</label>
        <div class='col-sm-10'>
        <input class='form-control' id='title' type='text' 
                name='title' value='${board.title}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='content' class='col-sm-2 col-form-label'>내용</label>
        <div class='col-sm-10'>
        <textarea class='form-control' id='content' 
                    name='content'>${board.content}</textarea>
        </div>
        </div>
        <div class='form-group row'>
        <label for='regdate' class='col-sm-2 col-form-label'>등록일</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='regdate' type='date' 
                value='${board.regDate}'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='viewcnt' class='col-sm-2 col-form-label'>조회수</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='viewcnt' type='number' 
                value='${board.viewCount}'>
        </div>
        </div>
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete.do?no=${board.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
        </form>
</c:if>
<c:if test="${empty board}">
        <p>'${param.no}'번 게시물이 없습니다.</p>
</c:if>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>
