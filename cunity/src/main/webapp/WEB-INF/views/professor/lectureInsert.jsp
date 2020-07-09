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

   <div class="container">
      <div class="row">
         <div class="col-md-4"></div>
         <div class="col-md-5">
            <h2 class="text-center">강의 추가</h2>
            <form action="/#" method="post"
               name="productWrite" enctype="multipart/form-data">
               <table class="table table-striped">
                  <tr>
                     <td>강의명</td>
                     <td><input type="text" class="form-control" name="lName"
                        placeholder="강의명 입력" required></td>
                        </tr>
                        
                        <tr>
                     <td>교수명</td>
                     <td><input type="text" class="form-control" name="findplace" value="민봉식"></td>
                  </tr>
                  
                    <tr>
                     <td>학점</td>
                     <td><input type="text" class="form-control" name="color" value="3"></td>
                  </tr>

                  <tr>
                     <td>과목코드</td>
                     <td><input type="text" class="form-control" name="findplace" value="102131"></td>
                  </tr>

                  <tr>
                     <td>강의시간</td>
                     <td>
                         <div class="dropdown">
                              <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                요일
                              </button>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item">월</a>
                                <a class="dropdown-item">화</a>
                                <a class="dropdown-item">수</a>
                                <a class="dropdown-item">목</a>
                                <a class="dropdown-item">금</a>
                              </div>
                          </div>
                          <div class="dropdown">
                              <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                시간
                              </button>
                              <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item">1,2</a>
                                <a class="dropdown-item">2,3</a>
                              </div>
                          </div>
                     </td>
                  </tr>

                  <tr>
                     <td>강의실</td>
                     <td>
                         <input type="text" class="form-control" name="findplace" value="공학관 102">
                     </td>
                  </tr>
                      <td>
                     <a class="btn btn-secondary btn-sm" href="#">강의등록</a>
                      <a class="btn btn-secondary btn-sm" href="#">취소</a>
                      <c:url value="/lectureList" var="lectureList"></c:url>
                        <a class="btn btn-secondary btn-sm" href="${lectureList }">강의리스트 목록보기</a>
                     </td>
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
