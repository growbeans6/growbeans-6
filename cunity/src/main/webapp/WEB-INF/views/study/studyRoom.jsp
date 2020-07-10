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
* {
	box-sizing: border-box;
}

body {
	background-color: #abd9e9;
	font-family: Arial;
}

#container {
	width: 750px;
	height: 800px;
	background: #eff3f7;
	margin: 0 auto;
	font-size: 0;
	border-radius: 5px;
	overflow: hidden;
}

/* Fixed sidenav, full height */
.sidenav {
	margin: 80px 30px 30px 40px;
	height: 40%;
	width: 250px;
	position: fixed;
	z-index: 1;
	top: 0;
	right: 0;
	overflow-x: hidden;
	padding-top: 50px;
}

aside {
	width: 260px;
	height: 100%;
	background-color: #3b3e49;
	display: inline-block;
	font-size: 15px;
	vertical-align: top;
}

main {
	width: 490px;
	height: 800px;
	display: inline-block;
	font-size: 15px;
	vertical-align: top;
}

aside header {
	padding: 30px 20px;
}

aside input {
	width: 100%;
	height: 50px;
	line-height: 50px;
	padding: 0 50px 0 20px;
	background-color: #5e616a;
	border: none;
	border-radius: 3px;
	color: #fff;
	background-image:
		url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_search.png);
	background-repeat: no-repeat;
	background-position: 170px;
	background-size: 40px;
}

aside input::placeholder {
	color: #fff;
}

aside ul {
	padding-left: 0;
	margin: 0;
	list-style-type: none;
	overflow-y: scroll;
	height: 690px;
}

aside li {
	padding: 10px 0;
}

aside li:hover {
	background-color: #5e616a;
}

h2, h3 {
	margin: 0;
}

aside li img {
	border-radius: 50%;
	margin-left: 20px;
	margin-right: 8px;
}

aside li div {
	display: inline-block;
	vertical-align: top;
	margin-top: 12px;
}

aside li h2 {
	font-size: 14px;
	color: #fff;
	font-weight: normal;
	margin-bottom: 5px;
}

aside li h3 {
	font-size: 12px;
	color: #7e818a;
	font-weight: normal;
}

.status {
	width: 8px;
	height: 8px;
	border-radius: 50%;
	display: inline-block;
	margin-right: 7px;
}

.green {
	background-color: #58b666;
}

.orange {
	background-color: #ff725d;
}

.blue {
	background-color: #6fbced;
	margin-right: 0;
	margin-left: 7px;
}

main header {
	height: 110px;
	padding: 30px 20px 30px 40px;
}

main header>* {
	display: inline-block;
	vertical-align: top;
}

main header img:first-child {
	border-radius: 50%;
}

main header img:last-child {
	width: 24px;
	margin-top: 8px;
}

main header div {
	margin-left: 10px;
	margin-right: 180px;
}

main header h2 {
	font-size: 16px;
	margin-bottom: 5px;
}

main header h3 {
	font-size: 14px;
	font-weight: normal;
	color: #7e818a;
}

#chat {
	padding-left: 0;
	margin: 0;
	list-style-type: none;
	overflow-y: scroll;
	height: 535px;
	border-top: 2px solid #fff;
	border-bottom: 2px solid #fff;
}

#chat li {
	padding: 10px 30px;
}

#chat h2, #chat h3 {
	display: inline-block;
	font-size: 13px;
	font-weight: normal;
}

#chat h3 {
	color: #bbb;
}

#chat .entete {
	margin-bottom: 5px;
}

#chat .message {
	padding: 20px;
	color: #fff;
	line-height: 25px;
	max-width: 90%;
	display: inline-block;
	text-align: left;
	border-radius: 5px;
}

#chat .me {
	text-align: right;
}

#chat .you .message {
	background-color: #58b666;
}

#chat .me .message {
	background-color: #6fbced;
}

#chat .triangle {
	width: 0;
	height: 0;
	border-style: solid;
	border-width: 0 10px 10px 10px;
}

#chat .you .triangle {
	border-color: transparent transparent #58b666 transparent;
	margin-left: 15px;
}

#chat .me .triangle {
	border-color: transparent transparent #6fbced transparent;
	margin-left: 375px;
}

main footer {
	height: 155px;
	padding: 20px 30px 10px 20px;
}

main footer textarea {
	resize: none;
	border: none;
	display: block;
	width: 100%;
	height: 80px;
	border-radius: 3px;
	padding: 20px;
	font-size: 13px;
	margin-bottom: 13px;
}

main footer textarea::placeholder {
	color: #ddd;
}

main footer img {
	height: 30px;
	cursor: pointer;
}

main footer a {
	text-decoration: none;
	text-transform: uppercase;
	font-weight: bold;
	color: #6fbced;
	vertical-align: top;
	margin-left: 333px;
	margin-top: 5px;
	display: inline-block;
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


					<!-- Begin Page Content -->
					<div class="container">

						<!-- Page Heading -->
						<h1 class="h3 mb-1 text-gray-800" style="align: center;">스터디룸
							이름</h1>


						<!-- 스터디 메인 content -->



						<!-- 스터디 메인 content 우측 -->
						<div class="content2" style="align: center;">
							<main> <header>
							<h1>타임라인이 표시되는 곳입니다.</h1>
							</header> <br>
							<ul id="chat" style="width: 800px">
								<li class="you">
									<div class="entete">
										<span class="status green"></span>
										<h2>Vincent</h2>
										<h3>10:12AM, Today</h3>
									</div>
									<div class="triangle"></div>
									<div class="message">Lorem ipsum dolor sit amet,
										consectetuer adipiscing elit. Aenean commodo ligula eget
										dolor.</div>
								</li>
								<li class="me">
									<div class="entete">
										<h3>10:12AM, Today</h3>
										<h2>Vincent</h2>
										<span class="status blue"></span>
									</div>
									<div class="triangle"></div>
									<div class="message">Lorem ipsum dolor sit amet,
										consectetuer adipiscing elit. Aenean commodo ligula eget
										dolor.</div>
								</li>
								<li class="me">
									<div class="entete">
										<h3>10:12AM, Today</h3>
										<h2>Vincent</h2>
										<span class="status blue"></span>
									</div>
									<div class="triangle"></div>
									<div class="message">OK</div>
								</li>
								<li class="you">
									<div class="entete">
										<span class="status green"></span>
										<h2>Vincent</h2>
										<h3>10:12AM, Today</h3>
									</div>
									<div class="triangle"></div>
									<div class="message">Lorem ipsum dolor sit amet,
										consectetuer adipiscing elit. Aenean commodo ligula eget
										dolor.</div>
								</li>
								<li class="me">
									<div class="entete">
										<h3>10:12AM, Today</h3>
										<h2>Vincent</h2>
										<span class="status blue"></span>
									</div>
									<div class="triangle"></div>
									<div class="message">Lorem ipsum dolor sit amet,
										consectetuer adipiscing elit. Aenean commodo ligula eget
										dolor.</div>
								</li>
								<li class="me">
									<div class="entete">
										<h3>10:12AM, Today</h3>
										<h2>Vincent</h2>
										<span class="status blue"></span>
									</div>
									<div class="triangle"></div>
									<div class="message">OK</div>
								</li>
							</ul>
							<footer> <textarea placeholder="Type your message"></textarea>
							<img
								src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_picture.png"
								alt=""> <img
								src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_file.png"
								alt=""> <a href="#">Send</a> </footer> </main>


						</div>

						<!-- 스터디 메인 content 좌측(멤버 리스트) -->
						<div class="sidenav" style="float: right;">

							<aside>

							<ul>

								<li><img
									src="https://topclass.chosun.com/news_img/1807/1807_008.jpg"
									style="height: 55px; width: 55px" alt="">
									<div>
										<h2>B83201635</h2>
										<h2>이용자</h2>
									</div></li>

								<li><img
									src="https://topclass.chosun.com/news_img/1807/1807_008.jpg"
									style="height: 55px; width: 55px" alt="">
									<div>
										<h2>B83201810</h2>
										<h2>강감찬</h2>
									</div></li>
								<li><img
									src="https://topclass.chosun.com/news_img/1807/1807_008.jpg"
									style="height: 55px; width: 55px" alt="">
									<div>
										<h2>B83202013</h2>
										<h2>홍길동</h2>
									</div></li>
								<li><img
									src="https://topclass.chosun.com/news_img/1807/1807_008.jpg"
									style="height: 55px; width: 55px" alt="">
									<div>
										<h2>B83202022</h2>
										<h2>유관순</h2>
									</div></li>

							</ul>
							</aside>
						</div>




					</div>
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
</body>

</html>
