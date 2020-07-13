<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<style>
/* Fixed sidenav, full height */
.sidenav {
	margin: 80px 20px 10px 20px;
	height: 50%;
	width: 250px;
	position: fixed;
	z-index: 1;
	top: 0;
	right: 0;
	background-color: #4E73DF;
	overflow-x: hidden;
	padding-top: 50px;
}

/* Style the sidenav links and the dropdown button */
.sidenav a, .dropdown-btn {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 20px;
	color: #FFFFFF;
	display: block;
	border: none;
	background: none;
	width: 100%;
	text-align: left;
	cursor: pointer;
	outline: none;
}

/* On mouse-over */
.sidenav a:hover, .dropdown-btn:hover {
	color: #f1f1f1;
}

/* Main content */
.main {
	margin-left: 250px;
	/* Same as the width of the sidenav */
	font-size: 20px;
	/* Increased text to enable scrolling */
	padding: 0px 10px;
}

/* Add an active class to the active dropdown button */
/*.active {
            background-color: green;
            color: white;
        }*/

/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
	display: default;
	background-color: #0431B4;
	padding-left: 8px;
}

/* Optional: Style the caret down icon */
.fa-caret-down {
	float: right;
	padding-right: 8px;
}

#left-sidemenu {
	font-size: 20px;
	font-family: '나눔고딕';
}

#left-sidemenu1 {
	font-size: 18px;
	font-family: '나눔고딕';
}

#content {
	width: 1800px;
}

#content-layer1 {
	width: 70%;
	float: left;
}

#content-layer2 {
	width: 30%;
	float: left;
}
</style>
	<!-- Page Wrapper -->
	<div id="wrapper">
		<jsp:include page="../wrapper.jsp"></jsp:include>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">

				<jsp:include page="../content-wrapper.jsp"></jsp:include>

				<!-- Begin Page Content -->
				<!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<br>
					<!-- Content Row -->
					<c:if test="${!empty msg }">
						<script>
							alert("${msg}")
						</script>
					</c:if>
					<!-- 로그인 한 사람 중 스터디 멤버일 때에만 보이도록 한다. -->
					<%-- <c:if test="${(not empty sessionScope.study }" --%>

					<div class="content">
						<input type="hidden" name="studyNo"> <input type="hidden"
							name="folderNo"> <input type="hidden"
							name="parentFolderNo">
						<!-- content -->
						<div class="row"></div>
						<div id="content-layer1" class="col-lg-8">
							<h1 class="h3 mb-1 text-gray-800">폴더명1-1</h1>
							<br>
							<div class="row">

								<div class="col-lg-11">
									<div class="card w-75">
										<div class="card-body">
											<form>
												<div class="form-group">
													<label for="exampleFormControlInput1">글 제목</label> <input
														type="email" class="form-control"
														id="exampleFormControlInput1"
														placeholder="글 제목이 들어가는 부분입니다.">
												</div>
												<div class="form-group">
													<label for="exampleFormControlSelect1">폴더 선택</label> <select
														class="form-control" id="exampleFormControlSelect1">
														<option>폴더1-1</option>
														<option>폴더1-2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</div>
												<div class="form-group">
													<label for="exampleFormControlSelect1">파일 찾기</label>
													<div class="input-group">
														<div class="custom-file">
															<input type="file" class="custom-file-input"
																id="inputGroupFile04"
																aria-describedby="inputGroupFileAddon04"> <label
																class="custom-file-label" for="inputGroupFile04">Choose
																file</label>
														</div>
														<div class="input-group-append">
															<button class="btn btn-outline-secondary" type="button"
																id="inputGroupFileAddon04">Button</button>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label for="exampleFormControlTextarea1">상세 내용</label>
													<textarea class="form-control"
														id="exampleFormControlTextarea1" rows="3"></textarea>
												</div>
											</form>
											<a href="#" class="btn btn-primary">등록하기</a>
										</div>
									</div>
								</div>
								<br> <br>

								<div class="col-lg-8">

									<div class="card w-80">
										<h5 class="card-header">글 제목</h5>
										<div class="card-body">
											<h5 class="card-title">제목1</h5>
											<p class="card-text">
												<a href="#" class="card-link">업로드 된 파일.jpg</a><br>
											<p class="text-left">세부내용이 작성되는 공간입니다.</p>
											<p class="text-right">작성자 : 작성자, 올린 시간 : 20xx.xx.xx</p>
											</p>
											<a href="#" class="btn btn-primary">파일 삭제</a>
										</div>
									</div>
								</div>
								<br>

								<div class="col-lg-8">

									<div class="card w-80">
										<h5 class="card-header">글 제목</h5>
										<div class="card-body">
											<h5 class="card-title">제목2</h5>
											<p class="card-text">
												<a href="#" class="card-link">업로드 된 파일.jpg</a><br>
											<p class="text-left">세부내용이 작성되는 공간입니다.</p>
											<p class="text-right">작성자 : 홍길동, 올린 시간 : 20xx.xx.xx</p>
											</p>
											<a href="#" class="btn btn-primary">파일 다운로드</a>
										</div>
									</div>
								</div>
								<br>
								<div class="col-lg-8">

									<div class="card w-80">
										<h5 class="card-header">글 제목</h5>
										<div class="card-body">
											<h5 class="card-title">제목3</h5>
											<p class="card-text">
												<a href="#" class="card-link">업로드 된 파일.jpg</a><br>
											<p class="text-left">세부내용이 작성되는 공간입니다.</p>
											<p class="text-right">작성자 : 유관순, 올린 시간 : 20xx.xx.xx</p>
											<a href="#" class="btn btn-primary">파일 다운로드</a>
										</div>
									</div>
								</div>

							</div>

							<br>
						</div>
						<div id="content-layer2" class="col-lg-2">
							<div class="left-content" style="height: 800px">
								<div class="folder-insert" style="height: 100px">
									<div class="input-group mb-3">
										<!-- 전송하기 위한 폼 input -->
										<form action="studyFolderInsert" method="post"
											id="insertFolder">

											<input type="text" class="form-control"
												placeholder="추가할 폴더 이름" name="folderName" id="folderName"
												aria-label="Recipient's username"
												aria-describedby="button-addon2">

											<button class="btn btn-outline-secondary" type="button"
												id="button-addon2" style="width: 75px">
												<a id="childFolder" href="javascript:void(0)"
													onclick="input_folder(this)">추가</a>
											</button>
										</form>
									</div>
								</div>
								<div class="folder-menu-list" style="height: 700px">
									<div class="btn-group"
										style="float: right; width: 250px; height: 50px">
										<button type="button" id="left-sidemenu"
											class="btn btn-secondary">Folder List</button>
										<button type="button"
											class="btn btn-secondary dropdown-toggle dropdown-toggle-split"
											id="dropdownMenuReference" style="width: 15px;"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false" data-reference="parent">
											<span class="sr-only">Toggle Dropdown</span>
										</button>
										<div class="dropdown-menu" id="left-sidemenu1"
											aria-labelledby="dropdownMenuReference" style="width: 280px">

											<!-- 폴더 리스트 출력 -->
											<div class="folder-list">
												<li class="parent-folder" id="parentfolder"><input
													type="hidden" name="studyNo" id="studyNo"
													value="${loginStudent.studyNo }">
													<tr>
														<td><input type="text" class="form-control"
															id="parentfolderName" value="${folderName }"></td>

													</tr>
													<ul class="child-folder" id="childfolder">

														<i href="#" class="fas fa-times"></i>
													</ul> &nbsp;&nbsp;&nbsp;<i href="#" class="fas fa-times"></i></a> <%-- <c:forEach
															items="${folderNo}" var="folderNo" varStatus="status">
															<ul class="child-folder" id="childfolder">
																<a class="dropdown-item" href="${status.index}">${folderName}</a>
																<i href="#" class="fas fa-times"></i>
															</ul>
														</c:forEach> --%> <%-- <form action="/selectfolderList" id="modifyfolderList"
													method="post">
													<!-- <li class="parent-folder" id="parentfolder"> -->
													<input type="hidden" name="studyNo" id="studyNo"
														value="${loginStudent.studyNo }"> 
														
														<input type="text" name="parentfolderName" id="parentfolderName" value="${folderName }"
														href="javascript:void(0)" onclick="selectfolderlist(this)">
													<ul class="child-folder" id="childfolder">
														
														<i href="#" class="fas fa-times"></i>
													</ul>
													&nbsp;&nbsp;&nbsp;<i href="#" class="fas fa-times"></i></a>
													<c:forEach
															items="${folderNo}" var="folderNo" varStatus="status">
															<ul class="child-folder" id="childfolder">
																<a class="dropdown-item" href="${status.index}">${folderName}</a>
																<i href="#" class="fas fa-times"></i>
															</ul>
														</c:forEach>
													<!-- </li> -->
												</form> --%>
											</div>
										</div>
									</div>
								</div>

							</div>


						</div>


					</div>
				</div>
			</div>
			<!-- End of Main Content -->
			<!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/js/demo/chart-area-demo.js"></script>
	<script src="/resources/js/demo/chart-pie-demo.js"></script>


	<script>
		// 새 폴더 생성
		function input_folder(obj) {

			// 1. 부모 폴더의 번호 및 값을 가져와서 넣어준다.
			var folderName = $(obj).parent().siblings(1).val();
			console.log("folderName : " + folderName)
			// 2. 자식 폴더 id 값에 변수 입력 
			$("#parentfolderName").val(folderName);

			/* var action = $("#insertform").attr("action");
			console.log(action); */

			$("#parentfolderName").submit();
		}
		// 폴더를 DB에 저장
		$("#childFolder").on("click", function() {
			var folderName = $("#folderName").val(); // 폴더명 전송
			// 전송할 타이틀이 있는 요소
			$.ajax({
				url : "insertfolder.cunity", // 서버에 전달할 파일명
				data : {folderName : folderName, folderNo:folderNo }, // 전송할 파라미터 값
				type : "post",
				success : function(data) {
					if (data == "success") {
						$("#parentfolderName").val("");
					}
				}

			})
		});

		/* 파일을 업로드 할 때 동작하는 메소드 */
		function addFile() {

		}
		/* 파일을 삭제할 때 동작하는 메소드 */
		function deleteFile() {

		}
		/* 파일을 다운로드 할 때 동작하는 메소드 */
		function downloadFile() {

		}
		/* 업로드한 파일을 선택할 때 동작하는 메소드 */
		function download() {

		}
	</script>
</body>

</html>
