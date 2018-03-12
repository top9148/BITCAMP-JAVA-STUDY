<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>로그인</h1>

<form action="login" method='post'>

<div class='form-group row'>
	<label for='email' class='col-sm-2 col-form-label'>이메일</label>
	<div class='col-sm-10'>
	<input class='form-control' id='email' type='text' 
	       name='email' value='${cookie.email.value}'>
	</div>
</div>

<div class='form-group row'>
	<label for='password' class='col-sm-2 col-form-label'>암호</label>
	<div class='col-sm-10'>
	<input class='form-control' id='password' type='password' name='password'>
	</div>
</div>

<div class='form-group row'>
	<div class="col-sm-2"></div>
	<div class="col-sm-10">
	  <div class="form-check">
	    <input type="checkbox" class="form-check-input"
	           id="saveEmail" name="saveEmail">
	    <label class="form-check-label" for="saveEmail">이메일 저장</label>
	  </div>
	</div>
</div> 

<div class='form-group row'>
	<div class='col-sm-10'>
	<button class='btn btn-primary btn-sm'>로그인</button>
	</div>
</div>

</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    