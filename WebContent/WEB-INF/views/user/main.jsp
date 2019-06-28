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
    				<form id="holi" action="${pageContext.request.contextPath}/logoutAdmin" method="POST">
    					<input id="enviar" type = "submit" value="Cerrar Sesion" class="btn btn-primary btn-xl pull-right">
    				</form>
					<tr>
						<th class="text-center">Nombre</th>
						<th class = "text-center">Accion</th>
					</tr>
				</thead>
				<tr>
					<td class="text-center">Peliculas</td>
					<td class="text-center">
						<button onclick="location.href='${pageContext.request.contextPath}/admin/pelicula'" class="btn btn-primary">Ver Informacion</button>
					</td>
				</tr>
				<tr>
					<td class="text-center">Funciones</td>
					<td class="text-center">
						<button onclick="location.href='${pageContext.request.contextPath}/sucursal/nueva'" class="btn btn-primary">Ver Informacion</button>
					</td>
				</tr>
				<tr>
					<td class="text-center">Usuarios</td>
					<td class="text-center">
						<button onclick="location.href='${pageContext.request.contextPath}/admin/usuario'" class="btn btn-primary">Ver Informacion</button>
					</td>
				</tr>
			</table>
		</div>
	  </div>
</body>
</html>