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
					<section>
					<div class="container">
						<h3>${post.postCategory }게시판</h3>
						<hr>
						<h2>제목 : ${post.postSubject }</h2>
						<h6>글번호 : ${post.postNo} &nbsp;&nbsp; 작성자 :
							${post.postWriter} &nbsp;&nbsp; 작성일: ${post.postRegDate }</h6>
						<hr>
						<article>
						<h3>갤러리</h3>
						<div style="justify-content: center;">
							<ul>
								<li>
									<div style="width: 200px; height: 200px;">
										<img src="" alt="이미지 단">
									</div>
								</li>
							</ul>
						</div>
						<p>${post.postContent }
						<h3></h3>
						</p>
						</article>
						<hr>

						<article> </article>


						<hr>
						<div class="button_wrapper">
							<button>글수정</button>
							<button>글삭제</button>
						</div>
						<hr>
						<div class="comment" style="margin-top: 10px;">
							<form>
								<textarea rows="3" id="rContent"
									style="float: left; width: 80%; margin-left: 80px;">
								</textarea>
								<button id="rSubmit" class="btn-lg" type="submit"
									style="margin: 5px;">등록하기</button>
							</form>
						</div>
						<br>
						<hr>
						<table id="commenttb" class="table">
							<thead>
								<tr>
									<td colspan="2"><b id="rCount"></b></td>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>

					</section>
				</div>
			</div>
			<!-- End of Main Content -->
			<!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<script>
		$(function() {
			// 초기 페이지 로딩 시 댓글 불러오기
			getPostCommentList();
			// ajax polling
			//타 회원이 댓글들을 작성했을 수 있으니 지속적으로 댓글 불러오기
			setInterval(function() {
				getReplyList();
			}, 100);

			// 댓글 등록 ajax
			$("#rSubmit").on("click", function() {
				var rContent = $("#rContent").val(); // 댓글의 내용
				var refpNo = $
				{
					post.postNo
				}
				; // 어느 게시글의 댓글인지 알려줌

				$.ajax({
					url : "addPostComment",
					data : {
						rContent : rContent,
						refpNo : refpNo
					},
					type : "post",
					success : function(data) {
						if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
							getPostCommentList();
							$("#rContent").val("");
						}
					}
				})
			});
		});

		// 댓글 리스트 불러오는 ajax 함수
		function getpostCommentList() {
			var pNo = ${
				post.postNo
			};
			
			$.ajax({
						url : "postCommentList",
						data : {
							pNo : pNo
						},
						dataType : "json", // json형태로 응답이 옴
						success : function(data) {
							$tableBody = $("#commenttb tbody");
							$tableBody.html("");

							var $tr;
							var $rWriter;
							var $rContent;
							var $rCreateDate;
							
							$("#rCount").text("댓글 (" + data.length + ")");
							if (data.length > 0) {
								for ( var i in data) {
									$tr = $("<tr>");
									$rWriter = $("<td width='100'>").text(
											data[i].mentWriter);
									$rContent = $("<td>").text(
											decodeURIComponent(data[i].mentContent
													.replace(/\+/g, " ")));
									$rCreateDate = $("<td width='100'>").text(
											data[i].mentRegDate);

									$tr.append($rWriter);
									$tr.append($rContent);
									$tr.append($rCreateDate);
									$tableBody.append($tr);
								}
							} else {
								$tr = $("<tr>");
								$rContent = $("<td colspan='3'>").text(
										"등록된 댓글이 없습니다.");

								$tr.append($rContent);
								$tableBody.append($tr);
							}
						}
					})
		}
	</script>
</body>

</html>