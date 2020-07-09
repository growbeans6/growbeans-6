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
* {
	box-sizing: border-box;
}

body {
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

aside {
	width: 260px;
	height: 800px;
	background-color: #3b3e49;
	display: inline-block;
	font-size: 15px;
	vertical-align: top;
}

main {
	border: 1px solid lightgray;
	width: 1200px;
	height: 800px;
	display: inline-block;
	font-size: 15px;
	vertical-align: top;
}

aside header {
	padding: 30px 20px;
	color: azure;
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
	width:80px;
	height:80px;
	border-radius: 100%;
	margin-left: 20px;
	margin-right: 8px;
	border:4px solid gray;
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
	margin-right: 145px;
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
	margin-left: 1075px;
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

main footer select {
	height: 25px;
}

main footer div {
	padding-left: 20px;
}

.entry {
	text-align: center;
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
					<aside> <header>
					<h3>스터디 멤버 목록</h3>
					</header>
					<ul>
						<li><img
							src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_09.jpg"
							alt="">
							<div>
								<h2>Prénom Nom</h2>
								<h3>
									<span class="status green"></span> online
								</h3>
							</div></li>
						<li><img
							src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_10.jpg"
							alt="">
							<div>
								<h2>Prénom Nom</h2>
								<h3>
									<span class="status orange"></span> offline
								</h3>
							</div></li>
						<li><img
							src="/resources/img/chipmunk.jpg"
							alt="">
							<div>
								<h2>Prénom Nom</h2>
								<h3>
									<span class="status orange"></span> offline
								</h3>
							</div></li>
					</ul>
					</aside>
					<main> <header>
					<h1>ChatRoom</h1>
					</header>
					<ul id="chat">
						<li class="you">
							<div class="entete">
								<span class="status green"></span>
								<h2>Vincent</h2>
								<h3>10:12AM, Today</h3>
							</div>
							<div class="triangle"></div>
							<div class="message">Lorem ipsum dolor sit amet,
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
							</div>
						</li>
						<li class="me">
							<div class="entete">
								<h3>10:12AM, Today</h3>
								<h2>Vincent</h2>
								<span class="status blue"></span>
							</div>
							<div class="triangle"></div>
							<div class="message">Lorem ipsum dolor sit amet,
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
							</div>
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
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
							</div>
						</li>
						<li class="me">
							<div class="entete">
								<h3>10:12AM, Today</h3>
								<h2>Vincent</h2>
								<span class="status blue"></span>
							</div>
							<div class="triangle"></div>
							<div class="message">Lorem ipsum dolor sit amet,
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
							</div>
						</li>
						<li class="me">
							<div class="entete">
								<h3>10:12AM, Today</h3>
								<h2>Vincent</h2>
								<span class="status blue"></span>
							</div>
							<div class="triangle"></div>
							<div class="message">Lorem ipsum dolor sit amet,
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
								Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean
								commodo ligula eget dolor. Lorem ipsum dolor sit amet,
								consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
							</div>
						</li>
						<li class="entry">
							<p>입장하셨습니다.</p>
						</li>
					</ul>
					<footer> <textarea id="message"
						placeholder="Type your message"></textarea>
					<div class="row">
						<select>
							<option value="전체">전체</option>
							<option value="이승원">이승원</option>
						</select> <a href="javascript:void(0);" onclick="sendMessage(this);">Send</a>
					</div>

					</footer> </main>
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
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
	<script type="text/javascript">
		// 웹소켓 연결 (매핑된 url의 핸들러와 연결된다.)
		let sock = new SockJS("http://127.0.0.1:8083/echo");
		sock.onmessage = onMessage;
		sock.onclose = onClose;
		function sendMessage(obj) {
			sock.send($("#message").val());
			$("#message").val("");
		}
		function onMessage(msg) {
			console.log(msg);
			var data = msg.data;
			var userName = '${loginUser.sName}';
			var regM1 = /^({{[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+}})/; // {{한글/영어}} 추출 정규식
			var regM2 = /([a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+)/; // {{}} 에서 한글/영어 추출 정규식
			var key = regM1.exec(data); // msg에서 {{한글/영어}} 추출
			key = key[0];
			var sysMsg = regM2.exec(key); // key의 {{}}에서 한글/영어 추출
			sysMsg = sysMsg[0];
			data = data.replace(regM1, ""); // {{한글/영어}}를 제거한 메시지로 변환
			console.log(sysMsg);
			if (sysMsg == userName) {
				var $me = $("<li>");
				$me.addClass("me");
				var $entete = $("<div>");
				$entete.addClass("entete");
				var $h2 = $("<h2>");
				var $span = $("<span>");
				$span.addClass("status blue");
				var $triangle = $("<div>");
				$triangle.addClass("triangle");
				var $message = $("<div>");
				$message.addClass("message");
				var $p = $("<p>");

				$("#chat").append($me);
				$me.append($entete);
				$entete.append($h2);
				$h2.text(sysMsg);
				$entete.append($span);
				$me.append($triangle);
				$me.append($message);
				$message.append($p);
				$p.text(data);

			} else if (sysMsg == "entry") {
				var $entry = $("<li>");
				$entry.addClass("entry");
				var $p = $("<p>");
				$("#chat").append($entry);
				$entry.append($p);
				$p.text(data);
			} else {
				var $you = $("<li>");
				$you.addClass("you");
				var $entete = $("<div>");
				$entete.addClass("entete");
				var $h2 = $("<h2>");
				var $span = $("<span>");
				$span.addClass("status green");
				var $triangle = $("<div>");
				$triangle.addClass("triangle");
				var $message = $("<div>");
				$message.addClass("message");
				var $p = $("<p>");

				$("#chat").append($you);
				$you.append($entete);
				$entete.append($span);
				$entete.append($h2);
				$h2.text(sysMsg);
				$you.append($triangle);
				$you.append($message);
				$message.append($p);
				$p.text(data);
			}
		}
		function onClose() {
			console.log("연결끊김");
		}
	</script>
</body>

</html>
