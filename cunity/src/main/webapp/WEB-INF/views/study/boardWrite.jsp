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
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">스터디 보드</h1>
					</div>

					<div class="row"></div>

					<div class="container">
						<form>
							<div class="col-lg-12">


								<!-- Default Card Example -->
								<div class="card mb-4">
									<div class="card-header">
										<div class="header">
											<img class="profile" src="img/chipmunk.jpg">
											<div class="writer">
												<h5>이승원</h5>
												<span><i class="far fa-calendar-alt"></i> 2020-07-03</span>
											</div>
										</div>
									</div>
									<div class="card-body">
										<div id="writeTextarea"></div>

									</div>
									<div class="card-footer">
										<a href="#"><i class="fas fa-pencil-alt"></i> 작성하기</a>&nbsp; <a
											href="javascript:void(0);" onclick="addImage();"><i
											class="far fa-images"></i> 이미지 추가하기</a>
									</div>
								</div>
								<div class="card mb-4">
									<div class="card-header">
										<div id="filebox1" class="filebox" style="display: none;">
											<input id="upload-name1" class="upload-name" value="파일선택"
												disabled="disabled"> <label for="image1"
												class="image-label">업로드</label> <input type="file"
												id="image1" class="upload-hidden" disabled="disabled">
											<button class="btn btn-success" id="remove1">취소</button>
											&nbsp;&nbsp;<a id="close_link" href="javascript:void(0);"
												onclick="removeImage1();"><i
												class="far fa-2x fa-times-circle"></i></a>

										</div>
										<div id="filebox2" class="filebox" style="display: none">
											<input id="upload-name2" class="upload-name" value="파일선택"
												disabled="disabled"> <label for="image2"
												class="image-label">업로드</label> <input type="file"
												id="image2" class="upload-hidden" disabled="disabled">
											<button class="btn btn-success" id="remove2">취소</button>
											&nbsp;&nbsp;<a id="close_link" href="javascript:void(0);"
												onclick="removeImage2();"><i
												class="far fa-2x fa-times-circle"></i></a>
										</div>
										<div id="filebox3" class="filebox" style="display: none">
											<input id="upload-name3" class="upload-name" value="파일선택"
												disabled="disabled"> <label for="image3"
												class="image-label">업로드</label> <input type="file"
												id="image3" class="upload-hidden" disabled="disabled">
											<button class="btn btn-success" id="remove3">취소</button>
											&nbsp;&nbsp;<a id="close_link" href="javascript:void(0);"
												onclick="removeImage3();"><i
												class="far fa-2x fa-times-circle"></i></a>
										</div>
									</div>
									<div class="card-body row">
										<div id="img-box1" class="img-box"
											style="height: 70%; margin: 30px auto; display: none">
											<img src="/img/chipmunk.jpg" id="input-img" />
										</div>
										<div id="img-box2" class="img-box"
											style="height: 70%; margin: 30px auto; display: none">
											<img src="/img/chipmunk.jpg" id="input-img" />
										</div>
										<div id="img-box3" class="img-box"
											style="height: 70%; margin: 30px auto; display: none">
											<img src="/img/chipmunk.jpg" id="input-img" />
										</div>
									</div>
								</div>

							</div>
						</form>
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
		var count = 0;
		var image = 0;
		$(document).ready(function() {
			$('#writeTextarea').attr('contentEditable', 'true');

		});

		function addImage() {
			if (count < 3 && image == 0) {
				$("#filebox1").css("display", "block");
				$("#img-box1").css("display", "block");
				$("#image1").removeAttr("disabled");
				count++;
				image = 1;
				var status1 = $("#image2").attr("disabled");
				if (!status1) {
					image = 2;

				}
				console.log(image);
			} else if (count < 3 && image == 1) {
				$("#filebox2").css("display", "block");
				$("#img-box2").css("display", "block");
				$("#image2").removeAttr("disabled");
				count++;
				image = 2;
				var status = $("#image1").attr("disabled");
				if (status) {
					image = 0;
				}
			} else if (count < 3 && image == 2) {
				$("#filebox3").css("display", "block");
				$("#img-box3").css("display", "block");
				$("#image3").removeAttr("disabled");
				count++;
				image = 0;
				var status = $("#image2").attr("disabled");
				if (status) {
					image = 1;
				}
			} else {
				alert("이미지는 3개까지 추가할 수 있습니다.");
			}
		}

		function removeImage1() {

			$("#filebox1").css("display", "none");
			$("#img-box1").css("display", "none");
			$("#image1").attr("disabled", true);
			$("#image1").val("");
			$('#upload-name1').val("파일선택");
			$('#img-box1 img').attr("src", '/img/chipmunk.jpg');
			count--;
			image = 0;
		}

		function removeImage2() {

			$("#filebox2").css("display", "none");
			$("#img-box2").css("display", "none");
			$("#image2").attr("disabled", true);
			$("#image2").val("");
			$('#upload-name2').val("파일선택");
			$('#img-box2 img').attr("src", '/img/chipmunk.jpg');
			count--;
			image = 1;
		}

		function removeImage3() {

			$("#filebox3").css("display", "none");
			$("#img-box3").css("display", "none");
			$("#image3").attr("disabled", true);
			$("#image3").val("");
			$('#upload-name3').val("파일선택");
			$('#img-box3 img').attr("src", '/img/chipmunk.jpg');
			count--;
			image = 2;
			var status = $("#image1").attr("disabled");
			if (status) {
				image = 0;
			}
		}

		$('#image1').on('change', function() {
			var name = $(this).val().split('/').pop().split('\\').pop();
			ext = $(this).val().split('.').pop().toLowerCase(); //확장자
			//배열에 추출한 확장자가 존재하는지 체크
			if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
				$("#image1").val("");
				window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
			} else {
				file = $('#image1').prop("files")[0];
				blobURL = window.URL.createObjectURL(file);
				$('#img-box1 img').attr('src', blobURL);
				$('#img-box1').slideDown(); //업로드한 이미지 미리보기 
				$('#upload-name1').val(name);
			}
		});
		$('#remove1').click(function(e) {
			e.preventDefault();
			$("#image1").val("");
			$('#upload-name1').val("파일선택");
			$('#img-box1 img').attr('src', '/img/chipmunk.jpg');
		});
		$('#image2').on('change', function() {
			var name = $(this).val().split('/').pop().split('\\').pop();
			ext = $(this).val().split('.').pop().toLowerCase(); //확장자
			//배열에 추출한 확장자가 존재하는지 체크
			if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
				$("#image2").val("");
				window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
			} else {
				file = $('#image2').prop("files")[0];
				blobURL = window.URL.createObjectURL(file);
				$('#img-box2 img').attr('src', blobURL);
				$('#img-box2').slideDown(); //업로드한 이미지 미리보기 
				$('#upload-name2').val(name);
			}
		});
		$('#remove2').click(function(e) {
			e.preventDefault();
			$("#image2").val("");
			$('#upload-name2').val("파일선택");
			$('#img-box2 img').attr('src', '/img/chipmunk.jpg');
		});
		$('#image3').on('change', function() {
			var name = $(this).val().split('/').pop().split('\\').pop();
			ext = $(this).val().split('.').pop().toLowerCase(); //확장자
			//배열에 추출한 확장자가 존재하는지 체크
			if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
				$("#image3").val("");
				window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
			} else {
				file = $('#image3').prop("files")[0];
				blobURL = window.URL.createObjectURL(file);
				$('#img-box3 img').attr('src', blobURL);
				$('#img-box3').slideDown(); //업로드한 이미지 미리보기 
				$('#upload-name3').val(name);
			}
		});
		$('#remove3').click(function(e) {
			e.preventDefault();
			$("#image3").val("");
			$('#upload-name3').val("파일선택");
			$('#img-box3 img').attr('src', '/img/chipmunk.jpg');
		});
	</script>
</body>

</html>