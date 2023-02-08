<%@page import="com.mvc.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> boardList=(List<Board>)request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
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
	function regist(){
		$("#form1").attr({
			action:"/board/regist.do",
			method:"post"
		});
		$("#form1").submit();
	}

	$(function(){
		$("#bt_regist").click(function(){
			regist();
		});
		
		
		// 사원 페이지 넘어가기 
		$("#bt_emp").click(function(){
			$(location).attr("href","/emp/regist.jsp");
		});
	})

</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>NO</th>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0; i<boardList.size(); i++){ %>
				<%Board board=boardList.get(i); %>
				<tr>
					<td><%=i %></td>
					<td><a href="/board/detail.do?board_idx=<%=board.getBoard_idx() %>"><%=board.getTitle() %></a></td>
					<td><%=board.getWriter() %></td>
					<td><%=board.getContent() %></td>
					<td><%=board.getRegdate() %></td>
					<td><%=board.getHit() %></td>
				</tr>
				<%} %>
				<tr>
					<td>
						<div class="col">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registModal">글등록 </button>
							<button type="button" class="btn btn-success" id="bt_emp">사원등록</button>						
						</div>
					</td>
				</tr>
			</tbody>
		</table>

		<!-- The Modal -->
		<div class="modal fade" id="registModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Modal Heading</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form id="form1">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Enter title" name="title">
							</div>
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Enter writer" name="writer">
							</div>
							<div class="form-group">
								<textarea class="form-control" name="content">Enter content</textarea>
							</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-success" id="bt_regist">등록</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>


	</div>
</body>
</html>