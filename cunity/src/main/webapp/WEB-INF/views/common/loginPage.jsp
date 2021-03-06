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

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block" ><img src="https://23fb88ad5ca22a1b4d32-e1951aed44f4258f5fd1721b94cf0277.ssl.cf5.rackcdn.com/cdn_FJV6xXSK5SbvNfVr9NLnNAqpp57r5STy.JPG" style="width: 450px; height: 450px;"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome cunity!!</h1>
                  </div>
                  
                  
                  <div class="custom-control custom-checkbox small">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        
                    <input type="radio" name="chk_info" onchange ="setDisplay()" id="student" value ="student" checked >Stduent
                    &nbsp;&nbsp;
                    <input type="radio" name="chk_info" onchange ="setDisplay()" id="Professor" value ="professor">Professor   
                </div>    
                  
                  <form class="student" id="student1" action="/studentLogin" method="post">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="studentId" placeholder="Student Id" name="sNo">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="studentPassword" placeholder="Password" name="sPassword">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me student</label>
                      </div>
                    </div>
                <input type="submit" class="btn btn-primary" value="Login" style="width:350px">
                    <hr>
                  <div class="text-center">
                  </div>
                  </form> 
                  
                <form class="professor" id="professor1" action="/profLogin" style="display:none" method="POST">
                  <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="professorId" placeholder="professor Id" name="pNo">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="professorPassword" placeholder="Password" name="pPwd">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me professor</label>
                      </div>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Login" style="width:350px">
                    <hr>
                 <div class="text-center">
                 	
                  </div>
                  
                  </form>
                <hr>            

                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

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

<script>
    
function setDisplay(){
    if($('input:radio[id=student]').is(':checked')){
        $('#student1').show();
        $('#professor1').hide();
    }else{
        $('#professor1').show();
        $('#student1').hide();
    }
}

    
</script>

</html>

