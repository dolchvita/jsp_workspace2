<%@page import="com.mvc.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Emp> empList=(List<Emp>)request.getAttribute("empList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
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
	function del(){
		$("#form1").attr({
			action:"/emp/delete.do",
			method:"post"
		});
		$("#form1").submit();
	}

	$(function(){
		$("#bt_del").click(function(){
			if(confirm("삭제하시겠습니까?")){
				del();
			}
		});
	});
</script>
</head>
<body>
<div class="container m-3">
		<div class="row">
			<div class="col">
			
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>No</th>
							<th>삭제여부</th>
							<th>부서명</th>
							<th>사원명</th>
							<th>급여</th>
						</tr>
					</thead>
					<tbody>
						<form id="form1">
							<%for(Emp emp:empList){ %>
								<tr>
									<td><%=emp.getEmpno() %></td>
									<td>
										<input type="checkbox" name="empno" value="<%=emp.getEmpno()%>">
									</td>
									<td><%=emp.getDept().getDname() %></td>
									<td><%=emp.getEname() %></td>
									<td><%=emp.getSal() %></td>
								</tr>
							<% }%>
						</form>
						<tr>
							<td>
								<button type="button" class="btn btn-outline-danger" id="bt_del">삭제</button>
							</td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>