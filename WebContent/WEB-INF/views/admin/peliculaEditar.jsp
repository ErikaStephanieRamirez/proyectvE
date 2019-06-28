<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/login.css">
<title>Editar Pelicula</title>
</head>
<body>
<div class="container">
	<h2 class="text-center">Editar Pelicula</h2>
	<form:form id="holi" action="${pageContext.request.contextPath}/admin/movie/edit" method="POST" modelAttribute="peliculaDTO">
		<form:input type="hidden" name="id" path="id_pelicula"/>
		
			<div class="row">
				<div class="col-md-12 form-group">
					<form:label path = "nombre">Nombre Pelicula: </form:label>
					<form:input type="text" class="form-control" name="nombrePelicula" path="nombre"/>
					<form:errors path="nombre"  cssStyle="color:red;"></form:errors>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<form:label path = "duracion">Duracion de pelicula (minutos): </form:label>
					<form:input type="number" class="form-control" name="duracionPelicula" path="duracion"/>
					<form:errors path="duracion" cssStyle="color:red;"></form:errors>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<form:label path = "image_url">Url Imagen: </form:label>
					<form:input type="text" class="form-control" name="image_urlPelicula" path="image_url"/>
					<form:errors path="image_url" cssStyle="color:red;"></form:errors>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<form:label path = "video_url">Url Video: </form:label>
					<form:input type="text" class="form-control" name="video_urlPelicula" path="video_url"/>
					<form:errors path="video_url" cssStyle="color:red;"></form:errors>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<form:label path = "descripcion">Descripcion pelicula: </form:label>
					<form:input type="text" class="form-control" name="descripcionPelicula" path="descripcion"/>
					<form:errors path="descripcion" cssStyle="color:red;"></form:errors>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 form-group">
					<input id="enviar" type = "submit" value="Guardar Cambios" class="btn btn-block btn-login btn-warning">
				</div>
			</div>
		</form:form>
			<div class="row">
				<div class="col-md-12 form-group">
					<button onclick="location.href='${pageContext.request.contextPath}/admin/pelicula'" class="btn btn-block btn-login btn-secondary">Cancelar</button>
				</div>
			</div>

</div>
</body>
</html>