<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
        <title>커뮤니티 글 작성</title>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
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
						<span class="head">
							<h3>게시글 작성</h3>
						</span>
						<hr>
						<div class="col-sm-12 col-md-12">
						
						
							<form action="insertPost" method="post" enctype="multipart/form-data">
								<label for="subject">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</label>
								<input type="text" id="subject" name="postSubject" size="20px;"
									placeholder="제목을 입력해주세요">
								<fieldset>
								<!-- 로그인 되어 있지 않기에 그냥 넣는.. -->
								<input type="hidden" name="postWriterSNo" value="${post.postWriterSNo }">
								<input type="hidden" name="postWriterSName" value="${post.postWriterSName }">
								
									<label for="postKinds">게시판종류</label> 
									<div>
										<p>${post.postKinds }</p>
									</div>
								</fieldset>
								
								<c:if test="${!empty post.postCategory }">
									<fieldset id="postCategory">
										<label for="postCategory">자유게시판 말머리</label> 
										<select
											id="postCategory" name="postCategory">
											<option value="잡담">잡담</option>
											<option value="학교정보">학교정보</option>
											<option value="맛집">맛집</option>
										</select>
									</fieldset>
								</c:if>
								<div class="row">
									<div class="col-1"
										style="text-align: center; padding-bottom: 20px;">
										<div id="img-box"
											style="width: 70%; height: 70%; margin: 30px auto; float: right;">
											<input type="file" name="reloadFile"> 
												<c:if test="${ !empty post.filePath }">
														<a href="${contextPath }/resources/nuploadFiles/${post.filePath }">
															${post.filePath } </a>
												</c:if>
											
										</div>
										<br> 
										<button style="margin-top: 5px;" id="remove">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
									</div>
								</div>
								<br>
								<hr>
								<label for="content">내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</label><br>
								<textarea id="summernote" name="postContent" class="summernote">${post.postContent }</textarea> 
								<br> <input id="reset" class="button" type="reset">
								<span class="buttonspan">
								<input id="submit"
									class="button" type="submit" value="작성하기"></span>

							</form>
						</div>
					</div>
					<br>
					<br>
					<br>
					</section>
					<footer> </footer>
					<script>
					
						$('#postKinds').change(function() {
							var check = $('#postKinds option:selected').val();
							if ( check == '자유' ) {
								jQuery('#postCategory').show();
							} else {
								jQuery('#postCategory').hide();
							}
						});
					
					      $('#summernote').summernote({
					        placeholder: '내용을 작성해주세요',
					        tabsize: 2,
					        height: 120,
					        toolbar: [
					          ['style', ['style']],
					          ['font', ['bold', 'underline', 'clear']],
					          ['color', ['color']],
					          ['para', ['ul', 'ol', 'paragraph']],
					          ['view', ['fullscreen']],
					        ]
					      });
					      
					      $('#image').on('change', function() {
					
					          ext = $(this).val().split('.').pop().toLowerCase(); //확장자
					
					          //배열에 추출한 확장자가 존재하는지 체크
					          if ($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
					              resetFormElement($(this)); //폼 초기화
					              window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
					          } else {
					              file = $('#image').prop("files")[0];
					              blobURL = window.URL.createObjectURL(file);
					              $('#img-box img').eq(0).attr('src', blobURL);
					              $('#img-box img').eq(0).attr('style', "width:100px;");
					              $('#img-box img').eq(0).attr('style', "height:100px;");
					              $('#img-box').eq(0).slideDown(); //업로드한 이미지 미리보기 
					              $(this).slideUp(); //파일 양식 감춤
					          }
					      });
		
					      
					      $('#remove').click(function(e) {
					          e.preventDefault();
					          $("#image").val("");
					          $('#img-box img').attr('src', '/img/logo.png');
					      });
					     
    </script>
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

	<!-- Page level plugins -->
	<script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/resources/js/demo/datatables-demo.js"></script>
</body>

</html>
