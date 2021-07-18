<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexPage</title>
</head>
<body>
	<div>
		<!-- Top Start-->
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
		<!-- Top END-->
	</div>
	<div>
		<a href="/board/boardIndex.do">게시판으로 가기</a>
	</div>
	<div>
		<a href="/mail/mailPage.do">메일 발송 하기</a>
	</div>
</body>
</html>