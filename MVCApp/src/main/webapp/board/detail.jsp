<%@page import="com.mvc.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board board=(Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	function list(){
		$(location).attr("href","/board/list.do");
	}

	$(function(){
		$("#bt_edit").click(function(){
			edit();
		});
		$("#bt_list").click(function(){
			list();
		});
	});
</script>
</head>
<body>
	<div class="container m-5">
		<form id="form1">
			<div class="form-group">
				<input type="text" name="title" class="form-control" value="<%=board.getTitle()%>">
			</div>
			<div class="form-group">
				<input type="text" name="writer" class="form-control" value="<%=board.getWriter()%>">
			</div>
			<div class="form-group">
				<textarea type="text" name="content" class="form-control"><%=board.getContent() %></textarea>
			</div>
		</form>
		<div class="form-group">
			<button type="button" class="btn btn-info" id="bt_edit">수정</button>
			<button type="button" class="btn btn-danger" id="bt_del">삭제</button>
			<button type="button" class="btn btn-success" id="bt_list">목록</button>
		</div>
	</div>
</body>
</html>