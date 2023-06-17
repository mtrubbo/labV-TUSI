<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Articulos</title>
<!-- ContextPath setting in css, DO NOT TOUCH!!! -->
<style>
    :root {
        --contextPath: "${pageContext.request.contextPath}";
    }
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/articulos.css"/>'>
<link href="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.css" rel="stylesheet"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">

<!-- Enlace al archivo CSS de Font Awesome -->
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/css/all.min.css"/>'>

<!-- Enlace opcional a los archivos de fuentes de Font Awesome -->
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/webfonts/fa-brands-400.woff2"/>'>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/webfonts/fa-regular-400.woff2"/>'>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/webfonts/fa-solid-900.woff2"/>'>


<!-- scripts -->
<script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body class="">
<jsp:include page="../components/Navbar.jsp"></jsp:include>
<main class="articulosBody d-flex justify-content-center align-items-center flex-column w-100" style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');">
	<section class="sectionTable">
	<h2>Ventas</h2>

	<!-- Action Modal -->
	<button type="button" class="btnNewVent " data-bs-toggle="modal" data-bs-target="#newVent">
  		Nueva Venta
	</button>
	
	
	<!-- INICIO DATATABLE -->
	<table id="tableVenta" class="responsive table table-striped dataTables_wraper">
		<thead>
			<tr>
				<th>Fecha venta</th>
				<th>Cliente</th>
				<th>Monto Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ventas}" var="item">
				<tr>
				<td>${item.fecha}</label> </td>
				<td>${item.cliente.dni}</td>
				<td>${item.montoTotal}</td>
				<td><button class="btnTableEdit" onclick='editOpen(${item.id})'><i class="fa-solid fa-pencil"></i></button><a style="text-style: none; color: red;" href="<c:url value='/ventas/eliminar/${item.id}' />"  ><i class="fa-solid fa-trash"></i></a></td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	</section>
	<!-- END DATATABLE -->
	
	<!-- MODAL -->
	<!-- Modal NUEVA VENTA -->
		<div class="modal fade" id="newVent" tabindex="-1" aria-labelledby="newVentLabel" aria-hidden="true">
  			<div class="modal-dialog modal-lg">
    			<div class="modal-content">
      				<div class="modal-header" style="background: #DAAE59; color: #fff;">
        				<h5 class="modal-title" id="newVent">Nueva venta</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      				</div>
      				<div class="modal-body">
      					<form action="${pageContext.request.contextPath}/ventas/crear" method="POST">
      						<input type="hidden" id="estado" value="true" name="estado">
      						<div class="col-md-12">
      							<label class="form-label">DNI CLiente</label>
      							<input id="cliente" type="number" name=""cliente"" class="form-control" required>
      						</div>
      						<div class="row">
      							<div class="col-md-6">
      								<label class="form-label">Producto</label>
      								<input id="producto" type="text" name="producto" class="form-control" required>
      							</div>
      						<div class="col-md-6">
	      							<label class="form-label">Precio</label>
	      							<input id="precio" type="number" name="precio" class="form-control" required>
	      						</div>
      						</div>
	      						<div class="col-md-6">
	      							<label class="form-label">Cantidad</label>
	      							<input id="cantidad" type="number" name="cantidad" class="form-control" required>
	      						</div>
      						</div>
      						<div class="mt-5">
		        				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		        				<button type="submit" class="btn " style="background: #DAAE59; color: #fff;">Ingresar venta</button>
							</div>
      					</form>
    			</div>
  			</div>
		</div>
	</div>
	
</main>	
<!-- SCRIPTS INIT -->
<script>
$(document).ready( function () {
    $('#tableVentas').DataTable();
} );

</script>

</body>

</html>