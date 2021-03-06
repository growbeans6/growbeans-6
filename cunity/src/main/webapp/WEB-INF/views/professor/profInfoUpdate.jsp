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

       
       <div class="container text-center">
      </div>
   </div>

   <div class="container" >
      <div class="row">
         <div class="col-md-4"></div>
         <div class="col-md-5">
            <h2 class="text-center">교수정보</h2>
            <form action="/profInfoUpdate" method="post"
               name="productWrite" enctype="multipart/form-data">
               <table class="table table-striped">
                   
                   <tr>
                    <td>
                       <img src="img/250px-Albert_Einstein_Head.jpg" width="140" height="140" title="아인슈타인">
                       </td>
                       <td>
                        <a class="btn btn-secondary btn-sm" href="#">파일찾기</a>
                       </td>
                   </tr>
                  <tr>
                     <td>교번</td>
                     <td><input type="text" class="form-control" name="lName"
                        placeholder="1829182" required ></td>
                        </tr>
                        
                        <tr>
                     <td>학과</td>
                     <td><input type="text" class="form-control" name="findplace" value="컴퓨터 공학과"></td>
                  </tr>
                  
                    <tr>
                     <td>교수명</td>
                     <td><input type="text" class="form-control" name="color" value="민봉식"></td>
                  </tr>

                  <tr>
                     <td>전화번호</td>
                     <td><input type="text" class="form-control" name="findplace" value="010-3052-1120"></td>
                  </tr>

                  <tr>
                     <td>주소</td>
                     <td>
                         <div class="input-group mb-3" >
                            <input type="text" class="form-control" placeholder="주소 입력" aria-label="Username" aria-describedby="basic-addon1">
                             <a class="btn btn-secondary btn-sm" href="#">주소찾기</a>
                         </div>
                     </td>
                  </tr>

                  <tr>
                     <td>이메일</td>
                     <td>
                         <input type="text" class="form-control" name="findplace" value="example@gmail.com">
                     </td>
                  </tr>
                   
                   <tr>
                      <td>
                     <a class="btn btn-secondary btn-sm" href="#">수정하기</a>
                      <a class="btn btn-secondary btn-sm" href="#">취소</a>
                     </td>
                   </tr>
               </table>
            </form>
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
