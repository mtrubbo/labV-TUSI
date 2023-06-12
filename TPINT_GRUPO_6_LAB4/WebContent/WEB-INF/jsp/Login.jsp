<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/login.css"/>'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
</head>
<body>
	<main class="d-flex vh-100 justify-content-around align-items-center">
		<section class="welcomeSection  h-100">
			<div class="d-flex text-center flex-column justify-content-between h-100">
				<img class="header-img" src="<c:url value="/resources/img/logo-navbar.png" />"/>
				<h1 class="titleHeader">Bienvenido</h1>
				<div>
					<p class="footerHeader">Made with love <3 || © Grupo 10</p>
				</div>
			</div>
		</section>
		<section class="formSection d-flex flex-column justify-content-center align-items-center">
			<h1>Login</h1>
			<form class="formdetails">
  				<div class="mb-3">
    				<label for="exampleInputEmail1" class="form-label">Email address</label>
    				<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    				<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  				</div>
  				<div class="mb-3">
    				<label for="exampleInputPassword1" class="form-label">Password</label>
    				<input type="password" class="form-control" id="exampleInputPassword1">
  				</div>
  				<div class="mb-3 form-check">
    				<input type="checkbox" class="form-check-input" id="exampleCheck1">
    				<label class="form-check-label" for="exampleCheck1">Check me out</label>
  				</div>
  				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</section>
	</main>
</body>
</html>