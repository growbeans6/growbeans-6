<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<style>
div{
overflow : hidden;
}
tr{
text-align:center;
}
</style>

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
        <!-- Begin Page Content -->
        <!-- Begin Page Content -->
<div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">성적 조회</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">오주현님 성적</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>이수구분</th>
                      <th>과목명</th>
                      <th>교수명</th>
                      <th>학점</th>
                      <th>과목코드</th>
                      <th>등급</th>
                      <th>평점</th>
                      <th>강의평가</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                     <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                     <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                     <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                     <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                     <tr>
                      <td>전공필수</td>
                      <td>Java</td>
                      <td>민봉식</td>
                      <td>3</td>
                      <td>123515</td>
                      <td>A+</td>
                      <td>4.5</td>
                      <td><button class="btn btn-secondary">평가하기</button></td>
                    </tr>
                    
                    <tr>
                        <th colspan="8">신청학점 : 15 이수학점 : 15 총 평점 : 4.5</th>
                    </tr>
                  </tbody>
                </table>
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
