<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Friends & 1:1 Live Chat</h1>
					</div>

					<div class="row"
						style="width: 50%; float: left; margin-right: 5px;">
						<!-- Earnings (Monthly) Card Example -->

						<div class="col-xl-12 col-md-12 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-lg font-weight-bold text-primary text-uppercase mb-1">Friends</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
								<!-- 친구 검색 검색바 -->
								<input id="sName" type="search" placeholder="친구의 이름 입력"/>
									<button onclick="findFriends();">
										<i class="fa fa-search"></i>
									</button>
									<br>
															
						
						<div class="col-xl-12 col-md-12 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="text-lg font-weight-bold text-primary text-uppercase mb-1">
												<div id="findFriendsList" ></div>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<c:forEach var="friendsList" items="${friendsList }">
						<!-- 친구 목록 불러와서 보여주는 -->
							<div class="col-xl-12 col-md-12 mb-4">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div class="text-lg font-weight-bold text-primary text-uppercase mb-1">
													<div id="friendsList" > 학번: ${friendsList.sNo } 이름: ${friendsList.sName }</div>
												</div>
											</div>
											<div class="col-auto">
												<i class="fas fa-calendar fa-2x text-gray-300"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					<div class="row" style="width: 50%; float: left;">
						<div class="col-xl-12 col-md-12 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-lg font-weight-bold text-success text-uppercase mb-1">1:1
												Live Chat</div>

										</div>
										<div class="col-auto">
											<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-12 col-md-12 mb-4" style="height: 500px;">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="text-sm mb-1">테스트(test)</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-12 col-md-12 mb-4">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center"
										style="float: left;">
										<textarea class="text-sm" style="border: none;"></textarea>
									</div>
									<button class="btn btn-primary" style="float: right;">
										전송</button>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2020</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->
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
	
	<script type="text/javascript">
		function findFriends(){
			$("#findFriendsList").html("");
			var sName = $("#sName").val();
			$.ajax({
				url: "findFriends",
				data: {
					sName : sName
				},
				dataType:"json",
				success: function(data){
					if(data != null){
						for(var i in data){
							$("#findFriendsList").append("<div> 학번: "+ data[i].sNo + " 이름: " + data[i].sName+"</div> <button location.href='insertFriends?sNo="+data[i].sNo+"&sessionSNo="+${loginStudent.sNo}+"'>친구 신청</button> <br>");
						}
					} 
				} else {
						$("#findFriendsList").html("검색 결과가 없습니다.");
					}
				}
			})
		}
	</script>
</body>
</html>
