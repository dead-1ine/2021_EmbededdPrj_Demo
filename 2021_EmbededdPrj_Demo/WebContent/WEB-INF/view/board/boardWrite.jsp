<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWritePage</title>
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">
<style type="text/css">
.area{
	text-align: center;
	width: 
}
.inputTitle {
	color: black;
	
}
.contents{
	color: black;
	padding: 10px;
}
</style>
</head>
<body>
	<div>
		<!-- Top Start-->
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
		<!-- Top END-->
	</div>
	
<h1 style="text-align: center;">Board</h1>
<div class="area">
	<div class="divTable">
		<!-- 테이블 머리 -->
		<div class="divTableHead">게시글 등록</div>
		<!--테이블 바디-->
		<div class="divTableBody">
			<!-- 테이블 로우 -->
			<div class="divTableRow" id="rowBgColor">
				<div class="divTableCell" class="no">
					<form action="/board/boardWriteProc.do" class="boardWriteAction">
						<div class="inputTitle">제목 : <input type="text" id="title" name="title"></div>
						<div class="contentsStyle"><textarea id="contents" name="contents" rows="20" cols="50">내용을 작성해주세요</textarea></div>
						<input type="submit" value="완료">  
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>