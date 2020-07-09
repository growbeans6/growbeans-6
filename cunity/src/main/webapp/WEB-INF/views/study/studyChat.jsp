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
	height: 850px;
	background-color: #3b3e49;
	display: inline-block;
	font-size: 15px;
	vertical-align: top;
}

main {
	border: 1px solid lightgray;
	width: 1200px;
	height: 850px;
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
	width: 80px;
	height: 80px;
	border-radius: 100%;
	margin-left: 20px;
	margin-right: 8px;
	border: 4px solid gray;
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
	margin-left: 30px;
	margin-top: 5px;
	display: inline-block;
}

main footer select {
	margin-top : 10px;
	margin-left : 900px;
	float:right;
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
					<ul id="chatMember">
						<c:forEach var="studentMember" items="${studyMemberList }"
							varStatus="status">
							<li><img src="/resources/img/${studentMember.sFile }" alt="">
								<div>
									<h2>${studentMember.sName }</h2>
									<h3 class="row" id="sNo${studentMember.sNo }">
										&nbsp&nbsp&nbsp <span class="status orange"></span>
										<p>offline</p>
									</h3>
								</div></li>
						</c:forEach>
					</ul>
					</aside>
					<main> <header>
					<h1>ChatRoom</h1>
					</header>
					<ul id="chat">
						
					</ul>
					<footer> 
						 
					<div class="row">
					<textarea id="message"
						placeholder="Type your message"></textarea>
						<select id="selectUser">
							<option value="all">전체</option>
							<c:forEach var="studyMember"  items="${studyMemberList }" varStatus="index">
								<c:if test="${studyMember.sNo ne loginUser.sNo }">
									<option value="${studyMember.sNo }">${studyMember.sName }</option>
								</c:if>
							</c:forEach>
						
						</select>
						<a href="javascript:void(0);" onclick="sendMessage(this);" class="btn btn-primary btn-lg">Send</a>
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
		let sock = new SockJS("http://127.0.0.1:8084/echo");
		sock.onmessage = onMessage;
		sock.onclose = onClose;
		$(document).ready(function() {
			$("#chat").scrollTop($("#chat").scrollHeight);
		});
		function sendMessage(obj) {
			var text = $("#message").val();
			var user = $("#selectUser option:selected").val();
			if(user == "all"){
				sock.send($("#message").val());
			} else{
				sock.send("{{whisper}}"+"<<<"+user+">>>"+text);
			}
			
			$("#message").val("");
		}
		function onMessage(msg) {
			console.log(msg);
			var data = msg.data;
			var userName = '${loginUser.sName}';
			var regM1 = /^({{[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+}})/; // {{한글/영어}} 추출 정규식
			var regM2 = /([a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+)/; // 한글/영어 추출 정규식
			var regM3 = /^(<<<[0-9]+>>>)/; // <<<숫자>>> 추출 정규식
			var regM4 = /([0-9]+)/; // <<<숫자>>> 추출 정규식
			
			var key = regM1.exec(data); // msg에서 {{한글/영어}} 추출
			key = key[0];
			var sysMsg = regM2.exec(key); // key의 {{}}에서 한글/영어 추출
			sysMsg = sysMsg[0];
			data = data.replace(regM1, ""); // {{한글/영어}}를 제거한 메시지로 변환
			console.log(sysMsg);
			
			if (sysMsg == userName) {
				var whisMsg = regM1.exec(data);
				if(whisMsg!=null){
					whisMsg = whisMsg[0];
				}
				if(whisMsg=="{{whisper}}"){
					data = data.replace(regM1, "");
					var wUser = regM3.exec(data);
					wUser = wUser[0];
					wUser = regM4.exec(wUser);
					wUser = wUser[0];
					var loginNo = ${loginUser.sNo};
					var whisName = $("#selectUser option:selected").text();
					data = data.replace(regM3, "");
					data = "<p>[귓속말 : "+whisName+"]</p>" + data;
				}
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

				$("#chat").append($me);
				$me.append($entete);
				$entete.append($h2);
				$h2.text(sysMsg);
				$entete.append($span);
				$me.append($triangle);
				$me.append($message);
				$message.html(data);

			} else if (sysMsg == "entryIn") {
				var studyNo = ${loginUser.studyNo};
				var $entry = $("<li>");
				$entry.addClass("entry");
				var $p = $("<p>");
				$("#chat").append($entry);
				$entry.append($p);
				$p.text(data);
				$.ajax({
					url : "/rMember",
					data : {
						studyNo : studyNo
					},
					dataType : "json",
					cache : false,
					success : function(data) {
						console.log(data.length);
						if (data.length > 0) {
							for (i in data) {
								console.log(data[i].studentNo);
								var $h3 = $("#sNo" + data[i].studentNo);
								$h3.children("span").attr("class",
										"status green");
								$h3.children("p").text("online");
							}

						}

					}
				});

			} else if (sysMsg == "entryOut") {
				
				var studyNo = ${loginUser.studyNo};
				var $entry = $("<li>");
				$entry.addClass("entry");
				var $p = $("<p>");
				$("#chat").append($entry);
				$entry.append($p);
				$p.text(data);
				$.ajax({
					url : "/rMember",
					data : {
						studyNo : studyNo
					},
					dataType : "json",
					cache : false,
					success : function(data) {
						console.log(data.length);
						var $h3;
						if (data.length > 0) {
							$("#chatMember").find("h3").each(function(index, item) {
								console.log(index);
								$h3= $(this);
								var text = $h3.text();
								console.log(text);
								$h3.children("span").attr("class","status orange");
								$h3.children("p").text("offline");
							});
							for (i in data) {		
								console.log(data[i].studentNo);
							    $h3 = $("#sNo" + data[i].studentNo);
								$h3.children("span").attr("class","status green");
								$h3.children("p").text("online");								
							}
						}

					}
				});

			} else {
				var whisMsg = regM1.exec(data);
				if(whisMsg!=null){
					whisMsg = whisMsg[0];
				}
				if(whisMsg=="{{whisper}}"){
					data = data.replace(regM1, "");
					var wUser = regM3.exec(data);
					wUser = wUser[0];
					wUser = regM4.exec(wUser);
					wUser = wUser[0];
					var loginNo = ${loginUser.sNo};
					data = data.replace(regM3, "");
					data = "<p>[귓속말]</p>" + data;
					if(wUser!=loginNo){
						return;
					}
				}
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
				$("#chat").append($you);
				$you.append($entete);
				$entete.append($span);
				$entete.append($h2);
				$h2.text(sysMsg);
				$you.append($triangle);
				$you.append($message);
				$message.html(data);
			}
			$("#chat").scrollTop($("#chat")[0].scrollHeight);
		}
		function onClose() {
			console.log("연결끊김");
		}
	</script>
</body>

</html>
