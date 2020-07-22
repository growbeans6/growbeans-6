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

<script>
	function update() {
		alert("정보가 변경되었습니다.");
	}
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
               
               <div style="text-align:center">
               	<img src="/resources/img/${loginprof.pFile }" width="300" height="300" >
               </div>
               
               <table class="table table-striped">
                  <tr>
                     <td><b>교번</b></td>
                     <td><input type="text" class="form-control" name="pNo"
                        value="${loginprof.pNo }" required readonly></td>
                        <input type="hidden" name="pFile" value="${loginprof.pFile }">
                        </tr>
                        
                        <tr>
                     <td><b>학과</b></td>
                     <td><input type="text" class="form-control" name="pDept" value="${loginprof.pDept }" readonly></td>
                  </tr>
                  
                    <tr>
                     <td><b>교수명</b></td>
                     <td><input type="text" class="form-control" name="pName" value="${loginprof.pName }" readonly></td>
                  </tr>

                  <tr>
                     <td><b></b>전화번호</td>
                     <td><input type="text" class="form-control" name="pPhone" value="${loginprof.pPhone }"></td>
                  </tr>

                  <tr>
                     <td><b>주소</b></td>
                     <td>
                         <div class="input-group mb-3" >
                            <input type="text" class="form-control" name="pAddress" value="${loginprof.pAddress }" aria-label="Username" aria-describedby="basic-addon1">
                         </div>
                     </td>
                  </tr>
                  <tr>
                     <td><b>이메일</b></td>
                     <td>
                         <input type="text" class="form-control" name="pEmail" value="${loginprof.pEmail }">
                     </td>
                  </tr>
                   <tr>
                      <td colspan="2" class="text-center">
                      <input type="submit" value="정보수정" class="btn btn-primary" onclick="return update();">
                     <%-- <a class="btn btn-secondary btn-sm" href="${profInfoUpdate }">수정하기</a> --%>
                      <a class="btn btn-primary" href="home">홈으로</a>
                     </td>
                   </tr>
               </table>
            </form>
         </div>
      </div>

        </div>
        <!-- /.container-fluid -->
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
