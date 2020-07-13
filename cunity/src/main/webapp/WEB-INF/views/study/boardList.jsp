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
<style>
        .profile {
            width: 80px;
            height: 80px;
            border: 5px solid lightgray;
            border-radius: 100px;
            float: left;
        }

        .profile_update {
            width: 80px;
            height: 80px;

            border: 5px solid rgb(46, 89, 217);
            border-radius: 100px;
            float: left;
        }

        #profile-area {
            margin-left: 15px;
        }

        .writer {
            margin-left: 10px;
            float: left;
            padding-top: 10px;
        }

        a:hover {

            text-decoration: none;
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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">스터디 보드</h1>
						<c:url value="/boardWriteForm" var="boardWriteForm"></c:url>
						<h4 style="position:fixed;top:150px;"><a href="${boardWriteForm }"><i class="fas fa-pencil-alt"></i>작성하러가기</a></h4>
					</div>

					<div class="row"></div>

					<div class="container">
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-12 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col">
											<div
												class="text-sm font-weight-bold text-primary text-uppercase mb-3">스터디
												멤버</div>
											<div
												class="row h5 font-weight-bold text-gray-800 text-center">
												<c:forEach var="studyMember" items="${sList }" varStatus="index">
													<div id="profile-area">
														<figure> <img class="profile  mb-2"
															src="/resources/img/${studyMember.sFile }"> <figcaption>${studyMember.sName }</figcaption>
														</figure>
													</div>
												</c:forEach>
												<div id="profile-area">
													<figure> <img class="profile  mb-2"
														src="/resources/img/chipmunk.jpg"> <figcaption>이승원</figcaption>
													</figure>
												</div>
												<div id="profile-area">
													<img class="profile_update mb-2" src="/resources/img/chipmunk.jpg">
													<figcaption>이승원</figcaption>
												</div>
												<div id="profile-area">
													<img class="profile  mb-2" src="/resources/img/chipmunk.jpg">
													<figcaption>이승원</figcaption>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-12">

							<c:forEach var="timeLine" items="${pList }" varStatus="index">
								<div class="card mb-4">
									<div class="card-header">
										<div class="header">
											<img class="profile" src="/resources/img/${timeLine.filePath }">
											<div class="writer">
												<h5>${timeLine.postWriterSNo }${timeLine.postWriterSName }</h5>
												<span><i class="far fa-calendar-alt"></i> ${timeLine.postRegDate }</span>
											</div>
										</div>
									</div>
									<div class="card-body" id="card-body">${timeLine.postContent }</div>
									<div class="card-footer">
										<c:url value="/boardDetail" var="boardDetail">
											<c:param name="postNo" value="${timeLine.postNo }"/>
										</c:url>
										<a href="${boardDetail }"><i class="fab fa-readme"></i> 상세보기</a> <a href="javascript:void(0);" onclick="copy('127.0.0.1:8084/boardDetail?postNo=${timeLine.postNo}');"><i
											class="fas fa-share"></i> 공유하기</a>
									</div>
								</div>
							</c:forEach>
							<!-- Default Card Example -->
							<div class="card mb-4">
								<div class="card-header">
									<div class="header">
										<img class="profile" src="/resources/img/chipmunk.jpg">
										<div class="writer">
											<h5>이승원</h5>
											<span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
										</div>
									</div>
								</div>
								<div class="card-body" id="card-body">This card uses
									Bootstrap's default styling with no utility classes added.
									Global styles are the only things modifying the look and feel
									of this default card example. This card uses Bootstrap's
									default styling with no utility classes added. Global styles
									are the only things modifying the look and feel of this default
									card example.</div>
								<div class="card-footer">
								
									<a href="${boardWriteForm }"><i class="fab fa-readme"></i> 상세보기</a> <a href="#"><i
										class="fas fa-share"></i> 공유하기</a>
								</div>
							</div>
							<!-- Default Card Example -->
							<div class="card shadow mb-4 ">
								<div class="card-header">
									<div class="header">
										<img class="profile" src="/resources/img/chipmunk.jpg">
										<div class="writer">
											<h5>이승원</h5>
											<span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
										</div>
									</div>
								</div>
								<div class="card-body">This card uses Bootstrap's default
									styling with no utility classes added. Global styles are the
									only things modifying the look and feel of this default card
									example. This card uses Bootstrap's default styling with no
									utility classes added. Global styles are the only things
									modifying the look and feel of this default card example.</div>
								<div class="card-footer">
									<a href="#"><i class="fab fa-readme"></i> 상세보기</a> <a href="#"><i
										class="fas fa-share"></i> 공유하기</a>
								</div>
							</div>
							<!-- Default Card Example -->
							<div class="card mb-4">
								<div class="card-header">
									<div class="header">
										<img class="profile" src="/resources/img/chipmunk.jpg">
										<div class="writer">
											<h5>이승원</h5>
											<span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
										</div>
									</div>
								</div>
								<div class="card-body">This card uses Bootstrap's default
									styling with no utility classes added. Global styles are the
									only things modifying the look and feel of this default card
									example. This card uses Bootstrap's default styling with no
									utility classes added. Global styles are the only things
									modifying the look and feel of this default card example.</div>
								<div class="card-footer">
									<a href="#"><i class="fab fa-readme"></i> 상세보기</a> <a href="#"><i
										class="fas fa-share"></i> 공유하기</a>
								</div>
							</div>
							<!-- Default Card Example -->
							<div class="card mb-4">
								<div class="card-header">
									<div class="header">
										<img class="profile" src="/resources/img/chipmunk.jpg">
										<div class="writer">
											<h5>이승원</h5>
											<span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
										</div>
									</div>
								</div>
								<div class="card-body">This card uses Bootstrap's default
									styling with no utility classes added. Global styles are the
									only things modifying the look and feel of this default card
									example. This card uses Bootstrap's default styling with no
									utility classes added. Global styles are the only things
									modifying the look and feel of this default card example.</div>
								<div class="card-footer">
									<a href="#"><i class="fab fa-readme"></i> 상세보기</a> <a href="#"><i
										class="fas fa-share"></i> 공유하기</a>
								</div>
							</div>
							<!-- Basic Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Basic Card
										Example</h6>
								</div>
								<div class="card-body">The styling for this basic card
									example is created by using default Bootstrap utility classes.
									By using utility classes, the style of the card component can
									be easily modified with no need for any custom CSS!</div>
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
	<!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
	<script type="text/javascript">
	function copy(val) {
		  var dummy = document.createElement("textarea");
		  document.body.appendChild(dummy);
		  dummy.value = val;
		  dummy.select();
		  document.execCommand("copy");
		  document.body.removeChild(dummy);
		}
	</script>
</body>

</html>
