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
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
								${post.postWriterSNo} &nbsp;&nbsp; 작성일: ${post.postRegDate }</h6>
							<hr>
							<article>
								<div style="justify-content: center;">
									<ul>
											<div style="width: 100px; height: 100px;">
												<img src="${contextPath }/resources/nuploadFiles/${post.filePath}" style="width:100%; height:100%;" alt="">
											</div>
									</ul>
								</div>
								<p>${post.postContent }
								<h3></h3>
								</p>
							</article>
							<hr>

							<article></article>


							<hr>
							<div class="button_wrapper">
							
							<c:if test="${loginStudent.sNo eq post.postWriterSNo }">
							 <c:url var="updatePost" value="updatePost">
                  				<c:param name="postNo" value="${post.postNo}"/>
                  			</c:url>  
								<button onclick="location.href='updatePost'">글수정</button>
								<button onclick="location.href=#">글삭제</button>
							</c:if>
							</div>
							<hr>
							<div class="comment" style="margin-top: 10px;">
							<textarea rows="3" id="mentContent"
									style="float: left; width: 80%; margin-left: 80px;">
							</textarea>
								<button id="mentSubmit" class="btn-lg" onclick="addMent()"
									style="margin: 5px;">등록하기</button>
							</div>
						   <!-- <div id="addReply" class="comment"
								style="margin-top: 10px; display: none;">
								<textarea rows="3" id="mentReply"
									style="float: left; width: 80%; margin-left: 80px;">
								</textarea>
								<button id="mentSubmit" class="btn-lg"
									onclick="addReplySubmit()" style="margin: 5px;">대댓글
									등록하기</button>
							</div>  -->
							<br>
							<hr>
							<table id="commenttb" class="table">
								<thead>
									<tr>
										<td colspan="2"><b id="mentCount"></b></td>
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
			/* setInterval(function() {
				getpostCommentList();
			}, 100); */

			// 댓글 등록 ajax
			/* $("#mentSubmit").on("click", function() {
				
			}); */
		});

		function addMent() {
			var mentContent = $("#mentContent").val(); // 댓글의 내용
			var postNum = ${post.postNo}
			; // 어느 게시글의 댓글인지 알려줌

			$.ajax({
				url : "addPostComment",
				data : {
					mentContent : mentContent,
					postNo : postNum,
				},
				type : "post",
				success : function(data) {
					if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
						getPostCommentList();
						$("#mentContent").val("");
					}
				}
			});
		}
		
		/* function addReplySubmit() {
			var mentContent = $("#mentContent").val(); // 댓글의 내용
			var postNum = ${post.postNo}
			; // 어느 게시글의 댓글인지 알려줌
			var mentDepth = $rReply
			$.ajax({
				url : "addPostComment",
				data : {
					mentContent : mentContent,
					postNo : postNum,
				},
				type : "post",
				success : function(data) {
					if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
						getPostCommentList();
						$("#mentContent").val("");
					}
				}
			});
		} */


		/* function addReply(value) {
			$("#addReply").show();
		} */

		// 댓글 리스트 불러오는 ajax 함수
		function getPostCommentList() {
			var postNo = ${post.postNo};

			$.ajax({
						url : "postCommentList",
						data : {
							postNo : postNo
						},
						dataType : "json", // json형태로 응답이 옴
						success : function(data) {
							$tableBody = $("#commenttb tbody");
							$tableBody.html("");

							var $tr;
							/* var $rWriter; */
							var $rContent;
							/* var $rCreateDate; */
							/* $rReply; */

							$("#mentCount").text("댓글 (" + data.length + ")");
							if (data.length > 0) {
								for ( var i in data) {
									$tr = $("<tr>");
									/* $rWriter = $("<td width='100'>").text(
											data[i].mentWriter); */
									$rContent = $("<td>")
											.text(
													decodeURIComponent(data[i].mentContent
															.replace(/\+/g, " ")));
									 $rCreateDate = $("<td>").text(
											data[i].mentRegDate);
									/*  $rReply = $("<button style='float:right;' onclick='addReply()'; mentDepth='"
											+ data[i].mentDepth
											+ "');'>대댓글</button>"); */

									/* $tr.append($rWriter); */
									$tr.append($rContent);
									/* $tr.append($rCreateDate); */
									/* $tr.append($rReply); */
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
