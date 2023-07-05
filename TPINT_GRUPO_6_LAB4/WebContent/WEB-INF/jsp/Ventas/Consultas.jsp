<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultas</title>
<!-- ContextPath setting in css, DO NOT TOUCH!!! -->
<style>
:root { -
	-contextPath: "${pageContext.request.contextPath}";
}
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/consultaventas.css"/>'>
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






<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Language', 'Speakers (in millions)'],
          ['Monto',  ${montototalventas}],
          ['Ganancia', ${gananciatotalventas}]
        ]);

      var options = {
        title: 'Monto vs Ganancia',
        is3D: true,
      };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>





</head>
<body class="">
	<jsp:include page="../components/Navbar.jsp"></jsp:include>
	<main
		class="consultasBody d-flex justify-content-center align-items-center flex-column w-100">




	<div class="d-flex flex-row justify-content-around align-items-start container" style="gap:20px; margin-top:1rem; background-color: #fff">
		<div class="col-md-3" style="">
			<section class="sectionFormRequest">
			<div class="text-center">
				<h5 class="text-center">Rango de ventas</h5>
				<div class="">
					<input class="form-control" type="date" id="fechaInicio"
						name="fechaInicio" required /> <input class="form-control"
						type="date" id="fechaFin" name="fechaFin" required />
				</div>
				<button onclick="obtenerVentas()" type="button" id="btnConsultar"
					class="btn" style="margin-top: 1rem; background-color:#10ba99;color:#fff;width:100%">Consultar</button>
			</div>
			</section>
			
					<div id="piechart" style="width: 300px;"
			class="col-md-8"></div>
		</div>


		<section class="sectionTable col-md-9">
		<div class="d-flex flex-row justify-content-around"
			style="display: flex; justify-content: space-around">
			<h2>Listado de Ventas</h2>
			<!--        <h3 class="bg-success text-white"><span>Total General: $</span>${montototalventas}</h3>
            <h3 class="bg-success text-white"><span>Ganancia General: $</span>${gananciatotalventas}</h3>
          -->

		</div>


		<table id="tableDetalle"
			class="responsive table table-striped dataTables_wraper">
			<thead>
				<tr>
					<th>N° Venta</th>
					<th>Fecha</th>
					<th>Cliente</th>
					<th>Monto total</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Ventas}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.fecha}</td>
						<td>${item.nombreCliente}</td>
						<td>${item.montoTotal}</td>
						<td><a href="/ventas/consultas/detalles/${item.id}"><i
								class="fa-solid fa-list" style="text-decoration: none;"></i>
								Detalles
								</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</section>




	</div>





	</main>

	<script type="text/javascript"
		src='<c:url value="/resources/js/consultaVentas.js"/>'></script>

	<script>
$(document).ready( function () {
	$.extend($.fn.dataTable.defaults, {
	    language: {
	      search: 'Buscar' ,
	      lengthMenu: 'Mostrar _MENU_ registros'
	    }
	  });
	
    $('#tableDetalle').DataTable({
        order: [[0, 'desc']] // Ordena por la primera columna (ID) de forma descendente
    });
});
</script>

	<c:if test="${not empty sessionScope.mensaje}">
		<%-- Configurar la notificación Toastr --%>
		<script>
    mostrarNotificacionYRecargar("${sessionScope.mensaje}")
    </script>

		<%-- Limpiar el mensaje de la sesión para que no se muestre nuevamente en futuras peticiones --%>
		<%
			session.removeAttribute("mensaje");
		%>
	</c:if>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</body>

</html>