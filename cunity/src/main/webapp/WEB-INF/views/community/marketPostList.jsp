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
					<p class="mb-4">장터 게시판은 다양한 상품을 거래할 수 있는 곳입니다. 특히 말머리를 이용하여 폭넓게 이용할
						수 있습니다.</p>
					<div>
					<c:if test="${ !empty loginStudent }">
						<button onclick="location.href='postWrite';">글쓰기</button>
					</c:if>
					<!-- 상품 목록 -->
					<c:forEach var="post" items="${list }">
						<div
							class="card shadow mt-5 mb-5 ml-5 mr-5 col-sm-3 col-md-3 col-lg-3 col-xl-3"
							style="height: 300px; width: 100%; float: left;">
							<div class="card-body">
							<c:url var="postDetail" value="postDetail">
								<c:param name="postNo" value="${post.postNo}" />
							</c:url>
								<div class="table-responsive" onclick="location.href='${postDetail}'">
									<h6>${post.postRegDate }</h6>
									<img alt="이미지" src="${contextPath }/resources/nuploadFiles/${post.filePath}">
									<h5>${post.postContent }</h5>
								</div>
							</div>
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">${post.postSubject }</h6>
							</div>
						</div>
					</c:forEach>
					</div>
					<!-- 페이징 처리 -->
					<div>
						<table>
							<tr align="center" height="20">
								<td colspan="6">
									<!-- [이전] -->
									<c:if test="${pi.currentPage <= 1 }">
										[이전] &nbsp;
									</c:if>
									<c:if test="${pi.currentPage > 1 }">
										<c:url var="before" value="postList">
											<c:param name="postKinds" value="장터"/>
											<c:param name="page" value="${pi.currentPage - 1 }"/>
										</c:url>
										<a href="${before }">[이전]</a> &nbsp;
									</c:if>
									<!-- 페이지 -->
									
									<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
										<c:if test="${p eq pi.currentPage }">
											<font color="red" size="4"><b>[${p }]</b></font>
										</c:if>
										<c:if test="${p ne pi.currentPage }">
											<c:url var="pagination" value="postList">
												<c:param name="postKinds" value="장터"/>
												<c:param name="page" value="${p }"/>
											</c:url>
											<a href="${pagination }">${p }</a> &nbsp;
										</c:if>
									</c:forEach>
									
									<!-- [다음] -->
									<c:if test="${pi.currentPage >= pi.maxPage }">
										[다음] &nbsp;
									</c:if>
									<c:if test="${pi.currentPage < pi.maxPage }">
										<c:url var="after" value="postList">
											<c:param name="postKinds" value="장터"/>
											<c:param name="page" value="${pi.currentPage + 1 }"/>
										</c:url>
										<a href="${after }">[다음]</a> &nbsp;
									</c:if>
								</td>
							</tr>
						</table>
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
</body>

</html>
