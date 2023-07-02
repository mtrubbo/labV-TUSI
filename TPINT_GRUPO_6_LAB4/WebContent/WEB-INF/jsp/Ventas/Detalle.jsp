<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle de Venta</title>


<style>
:root { -
	-contextPath: "${pageContext.request.contextPath}";
}
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/Home.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/ventas.css"/>'>
<link
	href="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.css"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">

<!-- Enlace al archivo CSS de Font Awesome -->
<link rel="stylesheet"
	href='<c:url value="/resources/fontawesome/css/all.min.css"/>'>

<!-- Enlace opcional a los archivos de fuentes de Font Awesome -->
<link rel="stylesheet"
	href='<c:url value="/resources/fontawesome/webfonts/fa-brands-400.woff2"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fontawesome/webfonts/fa-regular-400.woff2"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/fontawesome/webfonts/fa-solid-900.woff2"/>'>
<!-- Agrega los estilos CSS de Toastr -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">




<!-- scripts -->
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>



</head>

<body>
	<div class="bg-light"
		style="text-align: center; margin: 4rem 18rem; padding: 1rem; border-radius: 2rem; box-shadown: 0px 0 5px #000">
		<h1>
			<span>Venta N° </span>${venta}<h1>
				<h5>
					<span>Fecha: </span>${fecha}</h5>
				<h5>
					<span>Cliente: </span>${cliente}</h5>

				<table id="tableVentas"
					class="responsive table dataTables_wraper">
					<thead>
						<tr>
							<th>Cod. Producto</th>
							<th>Producto</th>
							<th>Precio V.</th>
							<th>Marca</th>
						</tr>
					</thead>
					
					<br>

					<tbody>
						<c:forEach items="${articulos}" var="item">
							<tr>
								<td>${item.id}</label>
								</td>
								<td>${item.nombre}</td>
								<td>${item.precio}</td>
								<td>${item.marca.nombre}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


				<h4 style="text-align:right">
					<span><b>Monto:</b> $ </span>${monto}</h4>
				<h4 style="text-align:right">
					<span><b>Ganancia:</b> $ </span>${ganancia}</h4>
	</div>
</body>
</html>