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
        <!-- Begin Page Content -->
         <div class="container-fluid">

       
       <div class="container text-center">
      </div>
   </div>

   <div class="container">
      <div class="row">
         <div class="col-md-4"></div>
         <div class="col-md-5">
            <h2 class="text-center">상담</h2>
            <form action="/insertAnswer" method="post"
               name="productWrite">
               <input type="hidden" class="form-control" name="cNo" value="${cNo }">
               <table class="table table-striped">
                  <tr>
                     <td>상담 제목</td>
                     <td><input type="text" class="form-control" name="cTitle"
                        value="${consultDetail.cTitle }" readonly></td>
                   </tr>
                        
                  <!--  <tr>
                     <td>지도 교수</td>
                     <td><input type="text" class="form-control" name="findplace" value="민봉식교수"readonly></td>
                  </tr> -->
                  
                    <tr>
                     <td>학생 이름</td>
                     <td><input type="text" class="form-control" name="sName" value="${sName }"readonly></td>
                  </tr>

                  <tr>
                     <td>학생 학번</td>
                     
                     <td><input type="text" class="form-control" name="sNo" value="${sNo }"readonly></td>
                  </tr>

                  <tr>
                     <td>상담내용</td>
                     <td>
                         <textarea cols="30" rows="10" name="cContent" readonly>${consultDetail.cContent } </textarea>
                     </td>
                  </tr>

                  <tr>
                     <td>답변내용</td>
                     <td>
                         <textarea cols="30" rows="10" name="cAnswer" >${consultDetail.cAnswer }</textarea>
                     </td>
                  </tr>
                  
                   <tr>
                     <td colspan="2" class="text-center">
                    <input type="submit" class="form-control" value="제출">
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
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>
</body>

</html>
