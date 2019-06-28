<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/login.css">
<title>Registrarse</title>

<script>
function activar(obj){
  if(obj.value=='68'){
         document.getElementById("id_departamento").disabled=false;
  		 document.getElementById("id_municipio").disabled=false;
  }else{
         document.getElementById("id_departamento").disabled=true;  
  		 document.getElementById("id_municipio").disabled=true;
  }
  }
</script> 
</head>
<body>
	<div class="container" style="width: 500px; margin-top: 30px;">

		<h2 class="text-center">Nuevo Usuario</h2>
		<form:form id="holi"
			action="${pageContext.request.contextPath}/user/add" method="POST"
			modelAttribute="usuario">
			<form:input type="hidden" name="id_usuario" path="id_usuario" />

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Nombre de Usuario: </label>
					<form:input type="text" class="form-control" name="nomusuario"
						path="nomusuario" />
					<form:errors path="nomusuario" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Clave: </label>
					<form:input type="text" class="form-control" name="pasword"
						path="pasword" />
					<form:errors path="pasword" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Nombre: </label>
					<form:input type="text" class="form-control" name="nombre"
						path="nombre" />
					<form:errors path="nombre" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Apellido: </label>
					<form:input type="text" class="form-control" name="apellido"
						path="apellido" />
					<form:errors path="apellido" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Fecha de nacimiento: </label>
					<form:input type="date" class="form-control" name="fechanac"
						path="fechanac" />
					<form:errors path="fechanac" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Direccion: </label>
					<form:input type="text" class="form-control" name="direccion"
						path="direccion" />
					<form:errors path="direccion" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Pais: </label>
					<form:select class="form-control" name="id_pais" path="id_pais" onChange="activar(this);">
						<c:forEach items="${paises}" var="paises">
							<option value="${paises.sk_pais}">${paises.pais}</option>
						</c:forEach>
					</form:select>	
					<form:errors path="id_pais" cssStyle="color:red;"></form:errors>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Departamento: </label>
					<form:select class="form-control" name="id_departamento" path="id_departamento" onChange="" disabled="true">
						<c:forEach items="${departamentos}" var="departamentos">
							<option value="${departamentos.sk_departamento}">${departamentos.departamento}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<label>Municipio: </label>
					<form:select class="form-control" name="id_municipio" path="id_municipio" onChange="" disabled="true">
						<c:forEach items="${municipios}" var="municipios">
							<option value="${municipios.sk_municipio}">${municipios.municipio}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 form-group">
					<input id="enviar" type="submit" value="Guardar"
						class="btn btn-block btn-login btn-warning">
				</div>
			</div>
		</form:form>
		<div class="row">
			<div class="col-md-12 form-group">
				<button
					onclick="location.href='${pageContext.request.contextPath}/volverA'"
					class="btn btn-block btn-login btn-secondary">Cancelar</button>
			</div>
		</div>

	</div>
</body>
</html>