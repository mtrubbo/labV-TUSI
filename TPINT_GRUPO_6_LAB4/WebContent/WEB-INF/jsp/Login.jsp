<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/login.css"/>'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<main class="d-flex vh-100 justify-content-around align-items-center">
	<section class="welcomeSection  h-100">
	<div
		class="d-flex text-center flex-column justify-content-between h-100">
		<!-- <img class="header-img" src="<c:url value="/resources/img/logo-navbar.png" />"/>-->
		<!-- <h1 class="titleHeader">Bienvenido</h1>-->
	</div>
	</section> <section
		class="formSection d-flex flex-column justify-content-center align-items-center">
	<img width=60% src="/resources/img/logotp.png"> <br>
	<br>
	<!-- <h1>Ingresar</h1>-->
	<form action"${pageContext.request.contextPath}/login" method="POST">
		<div class="mb-3">
			<!--  <label for="usuario" class="form-label">Usuario</label>-->
			<input type="text" placeholder="Usuario" class="form-control"
				id="usuario" name="usuario">
		</div>
		<div class="mb-3">
			<!-- <label for="password" class="form-label">Clave</label>  -->
			<input type="password" placeholder="Clave" class="form-control"
				id="password" name="contrasena">
		</div>
		<div>${MensajeError}</div>
		<button type="submit" class="btn"
			style="background-color: #f4ac23; color: #fff; width: 100%; font-weigth: bold">Ingresar</button>
		<br>
		<p style="color:#808080">Made with love <3 || © Grupo 6</p>
	</form>
	</section>
	</main>

</body>
</html>