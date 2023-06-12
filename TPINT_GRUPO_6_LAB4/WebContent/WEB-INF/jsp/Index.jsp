<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/Home.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<title>Home</title>
</head>
<body>
<jsp:include page="./components/Navbar.jsp"></jsp:include>
<main class="home d-flex justify-content-around align-items-center screenComplete">
	<section class="sectionSizes d-flex flex-row justify-content-around align-items-center">
		<div class="linkingFirst linkingCard clientesCard">
			<h1>Gestiona tus clientes</h1>
		</div>
		<div class="flex-column justify-content-around inhetHeight">
			<div class="linkingCard linkingDoubles articuloCard">
				<h1>Gestiona tus articulos</h1>
			</div>
			<div class="linkingCard linkingDoubles ventasCard">
				<h1>Gestiona tus ventas</h1>
			</div>
		</div>
	</section>
</main>
</body>
<script>
    console.log('${pageContext.request.contextPath}/resources/img/home-background.jpg');
</script>
</html>