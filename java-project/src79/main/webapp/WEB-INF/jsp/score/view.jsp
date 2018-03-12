<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>성적 상세 정보</h1>

<c:if test="${not empty score}">
        <form action='update' method='post'>
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
               name='no' value='${score.no}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='name' class='col-sm-2 col-form-label'>이름</label>
        <div class='col-sm-10'>
        <input class='form-control' id='name' type='text' 
               name='name' value='${score.name}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='kor' class='col-sm-2 col-form-label'>국어</label>
        <div class='col-sm-10'>
        <input class='form-control' id='kor' type='number' 
               name='kor' value='${score.kor}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='eng' class='col-sm-2 col-form-label'>영어</label>
        <div class='col-sm-10'>
        <input class='form-control' id='eng' type='number' 
                name='eng' value='${score.eng}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='math' class='col-sm-2 col-form-label'>수학</label>
        <div class='col-sm-10'>
        <input class='form-control' id='math' type='number' 
                name='math' value='${score.math}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='sum' class='col-sm-2 col-form-label'>합계</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='sum' type='text' 
                value='${score.sum}'> 
        </div>
        </div>
        <div class='form-group row'>
        <label for='aver' class='col-sm-2 col-form-label'>평균</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='aver' type='text' 
                value='<fmt:formatNumber value="${score.aver}" pattern=".0"/>'> 
                    
        </div>
        </div>
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${score.no}' class='btn btn-primary btn-sm'>삭제</a> 
        </div>
        </div>
        </form>
</c:if>
<c:if test="${empty score}">
        <p>'${param.no}'의 성적 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
