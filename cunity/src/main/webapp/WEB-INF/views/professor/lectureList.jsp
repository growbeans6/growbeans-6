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
          <h1 class="h3 mb-2 text-gray-800">강의목록</h1>
          

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">강의</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>구분</th>
                      <th>강의명</th>
                      <th>강의실</th>
                      <th>강의요일</th>
                      <th>인원</th>
                      <th>수강생 목록</th>
                    </tr>
                  </thead>
                  <tbody style="text-align=center">
                  
                  <c:forEach items="${proLectureList }" var="list" varStatus="status">
                    <tr>
                      <td><input type="checkbox" aria-label="Checkbox for following text input"></td>
                      <td>${list.lName }</td>
                      <td>${list.lroom }</td>
                      <td>${list.lDay1 }(${list.lStartTime1},${list.lEndTime1}),${list.lDay2 }(${list.lStartTime2},${list.lEndTime2})</td>
                      <td>${list.lNumberStudent }</td>
                      <c:url value="/lStudentList" var="studentList1" >
                      <c:param name="lCode" value="${list.lcode }"/>
                      </c:url>
                      <td><a class="btn btn-secondary btn-sm" href="${studentList1 }">목록보기</a></td>
                    </tr>
                   </c:forEach> 
                   
                  </tbody>
                </table>
                <div>
                	<c:url value="/lectureInsert" var="lectureInsert"></c:url>
                    <a class="btn btn-secondary btn-sm" href="${lectureInsert }">추가</a>
                    <a class="btn btn-secondary btn-sm" href="#">삭제</a>
                    <c:url value="/lectureTime" var="lectureTime"/>
                    <a class="btn btn-secondary btn-sm" href="${lectureTime }">강의 시간표</a>
                </div>
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
