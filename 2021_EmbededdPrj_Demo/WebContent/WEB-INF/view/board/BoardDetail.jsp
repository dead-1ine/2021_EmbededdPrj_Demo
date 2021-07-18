<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="poly.util.CmmUtil" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.BoardDTO"%>

<!DOCTYPE html>
<html>
<%
	BoardDTO rDTO = (BoardDTO)request.getAttribute("rDTO");
	String user_id = (String)session.getAttribute("id");
%>
<head>
<meta charset="UTF-8">
<title>BoardDetailPage</title>
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">
<!-- 적용방법 1 -->
<!--  <script src="js/jquery.js"></script> -->
<!-- 적용방법 2 : cdn -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 적용방법 3 제이 쿼리 제공 최신 버전-->
<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<style type="text/css">
.area{
	text-align: center;
	width: 
}
.inputTitle {
	color: black;
	
}
.contentsStyle{
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
<h1 style="text-align: center;">BoardDetail</h1>
<div class="area">
	<div class="divTable">
		<!-- 테이블 머리 -->
		<div class="divTableHead">게시글 상세보기</div>
		<!--테이블 바디-->
		<div class="divTableBody">
			<!-- 테이블 로우 -->
			<div class="divTableRow" id="rowBgColor">
				<div class="divTableCell" class="no">
					<form action="/board/boardUpdate.do" class="boardWriteAction" name="f" onsubmit="return regIdCheck(this);">
						<div class="inputTitle">제목 : <input type="text" id="title" name="title" value="<%=rDTO.getTitle() %>"></div>
						<div style="color:black;" id="reg_id" class="reg_id">작성자 : <%=rDTO.getReg_id() %></div>
						<div class="contentsStyle"><textarea id="contents" name="contents" rows="20" cols="50"><%=rDTO.getContents() %></textarea></div>
						<input type="submit" value="수정하기">  
						<input type="button" value="삭제하기" onclick="JavaScript:authCheck();">  
						<input type="hidden" id="sessionId" name="user_sessionid" value="<%=user_id %>"/>
						<input type="hidden" id="no" name="no" value="<%=rDTO.getNo() %>"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
<script type="text/javascript">
	// 사용자 수정 권한 확인 서버 측 사용자 세션과 작성자 비교하여 함
	// 언어 전처리 확실하게 해줘야 한다!!!!!! 중요
	function regIdCheck(f) {
		let idValue = $('#reg_id').text(); // 작성자 : 이름
		let res = idValue.split(":"); // : 기준으로 잘라서 배열에 담음
		let user_id = $("#sessionId").val().trim(); // 세션에 있는 아이디 가져와서 공백 제거
		let reg_id = res[1].trim(); // 배열 1번 인덱스에 값 가쟈와서 공백 제거
				
		console.log(user_id)
		console.log(reg_id)
		console.log("진입")
		
		if(reg_id != user_id){
			alert("수정 권한이 없습니다.");
			return false;
		}
	}
	
	// ajax로 삭제 권한 확인 하기
	function authCheck() {
		let idVal = $('#reg_id').text();
		let res = idVal.split(":");
		let reg_id = res[1].trim();
		let no = $("#no").val().trim();
		
		console.log(reg_id);
		console.log(no);
		
		if(reg_id == ""){
			return false;
		}
		
		console.log("아작스 진입");
		
		$.ajax({
			url : '/board/boardDelete.do', // 컨트롤러 주소
			type : 'GET', // 전송 방식
			data : {reg_id : reg_id, no : no}, // JSON 형태로 key : value 로 넘어감
			success : function (data) { // 통신 성공시 data 부분에 데이터 반환 됨\
				console.log(data);
				if(data == "noAuth"){
					alert("권한이 없습니다.");
				} else{
					alert("삭제 완료 새로고침을 해주세요");
				}
			}
		})
	}
</script>
</html>