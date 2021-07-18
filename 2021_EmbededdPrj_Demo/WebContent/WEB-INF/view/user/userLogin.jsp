<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<style type="text/css">
.astyle{
	padding: 20px;
}
</style>	
</head>
<body>
	<div>
		<!-- Top Start-->
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
		<!-- Top END-->
	</div>
	<div>
		로그인 화면
		<form action="/user/userLoginProc.do" method="post">
			<div>
				아이디 : <input type="text" name="id"> 
			</div>
			<div>
				비밀번호 : <input type="text"name="pwd">
			</div>
			<div>
				<button type="submit">로그인</button>
			</div>
		</form>
	</div>
	<div class="astyle">
		<a href="/kakaoLoginProc.do" > <img src="/resources/image/kakao_login_medium_narrow.png"></a>
	</div>
</body>
