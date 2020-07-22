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
/* 	.dnContent {
		width : 90%;
		height : 70%;
		border : 1px;
		!important
	} */
</style>
<script>
	
/* 
	function aa() {
		alert("등록되었습니다.");
	} */
</script>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
	<jsp:include page="../professorwrapper.jsp"></jsp:include>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
      <!-- Main Content -->
      <div id="content">

       <jsp:include page="../professorcontent-wrapper.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <!-- 페이지에 들어갈 부분을 container-fluid에 넣어주시면 됩니다. -->
         <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">학과공지</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">학과공지 게시판</h6>
            </div>
            <form action="/dNoticeInsert" method="post" enctype="multipart/form-data" name="form1">
              <div class="input-group mb-3" style="width:52.5%">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">제목</span>
                </div>
                <textarea class="form-control" id="basic-addon1" name="dnTitle" style="height:40px;resize:none;width:200px;font-weight: bold;color:black;" oninvalid="this.setCustomValidity('제목을 작성하세요.')"
                	oninput = "setCustomValidity('')"  required></textarea>
              </div>
              <div class="input-group" style="width:65%">
                  <div class="input-group-prepend">
                    <span class="input-group-text">내용</span>
                  </div>
                  <div id="textarea">
                  	<textarea id="content" class="form-control" style="resize:none;height:700px;width:800px;color:black;" aria-label="With textarea" name="dnContent" oninvalid="this.setCustomValidity('내용을 작성하세요.')" 
                  	oninput = "setCustomValidity('')" required></textarea>
                  </div>
              </div>
              <br>
              <input type="file" name="uploadFile"/>
              
                <div>
                    <%-- <button type="submit">등록하기</button>
                    <c:url var="dNoticeList" value="/dNoticeList"></c:url>
                    <button class="btn btn-secondary btn-sm" onclick="fnCancel()" >취소</button> --%>
                    <br>
                    <input id="check" type="submit" onclick="aa();" class="btn btn-primary btn-md"  value="등록하기"/>
                    <!-- <input id="btncheck" class="btn btn-secondary btn-sm" type=submit value="등록하기" onClick="check()"> -->
                   <!--  <button type="button" id="btncheck">등록하기</button> -->
					<c:url var="dNoticeList" value="/dNoticeList"></c:url>
					<a class="btn btn-secondary btn-md" href="${dNoticeList }">취소</a>
                </div>
            </form>
              </div>
            </div>
          </div>
        </div>
        <!-- /.container-fluid -->

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
  <script src="/resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="/resources/js/demo/chart-area-demo.js"></script>
  <script src="/resources/js/demo/chart-pie-demo.js"></script>
</body>

</html>
