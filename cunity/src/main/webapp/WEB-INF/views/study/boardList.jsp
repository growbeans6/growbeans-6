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

<title>타임라인 리스트</title>

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
						<h3>타임라인은 30개까지만 저장됩니다.</h3>
						<c:url value="/study-timeline/board/write" var="boardWriteForm"></c:url>
						<div style="position:fixed;top:150px;left:250px;z-index:10;"><a href="javascript:void(0);" onclick="toggleMenu();"><h3><i class="fas fa-bars"></i>&nbsp <b>MENU</b></h3></a>
							<div id="toggleArea" class="card  shadow h-100 p-2" style="display:none;">
							<br>
							<h4 ><a href="${boardWriteForm }"><i class="fas fa-pencil-alt"></i>&nbsp작성하러가기</a></h4><br>
							<h4 ><a href="#" data-toggle="modal" data-target="#rWriteModal${loginStudent.sNo }"><i class="fab fa-readme"></i>&nbsp내가 쓴 글 보기</a></h4><br>
							<h4 ><a href="/chatRoom"><i class="fas fa-comments"></i>&nbsp채팅방으로 가기</a></h4><br>
							<h4 ><a href="studyfileShare"><i class="fas fa-file"></i>&nbsp파일공유 하러가기</a></h4><br>
							<h4 ><a href="javascript:void(0);"><i class="fas fa-user-times"></i>&nbsp스터디 탈퇴하기</a></h4><br>
							
							</div>
						</div>
						
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
														<figure> <a href="#" data-toggle="modal" data-target="#rWriteModal${studyMember.sNo }"><img id="member_profile" class="profile mb-2"
															src="/resources/img/${studyMember.sFile }" studentNo="${studyMember.sNo }"></a> <figcaption>${studyMember.sName }</figcaption>
														</figure>
													</div>
													
														<!-- 다이얼로그 -->
									<div class="modal fade" id="rWriteModal${studyMember.sNo }" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title" id="exampleModalLabel">${studyMember.sNo }${studyMember.sName }님의 타임라인</h4>
											</div>
											<div id="mentWrite">
												<div class="modal-body">
													<!-- <form id="mentWriteForm" action="mentWrite" method="post"> -->
														<div class="form-group">
												<c:forEach var="timeLine" items="${pList }" varStatus="index">
					
														<c:if test="${studyMember.sNo eq timeLine.postWriterSNo}">		
								<div class="card shadow mb-4">
									<div class="card-header">
										<div class="header">
											<img class="profile" src="/resources/img/${timeLine.filePath }">
											<div class="writer"><h5>${timeLine.postWriterSNo }${timeLine.postWriterSName }</h5>
												<span><i class="far fa-calendar-alt"></i> ${timeLine.postRegDate }</span>
											</div>
										</div>
									</div>
									<div class="card-body" id="card-body">${timeLine.postContent }</div>
									<div class="card-footer">
										<c:url value="/study-timeline/board/${timeLine.postNo }" var="boardDetail">
											
										</c:url>
										<a href="${boardDetail }"><i class="fab fa-readme"></i> 상세보기</a> <a href="javascript:void(0);" onclick="copy('http://127.0.0.1:8084${boardDetail }');"><i
											class="fas fa-share"></i> 공유하기</a>
									</div>
								</div>
								</c:if>
													</c:forEach>
						
														</div>
													<!-- </form> -->
												</div>
												<div class="modal-footer">
													<button id="closeButton" type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 다이얼로그 -->
														
												</c:forEach>
									
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-12">

							<c:forEach var="timeLine" items="${pList }" varStatus="index">
								<div class="card shadow mb-4">
									<div class="card-header">
										<div class="header">
											<img class="profile" src="/resources/img/${timeLine.filePath }">
											<div class="writer">
												<h5><b>${timeLine.postWriterSNo }${timeLine.postWriterSName }<b></h5>
												<span><b><i class="far fa-calendar-alt"></i> ${timeLine.postRegDate }<b></span>
											</div>
										</div>
									</div>
									<div class="card-body" id="card-body">${timeLine.postContent }</div>
									<div class="card-footer">
										<c:url value="/study-timeline/board/${timeLine.postNo }" var="boardDetail">
											
										</c:url>
										<a href="${boardDetail }"><i class="fab fa-readme"></i> 상세보기</a> <a href="javascript:void(0);" onclick="copy('http://127.0.0.1:8084${boardDetail }');"><i
											class="fas fa-share"></i> 공유하기</a>
									</div>
								</div>
							</c:forEach>

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
	$(document).ready(function(){
		getMemberList();
	});
	function toggleMenu() {
		$("#toggleArea").toggle();
	}
	function copy(val) {
		  var dummy = document.createElement("textarea");
		  document.body.appendChild(dummy);
		  dummy.value = val;
		  dummy.select();
		  document.execCommand("copy");
		  document.body.removeChild(dummy);
		  alert("클립보드에 복사되었습니다.");
		}
	function getMemberList() {
		var studyNo=${loginStudent.studyNo};
		$.ajax({
			url:"/study-timeline/board/study-member/"+studyNo,
			data:{},
			dataType : "json",
			type:"get",
			cache:false,
			success: function(data){
				$("#profile-area img").each(function(index, item) {
					var studentNo = $(this).attr("studentNo");
					var status = false;
					console.log(index+"번째 프로필");
					
					if(data.length > 0){
						for(var i=0;i<data.length;i++){
						
							if(studentNo == data[i].sNo){
								status = true;
							}
						}
					}
					if(status){
						$(this).attr("class","profile_update mb-2");
					}
				});
			}
		});
	}
	</script>
</body>

</html>
