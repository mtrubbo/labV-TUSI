<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ventas</title>

<style>
:root { -
	-contextPath: "${pageContext.request.contextPath}";
}
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/articulos.css"/>'>
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
<body class="">


	<jsp:include page="../components/Navbar.jsp"></jsp:include>
	<main
		class="articulosBody d-flex justify-content-center align-items-center flex-column w-100"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');">
	<section class="sectionTable">
	<div class="row justify-content-around">
		<h2>Ventas</h2>
		<p>${Mensaje}</p>
	</div>

	<!-- Action Modal -->
	<button type="button" class="btnNewVent " data-bs-toggle="modal"
		data-bs-target="#newVent">Nueva Venta</button>


	<!-- INICIO DATATABLE -->
	<table id="tableVentas"
		class="responsive table table-striped dataTables_wraper">
		<thead>
			<tr>
				<th>N° Venta</th>
				<th>Fecha</th>
				<th>Cliente</th>
				<th>Monto total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ventas}" var="item">
				<tr>
					<td>${item.id}</label>
					</td>
					<td>${item.fecha}</td>
					<td>${item.cliente.dni}</td>
					<td>${item.montoTotal}</td>
					<td>
						<button class="btnTableDetalle" onclick='detalleOpen(${item.id})'>
							<i class="fas fa-eye"></i>
						</button>
						<button class="btnTableDelete" onclick='confirmDelete(${item.id})'>
							<i class="fa-solid fa-trash"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</section> <!-- END DATATABLE --> <!-- MODALS --> <!-- Modal NUEVA VENTA -->
	<div class="modal fade" id="newVent" tabindex="-1"
		aria-labelledby="newVentlabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header" style="background: #DAAE59; color: #fff;">
					<h5 class="modal-title" id="newVentlabel">Nueva Venta</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/ventas/crear"
						method="POST">
						<input type="hidden" id="estado" value="true" name="estado">
						<div class="row mb-5">
							<h5>Clientes</h5>
							<div class="col-md-4">
								<label class="form-label">Fecha Venta</label> <input id="fecha"
									type="date" name="fecha" class="form-control" required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Cliente</label> <select id="tipo"
									name="tipo" class="form-control">
									<c:forEach items="${clientes}" var="item">
										<option value="${item.id}">${item.nombre}
											${item.apellido}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row mb-5">
							<h5>Articulos</h5>
							<div class="col-md-6">
								<label class="form-label">Articulos</label> <select id="tipo"
									name="tipo" class="form-control">
									<c:forEach items="${Articulos}" var="item">
										<option id="idArt" value="${item.id}">${item.nombre}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-6">
								<label class="form-label">Cantidad</label> <input id="cantidad"
									type="number" name="cantidad" class="form-control" required>
							</div>
							<!-- 
														<div class="col-md-6">
								<label class="form-label">Precio Unitario</label> <input
									id="precio" type="number" name="precio" class="form-control" disabled
									required>
							</div>
							<div class="col-md-6">
								<label class="form-label">Precio Total</label> <input
									id="precio" type="number" name="precio" class="form-control"
									required>
							</div>
							 -->
							<div class="col-md-6 mx-auto mt-3 text-center">
								<button class="btn btn-primary" onclick='agregarItem(${item.id})'>Agregar</button>
							</div>
						</div>

						<div class="row">
							<h5>Articulos Agregados</h5>
							<div class="borders">

								<table id=""
									class="responsive table table-striped dataTables_wraper">
									<thead>
										<tr>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${articulos}" var="item">
											<tr>
												<td>${item.nombre}</label>
												</td>
												<td>${item.precio}</td>
												<td>$TOTAL</td>
												<td>
													<button class="btnTableDelete"
														onclick='confirmDelete(${item.id})'>
														<i class="fa-solid fa-trash"></i>
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
						</div>

						<div class="row">
							<h5>Totales y subtotales</h5>
							<div class="col-md-6">
								<p id="cantidad" class="">
									Cantidad total de articulos: <span>${cantArt}</span>
								</p>
								<!-- <input id="precio" type="number" name="precio" class="form-control" required> -->
							</div>
							<div class="col-md-6">
								<p class="" id="monto">
									Monto total de compra: <span>${monto}</span>
								</p>
								<!-- <input id="precio" type="number" name="precio" class="form-control" required> -->
							</div>
						</div>
						<div class="mt-5">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancelar</button>
							<button type="submit" class="btn "
								style="background: #DAAE59; color: #fff;">Ingresar
								Venta</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal Borrar -->
	<div class="modal fade" id="deleteVent" tabindex="-1"
		aria-labelledby="deleteVentLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header" style="background: #B32D2D; color: #fff">
					<h5 class="modal-title" id="deleteVentLabel">Borrar Venta</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="formDelete"
						action="${pageContext.request.contextPath}/ventas/eliminar"
						method="GET">
						<!-- <input type="hidden" id="estado" value="true" name="estado">-->
						<p style="font-weight: bold; font-size: 20px;">Usted esta a
							punto de eliminar una venta</p>
						<p>¿Seguro desea realizar la operacion?</p>
						<div class="mt-3">
							<button class="btn btn-secondary">Cancel</button>
							<button class="btn btn-danger" type="submit">OK</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<!-- SCRIPTS INIT -->
	<script>
$(document).ready( function () {
    $('#tableVentas').DataTable();
    
    $('#newVent').on("submit", function(e){
        e.preventDefault();
        let action = e.target.getAttribute('action');
        let data = {
			id: $('#id').val(),
			fecha: $('#date').val(),
			dni: $('#cliente.dni').val(),
		    montoTotal: $('#montoTotal').val(),
		    detalle: $('#detalle').val()
        }

        $.ajax({
            url: action,
            method: "POST",
            data,
            success: function(data){
                console.log(data);
                let res = JSON.parse(data);

                if(res.status == 'ok'){
                    mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
                }
            },
            error: function(res, error) {
                console.log(res);
                console.log(error);
                mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
            }
        })
	});
    
    $('#formDelete').on("submit", function(e){
        e.preventDefault();
        let action = e.target.getAttribute('action');

        $.ajax({
            url: action,
            method: "get",
            success: function(data){
                console.log(data);
                let res = JSON.parse(data);

					if(res.status == 'ok')
                    mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
            },
            error: function(res, error) {
                console.log(res);
                console.log(error);
                mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
            }
        })
	});
    
});

function confirmDelete(id){
	$('#formDelete').attr('action', '${pageContext.request.contextPath}/ventas/eliminar/'+id);
	$('#deleteVent').modal('toggle');
}

function mostrarNotificacionYRecargar(mensaje) {
    // Configura la notificación Toastr
    toastr.options = {
        closeButton: true,
        progressBar: true,
        positionClass: "toast-top-right",
        timeOut: 2000 // Duración de la notificación en milisegundos (3 segundos en este caso)
    };

    // Muestra la notificación Toastr
    toastr.success(mensaje, "Éxito", {
        onHidden: function () {
            // Recarga la página después de que se cierre la notificación
            window.location.reload();
        }
    });
}


function addItem(){
	let data = {
		idArt: $('#idArt').val()
	}
	
	$.ajax({
		url: "${pageContext.request.contextPath}/ventas/agregarItem/"+idArt,
		method: "GET",
		success: function(json){
			let res = JSON.parse(json);
			console.log(res);
			$('#idArt').val(res.id);
		},

		
	})
}


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