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
					<div class="content">
						<div class="row">
							<!-- content -->
							<div class="row-layer1"
								style="margin: auto; width: 1400px; align: center">
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

										<a class="dropdown-item" href="#">폴더명1&nbsp;&nbsp;&nbsp;<i
											href="#" class="fas fa-times"></i></a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#">폴더명1-1&nbsp;&nbsp;&nbsp;<i
											href="#" class="fas fa-times"></i></a> <a class="dropdown-item"
											href="#">폴더명1-2</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#">폴더명2</a>
										<div class="dropdown-divider"></div>
										<div class="input-group mb-3">
											<input type="text" class="form-control"
												placeholder="추가할 폴더 이름" aria-label="Recipient's username"
												aria-describedby="button-addon2">
											<div class="input-group-append">
												<button class="btn btn-outline-secondary" type="button"
													id="button-addon2" style="width: 75px">추가</button>
											</div>
										</div>
									</div>
								</div>
								<h1 class="h3 mb-1 text-gray-800">폴더명1-1</h1>
								<br>
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
											<a href="javascript:void(0);" onclick="addFile();"><i
												class="btn btn-primary"></i>등록하기</a>
										</div>
									</div>
								</div>
								<br> <br>

								<div class="col-lg-8">

									<div id="fileDelete" class="card w-80" style="display: none;">
										<h5 class="card-header">글 제목</h5>
										<div class="card-body">
											<h5 class="card-title">제목1</h5>
											<p class="card-text">
												<a href="openfile" href="javascript:void(0);"
													onclick="download();" class="card-link">업로드 된 파일.jpg</a><br>
											<p class="text-left">세부내용이 작성되는 공간입니다.</p>
											<p class="text-right">작성자 : 작성자, 올린 시간 : 20xx.xx.xx</p>
											</p>
											<a href="javascript:void(0)" onclick="deleteFile();"><i
												class="btn btn-primary"></i>파일 삭제</a>
										</div>
									</div>
								</div>
								<br>

								<div class="col-lg-8">

									<div id="fileDownload" class="card w-80" style="display: none;">
										<h5 class="card-header">글 제목</h5>
										<div class="card-body">
											<h5 class="card-title">제목2</h5>
											<p class="card-text">
												<a href="openfile" href="javascript:void(0);"
													onclick="download();" class="card-link">업로드 된 파일.jpg</a><br>
											<p class="text-left">세부내용이 작성되는 공간입니다.</p>
											<p class="text-right">작성자 : 홍길동, 올린 시간 : 20xx.xx.xx</p>
											</p>
											<a href="javascript:void(0)" onclick="downloadFile();"><i
												class="btn btn-primary"></i>파일 다운로드</a>
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
								<br>
							</div>
						</div>
						<div class="row-layer2"></div>

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
		var count = 0;
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
