<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/layout.css">
<style>
	#submenu{
		height:700px;
		weight:100px;
		float:left;
		padding:10px;
		background-color:#9999ff;
	}
</style>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/views/menu/navigation_bar.jsp"/>
	</div>
	<div id="submenu">
		<jsp:include page="/WEB-INF/views/menu/board_submenu.jsp"></jsp:include>
	</div>
	<div id="footer">
		<jsp:include page="/WEB-INF/views/menu/footer.jsp"/>
	</div>
</body>
</html>