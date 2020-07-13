<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

.img-area {
	padding: 20px;
}

.content-img {
	border: 1px solid lightgray;
	margin: 10px;
	width: 250px;
	height: 250px;
}

textarea {
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
					</div>

					<div class="row"></div>

					<div class="container">
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-lg-12" id="mentList">


							<!-- Default Card Example -->
							<div class="card mb-4">
								<div class="card-header">
									<div class="header">
										<img class="profile"
											src="/resources/img/${timeLine.filePath }">
										<div class="writer">
											<h5>${timeLine.postWriterSNo }${timeLine.postWriterSName }</h5>
											<span><i class="far fa-calendar-alt"></i>
												${timeLine.postRegDate }</span>
										</div>
									</div>
								</div>
								<div class="card-body">
									${timeLine.postContent}
									<div class="img-area row justify-content-center">
										<c:forEach var="img" items="${imgList }" varStatus="index">
											<div class="img-box">
												<img class="content-img"
													src="/resources/studyFiles/${img.imgName }">
											</div>
										</c:forEach>
										<!-- <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div>
                                        <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div>
                                        <div class="img-box"><img class="content-img" src="img/chipmunk.jpg"></div> -->
									</div>
								</div>
								<div class="card-footer">
									<a href="#" data-toggle="modal" data-target="#rWriteModal"><i
										class="fas fa-comment-dots"></i> 댓글달기</a> <a href="javascript:void(0);" onclick="copy('127.0.0.1:8084/boardDetail?postNo=${timeLine.postNo}');"><i
										class="fas fa-share"></i> 공유하기</a>
										<c:if test="${timeLine.postWriterSNo eq loginStudent.sNo}">
									<c:url value="/boardModifyForm" var="boardModifyForm">
										<c:param name="postNo" value="${timeLine.postNo}" />
									</c:url>
									<a href="${boardModifyForm }"><i class="fas fa-pencil-alt"></i>
										수정하기</a>
									<c:url value="/deleteTimeLine" var="deleteTimeLine">
										<c:param name="postNo" value="${timeLine.postNo}" />
									</c:url>
									<a href="${deleteTimeLine}"><i class="fas fa-trash-alt"></i>
										삭제하기</a>
										</c:if>
								</div>
								<div class="modal fade" id="rWriteModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title" id="exampleModalLabel">댓글 등록</h4>
											</div>
											<div id="mentWrite">
												<div class="modal-body">
													<form id="mentWriteForm" action="mentWrite" method="post">
														<div class="form-group">
															<label for="message-text" class="control-label">작성
																내용:</label>
															<textarea name="mentContent" id="mentContent" rows="5"
																class="form-control" id="message-text"></textarea>
															<input type="hidden" name="postNo" id="postNo"> <input
																type="hidden" name="mentWriter" id="mentWriter">
															<input type="hidden" name="mentDepth" id="mentDepth">
															<input type="hidden" name="mentFilePath" id="mentFilePath">
														</div>
													</form>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
													<button type="button" class="btn btn-primary"
														onclick="writeMent();">작성하기</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<hr>
							<div id="mentList">
								<c:forEach var="ment" items="${mentList }" varStatus="index">
									<div id="ment" class="card mb-4">
										<div class="card-header">
											<div class="header">
												<img class="profile" mentNo="${ment.mentNo }"
													mentDepth="${ment.mentDepth }"
													src="/resources/img/${ment.mentFilePath }">
												<div class="writer">
													<h5>${ment.mentWriter}</h5>
													<span><i class="far fa-calendar-alt"></i>
														${ment.mentRegDate}</span>
												</div>
											</div>
										</div>
										<div id="showComment">
											<div class="card-body">${ment.mentContent}</div>
											<div class="card-footer">
											<c:if test="${ment.mentDepth eq loginStudent.sNo }">
												<a id="rmodify" href="javascript:void(0);"
													onclick="rmodify(this);"><i class="fas fa-pencil-alt"></i><span>수정하기</span></a>
												<a id="rdelete" href="javascript:void(0);"
													onclick="rdelete(this);"><i
													class="fas fa-trash-alt"></i> <span>삭제하기</span></a></c:if>
											</div>
										</div>
										<div id="modifyComment" style="display: none;">
											<div class="card-body">
												<c:set var="mentContent"
													value="${fn:replace(ment.mentContent,'<br>','') }" />
												<textarea>${mentContent}</textarea>
											</div>
											<div class="card-footer">
												<a id="rmodify" href="javascript:void(0);"
													onclick="rupdate(this);"><i class="fas fa-pencil-alt"></i><span>수정완료</span></a>
												<a id="rcancle" href="javascript:void(0);"
													onclick="rcancle(this);"><i
													class="far fa-arrow-alt-circle-left"></i> <span>취소</span></a>
											</div>
										</div>
									</div>
								</c:forEach>
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
	<script>
		function copy(val) {
		  var dummy = document.createElement("textarea");
		  document.body.appendChild(dummy);
		  dummy.value = val;
		  dummy.select();
		  document.execCommand("copy");
		  document.body.removeChild(dummy);
		}
		function writeMent() {
			var postNo = ${timeLine.postNo};
			var mentWriter = "${loginStudent.sName}";
			var mentDepth = ${loginStudent.sNo};
			var mentFilePath = '${loginStudent.sFile}';
			$("#mentWriteForm").find("#postNo").val(postNo);
			$("#mentWriteForm").find("#mentWriter").val(mentWriter);
			$("#mentWriteForm").find("#mentDepth").val(mentDepth);
			$("#mentWriteForm").find("#mentFilePath").val(mentFilePath);
			$("#mentWriteForm").submit();
		} 
		function rmodify(obj) {
			$(obj).parents("div").eq(1).css("display", "none");
			$(obj).parents("div").eq(1).next().css("display", "block");
		}
		function rcancle(obj) {
			$(obj).parents("div").eq(1).css("display", "none");
			$(obj).parents("div").eq(1).prev().css("display", "block");
		}
		
		function rupdate(obj) {
			$modifyComment = $(obj).parents("div").eq(1);
			$showComment = $(obj).parents("div").eq(1).prev();
			var mentContent = $modifyComment.find("textarea").val();
			var mentNo = $showComment.prev("div").find("img").attr("mentNo");
			$.ajax({
				url:"/mentUpdate",
				data:{mentContent:mentContent,mentNo:mentNo},
				type:"post",
				success: function(data){
					if(data=="success"){
						alert("댓글이 수정되었습니다.");
						mentContent = mentContent.replace(/\n/gi,"<br>");
						$showComment.find(".card-body").eq(0).html(mentContent);
						rcancle(obj);
					}
				}
			});
		}
		function rdelete(obj) {
			var $ment = $(obj).parents("#ment").eq(0);
			var mentNo = $ment.find("img").attr("mentNo");
			$.ajax({
				url:"/mentDelete",
				data:{mentNo:mentNo},
				type:"get",
				success: function(data){
					if(data=="success"){
						alert("댓글이 삭제 되었습니다.");
						$ment.remove();
					}
				}
			});
		}
	</script>
</body>

</html>
