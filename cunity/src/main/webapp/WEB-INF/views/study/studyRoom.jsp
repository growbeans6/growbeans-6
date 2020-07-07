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
					

							<!-- Begin Page Content -->
                <div class="container">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-1 text-gray-800" style="align:center; ">스터디룸 이름 </h1>


                    <!-- 스터디 메인 content -->



                    <!-- 스터디 메인 content 우측 -->
                    <div class="content2" style="align:center; ">
                        <main>
                            <header>
                                <h1>타임라인이 표시되는 곳입니다.</h1>
                            </header>
                            <br>
                            <ul id="chat" style="width: 800px">
                                <li class="you">
                                    <div class="entete">
                                        <span class="status green"></span>
                                        <h2>Vincent</h2>
                                        <h3>10:12AM, Today</h3>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                                    </div>
                                </li>
                                <li class="me">
                                    <div class="entete">
                                        <h3>10:12AM, Today</h3>
                                        <h2>Vincent</h2>
                                        <span class="status blue"></span>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                                    </div>
                                </li>
                                <li class="me">
                                    <div class="entete">
                                        <h3>10:12AM, Today</h3>
                                        <h2>Vincent</h2>
                                        <span class="status blue"></span>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        OK
                                    </div>
                                </li>
                                <li class="you">
                                    <div class="entete">
                                        <span class="status green"></span>
                                        <h2>Vincent</h2>
                                        <h3>10:12AM, Today</h3>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                                    </div>
                                </li>
                                <li class="me">
                                    <div class="entete">
                                        <h3>10:12AM, Today</h3>
                                        <h2>Vincent</h2>
                                        <span class="status blue"></span>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
                                    </div>
                                </li>
                                <li class="me">
                                    <div class="entete">
                                        <h3>10:12AM, Today</h3>
                                        <h2>Vincent</h2>
                                        <span class="status blue"></span>
                                    </div>
                                    <div class="triangle"></div>
                                    <div class="message">
                                        OK
                                    </div>
                                </li>
                            </ul>
                            <footer>
                                <textarea placeholder="Type your message"></textarea>
                                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_picture.png" alt="">
                                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_file.png" alt="">
                                <a href="#">Send</a>
                            </footer>
                        </main>


                    </div>

                    <!-- 스터디 메인 content 좌측(멤버 리스트) -->
                    <div class="sidenav" style="float: right;">

                        <aside>

                            <ul>

                                <li>
                                    <img src="https://topclass.chosun.com/news_img/1807/1807_008.jpg" style="height:55px; width: 55px" alt="">
                                    <div>
                                        <h2>B83201635</h2>
                                        <h2>이용자</h2>
                                    </div>
                                </li>

                                <li>
                                    <img src="https://topclass.chosun.com/news_img/1807/1807_008.jpg" style="height:55px; width: 55px" alt="">
                                    <div>
                                        <h2>B83201810</h2>
                                        <h2>강감찬</h2>
                                    </div>
                                </li>
                                <li>
                                    <img src="https://topclass.chosun.com/news_img/1807/1807_008.jpg" style="height:55px; width: 55px" alt="">
                                    <div>
                                        <h2>B83202013</h2>
                                        <h2>홍길동</h2>
                                    </div>
                                </li>
                                <li>
                                    <img src="https://topclass.chosun.com/news_img/1807/1807_008.jpg" style="height:55px; width: 55px" alt="">
                                    <div>
                                        <h2>B83202022</h2>
                                        <h2>유관순</h2>
                                    </div>
                                </li>

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
