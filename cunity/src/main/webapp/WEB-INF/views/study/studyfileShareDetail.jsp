<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
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
</head>

<body id="page-top">

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

						<!-- content -->

						<div class="row"></div>

						<div id="content-layer1" class="col-lg-8">
							<h1 class="h3 mb-1 text-gray-800">폴더명1-1</h1>
							<br>
							<div class="row">
								<%-- <c:url var="#" values="#"/>
							<a href="${ }"></a>
								<c:forEach var="n" items="${ }"> --%>
								<div class="col-lg-11">
									<div class="card w-75">
										<div class="card-body">
											<form action="sfinsert.cunity" method="post" id="fileForm"
												enctype="Multipart/form-data">
												<div class="form-group">
													<input type="hidden" name="studyNo"
														value="${loginStudent.studyNo }"> <input
														type="hidden" name="studentNo"
														value="${loginStudent.sNo }"> <input type="hidden"
														name="fileRegistrant" value="${writer }">
												</div>
												<!-- 나중에 forEach로 바꿔줘야 함 -->
												<div class="form-group">
													<label for="exampleFormControlSelect1">폴더 선택</label> <select
														name="folderNo" class="form-control"
														id="exampleFormControlSelect1">
														<option value="${FolderList[0].folderNo }">${FolderList[0].folderName }</option>
													</select>
												</div>
												<div class="form-group">
													<label for="exampleFormControlSelect1">파일 찾기</label>
													<div class="input-group">
														<div class="custom-file">
															<input type="file" class="file-input" name="fileName">
														</div>
													</div>
												</div>
												<input type="submit" value="등록하기" class="btn btn-primary">
											</form>
										</div>
									</div>
								</div>
								<br> <br>
								<c:forEach var="FileDetail" items="${filelist }" varStatus="index">
									<div class="col-lg-8">
										<div id="filebox" class="card w-80">
											<h5 class="card-header">${FileDetail.uploadFile }</h5>
											<div class="card-body">
												<h5 class="card-title">
													<input type="hidden" name="uploadFile"
														value="${uploadFile }"> ${FileDetail.uploadFile }
												</h5>
												<p class="card-text">
													<a href="#" class="card-link">${FileDetail.uploadFile }</a>
												</p>
												<br>
												<p class="text-right">작성자 : ${FileDetail.fileRegistrant},
													올린 시간 : ${FileDetail.fileUploadTime }</p>
												<c:if test="${loginStudent.sName eq FileDetail.fileRegistrant }">
												<!-- 쿼리스트링 넣어주기 -> 넣어주어야 컨트롤러 메소드의 매개변수가 받아서 처리 가능 -->
												<!-- get방식으로 넘겨주는 거라서 c:param으로 파라미터값을 넘겨주어야 함 -->
												<c:url var="sfdelete" value="sfdelete.cunity">
													<c:param name="fileNo" value="${FileDetail.fileNo }"/>
												</c:url>
												<a href="${sfdelete }" class="btn btn-primary">파일 삭제</a></c:if>
												<c:if test="${loginStudent.sName ne FileDetail.fileRegistrant }">
												<a href="<c:url value='/resources/nuploadFiles/${FileDetail.uploadFile }'/>" class="btn btn-primary" download>파일 다운로드</a>
												</c:if>
											</div>
										</div>
									</div>
								</c:forEach>

								<br> <br>
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
											<input type="hidden" name="studyNo"
												value="${loginStudent.studyNo }">
											<%-- input
											type="hidden" name="parentFolderNo"
											value="${childerenFolderList. }"> --%>
											<input type="text" class="form-control"
												placeholder="추가할 폴더 이름" name="folderName" id="folderName"
												aria-label="Recipient's
											username"
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
											class="btn btn-secondary
											dropdown-toggle dropdown-toggle-split"
											id="dropdownMenuReference" style="width: 15px;"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false" data-reference="parent">
											<span class="sr-only">Toggle Dropdown</span>
										</button>
										<div class="dropdown-menu" id="left-sidemenu1"
											aria-labelledby="dropdownMenuReference" style="width: 280px">

											<!-- 폴더 리스트 출력 -->
											<div class="study_folder_list">
                                                <ul class="folder_list">

                                                    <li class="parent_folder">
                                                        <a class="dropdown-item" href="#">폴더명1&nbsp;&nbsp;&nbsp;
                                                        <i href="#" class="fas fa-times"></i></a></li>

                                                    <ul class="child_folder"><a class="dropdown-item" href="#">폴더명1-1</a>

                                                    </ul>

                                                    <li class="parent-folder">
                                                        <a class="dropdown-item" href="#">폴더명2&nbsp;&nbsp;&nbsp;<i href="#" class="fas fa-times"></i></a>
                                                    </li>

                                                </ul>

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


			<!-- 페이지에 들어갈 부분을
											container-fluid에 넣어주시면 됩니다. -->
		</div>
		<!-- End of Content
											Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>
	<!-- Page
											level plugins -->
	<script src="/resources/vendor/chart.js/Chart.min.js"></script>
	<!--
											Page level custom scripts -->
	<script src="/resources/js/demo/chart-area-demo.js"></script>
	<script src="/resources/js/demo/chart-pie-demo.js"></script>
	<script>
		// 새 폴더 생성 

		var count = 0;
		
		
	</script>
</body>
</html>