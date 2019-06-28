<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/tabla.css">
<title>Main</title>
</head>
<body>

    <div class="container">
    	<div class="row col-md-6 col-md-offset-2 custyle">
    		<table id="table" class="table table-striped custab">
    			<thead>
    				<button onclick="location.href='${pageContext.request.contextPath}/admin/main'" class="btn btn-primary btn-xl pull-right">Regresar</button>
					<tr>
						<th class="text-center">Codigo</th>
						<th class = "text-center">Editar Estado</th>
						<th class = "text-center">Username</th>
						<th class = "text-center">Nombre Completo</th>
						<th class = "text-center">Saldo ($)</th>
						<th class = "text-center">Estado</th>
					</tr>
				</thead>
				<c:forEach items="${usuarios}" var="usuarios" varStatus="status">
				<tr>
					<td class="text-center">${usuarios.id_usuario}</td>
					<td class="text-center">
						<button onclick="estado(${usuarios.id_usuario})" class="btn btn-danger">Activar/Inactivar</button>
					</td>
					<td class="text-center">${usuarios.nomusuario}</td>
					<td class="text-center">${usuarios.nombreCompleto}</td>
					<td class="text-center">${usuarios.saldo}</td>
					<td class="text-center">${usuarios.estadoDelegate}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	  </div>
	  <script type='text/javascript'>
			function estado(id){
				//var pepino = "";
				$.ajax({
					url: "${pageContext.request.contextPath}/admin/user/status",
					data: {userId: id},
					type: 'POST',
					success: function (result) {
					//SI ESTA ACTIVO
						if(result == "activo"){
							swal("Ingrese el motivo de la inactivacion de la cuenta", {
					 	    	//icon: "error",
								content: {
								    element: "input",
								    attributes: {
								      placeholder: "descripcion",
								      type: "text",
								    },
								},
								closeOnClickOutside: false,
								buttons: {
					 	    		cancel: true,
					 	    		confirm: true,
					 	    	},
			 		   		}).then((isConfirm) => {
				 		   		if(isConfirm){
					 		   		$.ajax({
										url: "${pageContext.request.contextPath}/admin/user/status/inactive",
										data: {userId: id, message: isConfirm},
										type: 'POST',
										success: function (result){
											//console.log(content);
											swal("Usuario desactivado con exito", {
									 	    	icon: "success",
							 		   		}).then(() => {
							 		   			location.href = "${pageContext.request.contextPath}/admin/usuario"
								 		   	});
										}, error: function (xhr) {
											console.log(content);
											swal("No se pudo desactivar el usuario", {
									 	    	icon: "error",
							 		   		});
										}
									});
					 		   	} /*else {
						 		}*/
				 		   	});
					//SI ESTA INACTIVO
						} else {
							swal("Esta seguro?", {
					 	    	icon: "warning",
					 	    	text: "Usted ACTIVARA este usuario!",
					 	    	buttons: {
					 	    		cancel: true,
					 	    		confirm: true,
					 	    	},
					 	    	closeOnClickOutside: false,
			 		   		}).then((isConfirm) => {
								if(isConfirm){
									$.ajax({
										url: "${pageContext.request.contextPath}/admin/user/status/active",
										data: {userId: id},
										type: 'POST',
										success: function (result){
											swal("Usuario activado con exito", {
									 	    	icon: "success",
							 		   		}).then(()=> {
							 		   			location.href = "${pageContext.request.contextPath}/admin/usuario"
								 		   	});
										}, error: function (xhr) {
											swal("No se pudo activar el usuario", {
									 	    	icon: "error",
							 		   		});
										}
									});
								} else {
									//apreto el boton de cancelar de activacion
								}
				 		   	});
						}
					},
					error: function (xhr) {
						//validar la primera peticion
					}
				});
			}
    </script>
</body>
</html>