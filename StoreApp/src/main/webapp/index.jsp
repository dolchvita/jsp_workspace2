<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구글맵 메인</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
	#map{
		width:100%;
		height:100%;
	}
</style>

<script>
	// 비동기로 응답객체를 받을 전역변수!
	let xhttp;
	
	// 마커 생성을 위해서는 map이 전역변수로 지정되어 있어야 한다! 
	let map;
	
	function createOption(categoryList){
		let op="<option value='0'>선택하시오</option>"
		for(let i=0; i<categoryList.length; i++){
			let category=categoryList[i];
			op+="<option value='"+category.category_idx+"'>"+category.category_name+"</option>"
		}		
		$("#category_idx").html(op);
	}
	
	
	function getCategoryList(){
		xhttp=new XMLHttpRequest();
		xhttp.open("GET", "/store/category_list.jsp");
		xhttp.send();		// 호스팅 환경인 크롬브라우저가 요청 시작! 
		
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				
				// 문자열에 불과한 데이터를 파싱하여 실제 JSON 내장객체로 변환
				 // console.log(this.responseText);
				let categoryList=JSON.parse(this.responseText);
				
				createOption(categoryList);
			}
		}
	}
	
	
	// 이를 바탕으로 좌표 찍기!!
	function createMaker(map, storeList){
		// 내가 가지고 있는 실제 상품의 리스트를 가져와서 위도,경도를 표시하자!
		for(let i=0; i<storeList.length; i++){
			let store=storeList[i];
			//console.log("스토어! "+store.lati);
			//console.log("스토어! "+store.longi);
			
			var mapProp = {
    			center:new google.maps.LatLng(store.lati, store.longi),
    			zoom:15,
			};
			var marker = new google.maps.Marker({position: mapProp.center});
			marker.setMap(map);
		}
	}
	
	
	// 이미 입력 되어있는 store_list 가져오기
	function getStoreList(){
		xhttp=new XMLHttpRequest();
		xhttp.open("get",  "/store/store_list.jsp");
		xhttp.send();
		
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				//console.log(this.responseText);
				let storeList=JSON.parse(this.responseText);
				createMaker(map, storeList);
			}
		}
	}
	
	
	
	// 구글맵 출력하기
	function loadMap(){
		var mapProp = {
				center : new google.maps.LatLng(37.556436, 126.945207),
				zoom : 15,
		};
		map = new google.maps.Map(document.getElementById("map"),mapProp);
	}
	
	
	// 비동기로 데이터 전송하기
	function regist(){
		xhttp=new XMLHttpRequest();
		xhttp.open("post", "/store/regist.jsp");
		
		// 기본 텍스트만 보내더라도 헤더에 컨텐트 타입을 명시한다!
		xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		// 데이터 모아서 전송하기
		let data="lati="+$("input[name='lati']").val();
		data+="&longi="+$("input[name='longi']").val();
		data+="&store_name="+$("input[name='store_name']").val();
		data+="&category_idx="+$("#category_idx").val();
		/* 파라미터 변수명을 지정할 때는 앞에 &를 붙인다! (첫 번째 제외)*/

 		xhttp.onreadystatechange=function(){
			if(this.readystate==4&&this.status==200){
				
				console.log("등록결과는 "+this.responseText);
			}
		}
		xhttp.send(data);
	}
	
	
	$(function(){
		$("#bt_regist").click(function(){
			regist();
		})
		
		getCategoryList();
		getStoreList();
	});
	
</script>

</head>
<body>
	<div class="container">
		<div class="row mt-2">
		
			<!-- 좌측 영역 -->
			<div class="col-md-3 border">
			
				<div class="form-group">
					<input type="text" class="form-control" placeholder="위도" name="lati">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="경도" name="longi">
				</div>
				
				<div class="form-group">
					<!-- 하위 카테고리에 입력시 들어갈 pk값을 정하기 때문에 idx라고 지정 -->
					<select class="form-control" id="category_idx"></select>
				</div>
				
				<div class="form-group">
					<input type="text" class="form-control" placeholder="상호명" name="store_name">
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-outline-danger" id="bt_regist">등록</button>
				</div>
				
				<div>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>상호명</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>zino</td>
							</tr>
						</tbody>
					</table>	
				</div>
				
			</div>
			
			
			<!-- 우측 영역 -->
			<div class="col-md-9 border">
				<div id="map"></div>
			</div>
	
		
		</div>
	</div>
</body>
</html>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANZ4_fRRdXyjcJE98Cjo1tMGf4tdzjY7A&callback=loadMap"></script>