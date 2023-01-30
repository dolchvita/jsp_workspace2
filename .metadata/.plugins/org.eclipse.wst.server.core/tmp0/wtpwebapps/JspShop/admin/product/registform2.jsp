<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] sizeList={"XS","S","M","L","XL","XXL"};
	String[] colorList={"베이지","네이비","브라운","블랙"};
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>상품 등록 </title>
<%@ include file="/admin/inc/header_link.jsp" %>
  </head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">



<%@ include file="/admin/inc/preloader.jsp" %>
<%@ include file="/admin/inc/navbar.jsp" %>

  <!-- Main Sidebar Container -->
<%@ include file="/admin/inc/sidebar_left.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    
	<!-- content -->
	<section class="content">
		<div class="container-fluid">
			<div class="col">

				<div class="form-group">
					<select class="form-control" id="category_idx"></select>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="product_name" placeholder="상품명">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="brand" placeholder="브랜드">
				</div>
				<div class="form-group">
					<input type="number" class="form-control" id="price" placeholder="가격">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="discount" placeholder="할인가">
				</div>


				<div class="form-group">
					<%for(int i=0; i<sizeList.length; i++){ %>
					<div class="icheck-primary d-inline">
						<input type="checkbox" id="size<%=i %>" name="size" value="<%=sizeList[i]%>">
						<label for="size<%=i%>"><%=sizeList[i]%></label>
					</div>
					<%} %>
				</div>

				<div class="form-group">
					<%for(int i=0; i<colorList.length; i++){ %>
					<div class="icheck-primary d-inline">
						<input type="checkbox" id="color<%=i %>" name="color" value="<%=colorList[i]%>">
						<label for="color<%=i%>"><%=colorList[i]%></label>
					</div>
					<%} %>
				</div>


				<div class="form-group">
                  <textarea id="detail" class="form-control" ></textarea>
            	</div>

				<div class="form-group">
					<input type="file" id="file" multiple>
				</div>
						
				<!-- 미리보기 이미지 -->
				<div class="row form-group" id="preview">
					이미지 나올곳
				</div>

				<div class="form-group">
						<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
						<button type="button" class="btn btn-primary" id="bt_list">목록</button>
				</div>

			</div>
		</div>
	</section>
	<!-- ./content-->


		</div>
  <!-- /.content-wrapper -->
  
<%@ include file="/admin/inc/footer.jsp" %>

  <!-- Control Sidebar -->
<%@ include file="/admin/inc/sidebar_right.jsp" %>

  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<%@ include file="/admin/inc/footer_link.jsp" %>

<script type="text/javascript">
	function regist(){
		let formData = new FormData();
		
		formData.append("category_idx", $("#category_idx").val());
		formData.append("product_name", $("#product_name").val());
		formData.append("brand", $("#brand").val());
		formData.append("price", $("#price").val());
		formData.append("discount", $("#discount").val());
		
		// 체크박스 배열화해서 보내기!
		let sizeCheckArray=[];
		for(let i=0; i<$("input[name='size']").length; i++){
			if($($("input[name='size']")[i]).is(":checked")){
				sizeCheckArray.push($($("input[name='size']")[i]).val());
			}
		}
		// 모아 놓은 배열 보내기! 파라미터 이름은 배열로 지정 !
		formData.append("size[]", sizeCheckArray);
		
		// jQuery 
		let colorCheckArray=[];
		$.each($("input[name='color']:checked"), function(){
			colorCheckArray.push($(this).val());
		});
		formData.append("color[]", colorCheckArray);
		
		formData.append("detail", $("#detail").val());
		
		$.ajax({
			url:"/admin/product/regist2.jsp",
			type: "POST",
			
			// 바이너리 파일 보낼 때 세팅!
			processData:false,
			contentType:false,
			data:formData,
			
			success:function(result, status, xhr){
				console.log("응답 "+result);
			}
		});
	}
</script>
<script type="text/babel">
	let tag=[];	
	let previewRoot;
	let fileList=[];
	let oriFiles=[];

	function ImgBox(props){
		return(
			<div className="col-sm-2 border">
				<div>
					<a href="#" onClick={(e)=>removeImg(e, props.index)}>X</a>
				</div>
				<img src={props.src} width='100px'/>
			</div>
		);
	}


	function removeImg(e, index){
		$(e.target).parent().parent().remove();

		let file=oriFiles[index];
		let sel_index=oriFiles.indexOf(file);

		// 구한 순번으로 배열 요소 삭제 
		oriFiles.splice(sel_index, 1);
	}


	function createCategoryOption(result){
		console.log(result);
		let op="<option value='0'>상품분류</option>";
		
		for(let i=0; i<result.length;i++){ //json 배열만큼 반복
			
			let category=result[i];		//카테고리 하나 꺼내기
			op+="<option value='"+category.category_idx+"'>"+category.category_name+"</option>";
		}
		$("#category_idx").html(op);								
	}


	function getCategoryList(){
		$.ajax({
			url:"/admin/category/category_list.jsp",
			type:"GET",
			success:function(result, status, xhr){
				//옵션 채우기 
				createCategoryOption(result);
			}
		});
	}
	
	function previewImg(){
		for(let i=0; i<fileList.length; i++){
			let reader=new FileReader();

			reader.onload=function(e){
				tag.push(<ImgBox key={i} src={e.target.result} index={i} />);

				if(i>=(fileList.length-1)){
					previewRoot.render(tag);
				}
			}
			reader.readAsDataURL(fileList[i]);
		}
	}

	$(function(){
		// 리액트 객체 생성
		previewRoot=ReactDOM.createRoot(document.getElementById("preview"));
		getCategoryList();

		
		$("#file").change(function(){
			oriFiles=fileList;			

			for(let i=0; i<this.files.length; i++){
				fileList.push(this.files[i]);
			}
			previewImg();
			
		});

		$("#bt_regist").click(function(){
			regist();
		});

		$("#bt_list").click(function(){
			$(location).attr("href","/admin/product/list.jsp");
		});
		
	});

</script>

</body>
</html>
    