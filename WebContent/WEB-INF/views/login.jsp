<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/bootstrap-4.3.1-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/css/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script src="resources/css/bootstrap-4.3.1-dist/jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/login.css">
<title>Login</title>
</head>
<body >
	
	<div class="simple-login-container">
		<h2>Login</h2>
			<form id="holi" >
	
			
			<div class="row">
				<div class="col-md-12 form-group">
					<input id="1" type="text" placeholder="Username" class="form-control" name="username" />
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<input id="2" type="password" placeholder="Password" class="form-control" name="password" />
					
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 form-group">
					<input type="submit" class="btn btn-block btn-login" value="Iniciar Sesi&oacute;n">
				</div>
			</div>
			</form>
			<form name="agregar" action="${pageContext.request.contextPath}/registrar" method="post"> 
				<button class="btn btn-block btn-login"> Registrarme </button>
		</form>
			<form> </form>
	</div>
	<script type='text/javascript'>
		$(document).ready(function(){
		  $('#1').val('');
		  $('#2').val('');
		});
    </script>
       	<script type='text/javascript'>
	   	$("#holi").on('submit', function (e) {
			e.preventDefault();
			$.ajax(
				{
					url: "${pageContext.request.contextPath}/userlogin",
					data: $("#holi").serialize(),
					type: 'POST',
					success: function (result) {
						console.log(result);
						if(result == "admin ok"){
							location.href = "${pageContext.request.contextPath}/admin/main"//esta funca
						} else {
							location.href = "${pageContext.request.contextPath}/user/main"
						}
						//location.href = "${pageContext.request.contextPath}/user/main"//esta funca
						//$( location ).attr("href", "${pageContext.request.contextPath}/sucursal/main");
					},
					error: function (xhr) {
						console.log(xhr.responseText);
						//var causa = xhr.responseText;
						if(xhr.status == 404){
							swal("La cuenta no existe", {
					 	    	icon: "error",
			 		   		});
						} else if (xhr.status == 409) {
							swal("Esta cuenta posee una sesion ya activa", {
					 	    	icon: "error",
			 		   		});
						} else if(xhr.status == 403) {
							swal(xhr.responseText, {
					 	    	icon: "error",
					 	    	title: "Esta cuenta esta inactiva por:",
			 		   		});
						}
					}
				});
		});
    </script>
</body>
</html>