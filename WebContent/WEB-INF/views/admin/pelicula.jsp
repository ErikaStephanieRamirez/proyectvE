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
    				<button onclick="location.href='${pageContext.request.contextPath}/admin/movie/new'" class="btn btn-primary btn-xl pull-left">Agregar Pelicula</button>
    				<button onclick="location.href='${pageContext.request.contextPath}/admin/main'" class="btn btn-primary btn-xl pull-right">Regresar</button>
					<tr>
						<th class = "text-center">Editar</th>
						<th class = "text-center">Editar Estado</th>
						<th class = "text-center">Codigo</th>
						<th class = "text-center">Nombre</th>
						<th class = "text-center">Duracion (min)</th>
						<th class = "text-center">Estado</th>
						<th class = "text-center">Descripcion</th>
					</tr>
				</thead>
				<c:forEach items="${peliculas}" var="peliculas" varStatus="status">
				<tr>
					<td class="text-center">
						<form id="estado" action="${pageContext.request.contextPath}/admin/movie/view" method="post"> 
            				<input type="hidden" name="movieId" value=${peliculas.id_pelicula}>
            				<input class="btn btn-edit" type="submit" class="delete_button" value="Editar">
						</form>
					</td>
					<td class="text-center">
						<button onclick="estado(${peliculas.id_pelicula})" class="btn btn-danger">Activar/Inactivar</button>
					</td>
					<td class="text-center">${peliculas.id_pelicula}</td>
					<td class="text-center">${peliculas.nombre}</td>
					<td class="text-center">${peliculas.duracion}</td>
					<td class="text-center">${peliculas.estadoDelegate}</td>
					<td class="text-center">${peliculas.descripcion}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	  </div>
	  <script type='text/javascript'>
			function estado(id){
				$.ajax({
					url: "${pageContext.request.contextPath}/admin/movie/status",
					data: {movieId: id},
					type: 'POST',
					success: function (result) {
					//SI ESTA ACTIVO
						if(result == "activo"){
							swal("Esta Seguro?", {
								icon: "warning",
								text: "Usted DESACTIVARA esta pelicula!",
								closeOnClickOutside: false,
								buttons: {
					 	    		cancel: true,
					 	    		confirm: true,
					 	    	},
			 		   		}).then((isConfirm) => {
				 		   		if(isConfirm){
					 		   		$.ajax({
										url: "${pageContext.request.contextPath}/admin/movie/status/inactive",
										data: {movieId: id},
										type: 'POST',
										success: function (result){
											swal("Pelicula desactivada con exito", {
									 	    	icon: "success",
							 		   		}).then(() => {
							 		   			location.href = "${pageContext.request.contextPath}/admin/pelicula"
								 		   	});
										}, error: function (xhr) {
											console.log(content);
											swal("No se pudo desactivar la pelicula", {
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
					 	    	text: "Usted ACTIVARA esta pelicula!",
					 	    	buttons: {
					 	    		cancel: true,
					 	    		confirm: true,
					 	    	},
					 	    	closeOnClickOutside: false,
			 		   		}).then((isConfirm) => {
								if(isConfirm){
									$.ajax({
										url: "${pageContext.request.contextPath}/admin/movie/status/active",
										data: {movieId: id},
										type: 'POST',
										success: function (result){
											swal("Pelicula activada con exito", {
									 	    	icon: "success",
							 		   		}).then(()=> {
							 		   			location.href = "${pageContext.request.contextPath}/admin/pelicula"
								 		   	});
										}, error: function (xhr) {
											swal("No se pudo activar la pelicula", {
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