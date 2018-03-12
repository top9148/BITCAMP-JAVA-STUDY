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
	   <fb:login-button scope="public_profile,email" 
	                    onlogin="checkLoginState();">
       </fb:login-button>
	</div>
</div>

</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

<script type="text/javascript">
function autoServerLogin(accessToken) {
    location.href = "facebookLogin?accessToken=" + accessToken;
}

function statusChangeCallback(response) {
  console.log(response);

  if (response.status === 'connected') { // 로그인이 정상적으로 되었을 때,
      autoServerLogin(response.authResponse.accessToken);
  
  } else { // 로그인이 되지 않았을 때,
      console.log("로그인 되지 않았음");
  }
}
  
function checkLoginState() {
    FB.getLoginStatus(function(response) { 
      statusChangeCallback(response);
    });
}

window.fbAsyncInit = function() {
  FB.init({
    appId      : '1207028086096146', // 개발자가 등록한 앱 ID
    cookie     : true,  
    xfbml      : true,  
    version    : 'v2.12' 
  });
};

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>



</body>
</html>
    