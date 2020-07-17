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

					<h1 class="h3 mb-2 text-gray-800">게시판</h1>
					<p class="mb-4">스터디 게시판을 통해 스터디에 가입해 온라인 스터디 시스템을 이용해보세요!</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">post</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-hover" id="dataTable" width="100%"
									style="overflow-x:hidden" cellspacing="0">
									<thead>
										<tr>
											<th>글 번호</th>
											<th>카테고리</th>
											<th>작성자</th>
											<th>글 제목</th>
											<th>글 내용</th>
											<th>작성일</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list }">
											<c:url var="postDetail" value="postDetail">
												<c:param name="postNo" value="${list.postNo}" />
											</c:url>
										<tr onclick="location.href='${postDetail}'">
													<td>${list.postNo }</td>
													<td>${list.postCategory }</td>
													<td>${list.postWriterSNo}</td>
													<td>${list.postSubject}</td>
													<td>${list.postContent}</td>
													<td>${list.postRegDate}</td>
											</tr>
										</c:forEach>
										<button class="btn btn-primary" onclick="location.href='postWrite'">글 쓰기</button>
									</tbody>
								</table>
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
	<script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/js/demo/datatables-demo.js"></script>
	
	<script type="text/javascript">
	$('#dataTable').DataTable({
		  order: [[0, 'desc']], // asc 또는 desc
		  ordering: true,
		  serverSide: false
		});
	</script>
</body>

</html>
