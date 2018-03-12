<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
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
<form action="add" method='post'>
<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>
<div class='form-group row'>
<label for='kor' class='col-sm-2 col-form-label'>국어</label>
<div class='col-sm-10'>
<input class='form-control' id='kor' type='number' name='kor'>
</div>
</div>
<div class='form-group row'>
<label for='eng' class='col-sm-2 col-form-label'>영어</label>
<div class='col-sm-10'>
<input class='form-control' id='eng' type='number' name='eng'>
</div>
</div>
<div class='form-group row'>
<label for='math' class='col-sm-2 col-form-label'>수학</label>
<div class='col-sm-10'>
<input class='form-control' id='math' type='number' name='math'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button id="submitBtn" class='btn btn-primary btn-sm'>추가</button>
</div>
</div>
</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

<script src='../../node_modules/jquery/dist/jquery.min.js'></script>
<script type="text/javascript">
var korItem = $('#kor'),
    engItem = $('#eng'),
    mathItem = $('#math');

$('#submitBtn').click((event) => {
    /*
    if (korItem.val() == "" || engItem.val() == "" || mathItem.val() == "") {
        alert("국어, 영어, 수학 점수는 필수 입력 항목입니다!");
        event.preventDefault();
    }
    */
});

</script>





</body>
</html>











    