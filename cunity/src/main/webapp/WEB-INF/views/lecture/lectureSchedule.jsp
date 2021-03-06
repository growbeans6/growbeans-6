<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<style>

tr{
text-align:center;
}
div{
overflow : hidden;
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
         <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">시간표 조회</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">${sName}님 시간표</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>

                    <tr>
                      <th></th>
                      <th>월</th>
                      <th>화</th>
                      <th>수</th>
                      <th>목</th>
                      <th>금</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                    <tr>
                      <td>1</td>
                      <td>${timetable.mon1 }</td> 
                      <td>${timetable.tue1 }</td>
                      <td>${timetable.wed1 }</td>
                      <td>${timetable.tur1 }</td>
                      <td>${timetable.fri1 }</td>
                    </tr>
                    
                    <tr>
                      <td>2</td>
                      <td>${timetable.mon2 }</td>
                      <td>${timetable.tue2 }</td>
                      <td>${timetable.wed2 }</td>
                      <td>${timetable.tur2 }</td>
                      <td>${timetable.fri2 }</td>
                    </tr>
                    
                    <tr>
                      <td>3</td>
                      <td>${timetable.mon3 }</td> <!-- 월1 -->
                      <td>${timetable.tue3 }</td> <!-- 화1 -->
                      <td>${timetable.wed3 }</td>
                      <td>${timetable.tur3 }</td>
                      <td>${timetable.fri3 }</td>
                    </tr>
                    
                    <tr>
                      <td>4</td>
                      <td>${timetable.mon4 }</td> <!-- 월1 -->
                      <td>${timetable.tue4 }</td> <!-- 화1 -->
                      <td>${timetable.wed4 }</td>
                      <td>${timetable.tur4 }</td>
                      <td>${timetable.fri4 }</td>
                    </tr>
                    
                     <tr>
                      <td>5</td>
                      <td>${timetable.mon5 }</td> <!-- 월1 -->
                      <td>${timetable.tue5 }</td> <!-- 화1 -->
                      <td>${timetable.wed5 }</td>
                      <td>${timetable.tur5 }</td>
                      <td>${timetable.fri5 }</td>
                    </tr>
                    
                    <tr>
                      <td>6</td>
                      <td>${timetable.mon6 }</td> <!-- 월1 -->
                      <td>${timetable.tue6 }</td> <!-- 화1 -->
                      <td>${timetable.wed6 }</td>
                      <td>${timetable.tur6 }</td>
                      <td>${timetable.fri6 }</td>
                    </tr>
                    
                    <tr>
                      <td>7</td>
                      <td>${timetable.mon7 }</td> <!-- 월1 -->
                      <td>${timetable.tue7 }</td> <!-- 화1 -->
                      <td>${timetable.wed7 }</td>
                      <td>${timetable.tur7 }</td>
                      <td>${timetable.fri7 }</td>
                    </tr>                 
                    <tr>
                    </tr>

                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <!-- /.container-fluid -->


      </div>
      <!-- End of Main Content -->
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
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>
</body>

</html>
