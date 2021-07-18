<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="poly.util.CmmUtil" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.BoardDTO"%>

<!DOCTYPE html>
<html>
<%
	List<BoardDTO> rList = (List<BoardDTO>)request.getAttribute("rList");
    int count = 1;
%>
<head>
<meta charset="UTF-8">
<title>BoardMainPage</title>
<style>
        .divTable{
        display: table; width: 100%;
        text-align: center;
        color : white;
        }
        .divTableRow {
        display: table-row;
        }
        .divTableHeading {
        background-color: #EEE; display: table-header-group;
        }
        /*./divTableHead 랑 .divTableCell 의 스타일이 같아야 안깨짐 */
        .divTableHead{
        border: 1px solid #999999; display: table-cell; padding: 3px 10px; background-color: black;
        } 
        .divTableCell{
        border: 1px solid #999999; display: table-cell; padding: 3px 10px; color: black;
        }
        /*./divTableHead 랑 .divTableCell 의 스타일이 같아야 안깨짐 */
        .divTableHeading {
        background-color: #EEE; display: table-header-group; font-weight: bold;
        }
        .divTableFoot { background-color: #EEE; display: table-footer-group; font-weight: bold;
        }
        .divTableBody {
        display: table-row-group
        }

</style>
</head>
<body>
	<div>
		<!-- Top Start-->
		<%@ include file="/WEB-INF/view/user/top.jsp"%>
		<!-- Top END-->
	</div>
<h1>게시판 입니다.</h1>
<div class="area">
<button type="button" onclick="location.href='/board/boardWrite.do'">새 글 쓰기</button>
<!-- <button type="button" onclick="location.href='/board/boardWrite.jsp'">글 쓰기</button> --> <!-- 바로 JSP 이동 불가 -->
<button type="button" onclick="location.href='/main/index.do'">메인 이동</button>
	<div class="divTable" style="">
		<!-- 테이블 머리 -->
		<div class="divTableHead">구분</div>
		<div class="divTableHead">게시판 ID</div>
		<div class="divTableHead">제목</div>
		<div class="divTableHead">작성자</div>
		<div class="divTableHead">작성일자</div>
		<div class="divTableHead">수정일자</div>
		<!--테이블 바디-->
		<% for(BoardDTO e : rList){ %>
		<div class="divTableBody">
			<!-- 테이블 로우 -->
			<div class="divTableRow" id="rowBgColor" onclick="location.href='/board/boardDetail.do?no=<%=e.getNo() %>'">
				<div class="divTableCell" class="count"><%=count++%></div>
				<div class="divTableCell" class="no"><%=e.getNo() %></div>
				<div class="divTableCell" class="title"><%=e.getTitle() %></div>
				<div class="divTableCell" class="reg_user"><%=e.getReg_id()%></div>
				<div class="divTableCell" class="reg_dt"><%=e.getReg_dt() %></div>
				<div class="divTableCell" class="cng_dt"><%=e.getChg_dt() %></div>
			</div>
		</div>
		<%} %>
	</div>
</div>
</body>
</html>