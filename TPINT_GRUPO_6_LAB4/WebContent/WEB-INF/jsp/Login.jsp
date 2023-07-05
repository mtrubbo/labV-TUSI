<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet"
	href='<c:url value="/resources/fontawesome/css/all.min.css"/>'>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/login.css"/>'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body style="background-color: #fcfcfc">
	<main class="d-flex vh-100 justify-content-around align-items-center">

	<section
		class="formSection d-flex flex-column justify-content-center align-items-center">
	<img width=50% src="/resources/img/maxiventas-logo.png"> <br>
	<br>
	<h1 style="font-size: 1.5rem; letter-spacing: 0.2rem">COMIENZA A
		VENDER</h1>
	<br>
	<form action"${pageContext.request.contextPath}/login" method="POST">
		<div class="mb-3 d-flex align-items-center gap-2">
			<!--  <label for="usuario" class="form-label">Usuario</label>-->
			<i class="fa-regular fa-user fa-beat" style="color: #1bc080;"></i>
			<input type="text" placeholder="Usuario" class="form-control"
				id="usuario" name="usuario"
				style="box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.20); border: 0">
		</div>
		<div class="mb-3 d-flex align-items-center gap-2">
			<!-- <label for="password" class="form-label">Clave</label>  -->
			<i class="fa-regular fa-keyboard" style="color: #1bc080;"></i>
			<input type="password" placeholder="Clave" class="form-control"
				id="password" name="contrasena"
				style="box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.20); border: 0">
		</div>
		
		<div class="mb-3">			
			<button type="submit" class="btn"
				style="font-weight: 700; background-color: #10ba99; color: #fff; width: 100%; font-weigth: bold; box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.25);">
				<i class="fa-regular fa-circle-check" style="color: #ffffff;"></i>
				INGRESAR
			</button>
		</div>
		<br> <br>
		<div style="color: red; text-align: center">${MensajeError}</div>

	</form>
	</section> </main>

	<footer>
	<p style="color: #808080; text-align: center">
		Made with love <i class="material-icons">favorite</i> © Grupo 6
	</p>
	</footer>

</body>
</html>