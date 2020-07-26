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
<style type="text/css">
        #content_sub {
            width: 50%;
        }
        #content_writer {
            width: 10%;
        }
		#content_regDate {
            width: 15%;
        }
        #content_contoller {
            width: 15%;
        }
        .content_contoller {
            width: 15%;
            display:none;
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
                  				<c:param name="postNo" value="${post.postNo }"/>
                  			</c:url>  
                  			<c:url var="deletePost" value="deletePost">
                  				<c:param name="postNo" value="${post.postNo }"/>
                  			</c:url> 
								<button onclick="location.href='${updatePost}'">글수정</button>
								<button onclick="location.href='${deletePost }'">글삭제</button>
							</c:if>
							</div>
							<hr>
							<div class="comment" style="margin-top: 10px;">
							<textarea rows="3" id="mentContent" style="float: left; width: 80%; margin-left: 80px;"></textarea>
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
							<b id="mentCount"></b>
							<table id="commenttb" class="table">
								<thead>
									<tr>
										<th id="content_writer">작성자</th>
										<th id="content_sub">댓글내용</th>
										<th id="content_regDate">작성날짜</th>
										<c:if test="${loginStudent.sNo eq post.postWriterSNo && post.postKinds eq'스터디'}">
											<th id="content_controller">가입수락</th>
										</c:if>
										<th id="content_controller">수정</th>
										<th id="content_controller">삭제</th>
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
		<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>
	
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
			$("tbody").find(".content_controller").each(function(item,index) {
				var mentNo = $(this).parents("tr").eq(0).attr("mentNo");
				var loginSNo=${loginStudent.sNo};
				if(mentNo==loginSNo){
					$(this).css("display","block");
				}
			});
			
		});
		function joinStudy(obj){
			var studyNo=${loginStudent.studyNo};
			var sNo = $(obj).parents("tr").eq(0).attr("mentSNo");
			var postNum = ${post.postNo};
			$.ajax({
				url : "/acceptance",
				data : { 
					sNo : sNo,
					studyNo : studyNo,
					postNo : postNum
				},
				type : "post",
				success : function(data) {
					if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
						getPostCommentList();
						alert("가입을 수락하셨습니다.\n 스터디 멤버와 스터디룸에서 소통하세요!");
					}
				}
			});
			
		}
		function addMent() {
			var mentContent = $("#mentContent").val(); // 댓글의 내용
			var postNum = ${post.postNo};
			// 어느 게시글의 댓글인지 알려줌

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
						alert("댓글이 등록되었습니다.");
					}
				}
			});
		}
		function modifyMentShow(obj){
			$ment_tr = $(obj).parents("tr").eq(0);
			$modify_tr = $ment_tr.next("tr");
			$ment_tr.hide()
			$modify_tr.show();
		}
		function cancle(obj){
			$modify_tr = $(obj).parents("tr").eq(0);
			$ment_tr = $modify_tr.prev("tr");
			$ment_tr.show();
			$modify_tr.hide();
			
		}
		function modifyMent(obj) {
			var mentContent = $(obj).parents("tr").find("textarea").eq(0).val(); // 댓글의 내용
			var mentNo = $(obj).parents("tr").eq(0).attr("mentNo");
			var result = window.confirm("정말로 댓글을 수정하시겠습니까?");
			if(result){
				$.ajax({
					url : "modifyComment",
					data : { 
						mentContent : mentContent,
						mentNo : mentNo
					},
					type : "post",
					success : function(data) {
						if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
							alert("댓글이 수정되었습니다.");
							getPostCommentList();
						}
					}
				});
			} else{
				alert("댓글수정을 취소하셨습니다.");
			}
			
		}
		function deleteMent(obj) {
			var mentNo = $(obj).parents("tr").eq(0).attr("mentNo");
			var result = window.confirm("정말로 댓글삭제를 하시겠습니까?");
			if(result){
				$.ajax({
					url : "deleteComment",
					data : { 
						mentNo : mentNo
					},
					type : "post",
					success : function(data) {
						if (data == "success") { //data를 String으로 받아와서 성공, 실패만 가림
							alert("댓글이 삭제되었습니다.");
							getPostCommentList();
						}
					}
				});	
			} else{
				alert("댓글삭제를 취소하셨습니다.");
			}
			
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
									
								    $rWriter = $("<td>").text(
											data[i].mentWriter);
								    $mWriter = $("<td>").text(
											data[i].mentWriter);
									$rContent = $("<td class='rContent'>").text(decodeURIComponent(data[i].mentContent.replace(/\+/g, " ")));
									
									
									 $rCreateDate = $("<td>").text(
											data[i].mentRegDate);
									 $mCreateDate = $("<td>").text(
												data[i].mentRegDate);
									/*  $rReply = $("<button style='float:right;' onclick='addReply()'; mentDepth='"
											+ data[i].mentDepth
											+ "');'>대댓글</button>"); */
									// 가입수락 버튼 만들기
									$rApply = $("<td>");
									$rApply.attr("id","content_controller");
									$rApplyButton = $("<button>");
									$rApplyButton.attr("class","btn btn-primary"); 
									$rApplyButton.attr("onclick","joinStudy(this);"); 
									$rApplyButton.text("가입수락");
									var loginUser = ${loginStudent.sNo};
									var postWriter = ${post.postWriterSNo};
									var postKinds = '${post.postKinds}';
									if(loginUser==postWriter && postKinds=='스터디'){
										$rApply.append($rApplyButton);
									}
									$tr.attr("mentSNo",data[i].mentDepth);
									$tr.attr("mentNo",data[i].mentNo);
									
									$hide_tr = $("<tr style='display:none;'>");
									$modifyMent = $("<td id='content_sub'>");
									$textArea=$("<textarea style='float:left; width:80%; margin-left: 80px;' id='modifyMent'>");
									$textArea.val(decodeURIComponent(data[i].mentContent.replace(/\+/g, " ")));
								    $modifyMent.append($textArea);
									$controller1 = $("<td id='content_controller'>");
									$controller2 = $("<td id='content_controller'>");
									$modify_button=$("<button class='btn btn-primary' onclick='modifyMent(this);'>").text("수정완료");
									$cancle_button=$("<button class='btn btn-primary' onclick='cancle(this);'>").text("취소");
									$controller1.append($modify_button);
									$controller2.append($cancle_button);
									$hide_tr.append($mWriter);
									$hide_tr.append($modifyMent);
									$hide_tr.append($mCreateDate);
									$hide_tr.append($controller1);
									$hide_tr.append($controller2);
									$hide_tr.attr("mentNo",data[i].mentNo);
									
									$rModify=$("<td id='content_controller' class='modifyShowMent'>");
									$show_button=$("<button class='btn btn-primary' onclick='modifyMentShow(this);'>").text("수정");
									$rDelete=$("<td id='content_controller' class='deleteMent'>");
									$delete_button=$("<button class='btn btn-primary' onclick='deleteMent(this);'>").text("삭제");
									$rModify.append($show_button);
									$rDelete.append($delete_button);
									
									$tr.append($rWriter);
									$tr.append($rContent);
								    $tr.append($rCreateDate);
								    if(loginUser == data[i].mentDepth){
								    	$tr.append($rModify);
									    $tr.append($rDelete);
								    }
								    
								    
								    if(loginUser==postWriter && postKinds=='스터디'){
								   		$tr.append($rApply);
								    }
									/* $tr.append($rReply); */
									$tableBody.append($tr);
									$tableBody.append($hide_tr);
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
