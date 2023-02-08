<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#board_submenu li{
  list-style-type: none;
  margin-top:10px;
}
#board_submenu a{  
  text-decoration: none;
}
</style>
</head>
<body>
<ul  id="board_submenu">
  <li onclick="window.open('/list','sectionFrame')"><a href="#">목록</a></li>
  <li onclick="window.open('/prepare_add','sectionFrame')"><a href="#">새글</a></li>
</ul>
</body>
</html>