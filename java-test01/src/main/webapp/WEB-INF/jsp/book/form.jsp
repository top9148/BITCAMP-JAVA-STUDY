<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>도서관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>새 게시물</h1>

<form action="add" method='post' enctype="multipart/form-data">

<div class='form-group row'>
<label for='title' class='col-sm-2 col-form-label'>도서명</label>
<div class='col-sm-10'>
<input class='form-control' id='title' type='text' name='title'>
</div>
</div>

<div class='form-group row'>
<label for='description' class='col-sm-2 col-form-label'>설명</label>
<div class='col-sm-10'>
<textarea class='form-control' id='description' name='description'></textarea>
</div>
</div>

<div class='form-group row'>
<label for='price' class='col-sm-2 col-form-label'>가격</label>
<div class='col-sm-10'>
<input class='form-control' id='price' type='number' name='price'>
</div>
</div>

<div class='form-group row'>
<label for='press' class='col-sm-2 col-form-label'>출판사</label>
<div class='col-sm-10'>
<input class='form-control' id='press' type='text' name='press'>
</div>
</div>

<div class='form-group row'>
<label for='publishedDate' class='col-sm-2 col-form-label'>출판일</label>
<div class='col-sm-10'>
<input class='form-control' id='publishedDate' type='date' name='publishedDate'>
</div>
</div>

<div class='form-group row'>
<label for='file' class='col-sm-2 col-form-label'>사진</label>
<div class='col-sm-10'>
<input type="file" class="form-control-file" id="file" name="file">
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    