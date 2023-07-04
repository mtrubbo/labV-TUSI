
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stocks</title>
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
<!-- Agrega los estilos CSS de Toastr -->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">




<!-- scripts -->
<script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>



</head>
<body class="">
<jsp:include page="../components/Navbar.jsp"></jsp:include>
<main class="articulosBody d-flex justify-content-center align-items-center flex-column w-100" style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');">
	<section class="sectionTable">
	
	<div class="row justify-content-around">
		<h2>Stocks</h2>
		<p>${Mensaje}</p>
	</div>
	


	<!-- Action Modal -->
	<button type="button" class="btnNewStock " data-bs-toggle="modal" data-bs-target="#newStock">
  		Registrar Ingreso de Stock
	</button>
	
	
	<!-- INICIO DATATABLE -->
	<table id="tableStocks" class="responsive table table-striped dataTables_wraper">
		<thead>
			<tr>
				<th>ID</th>
				<th>Articulo</th>
				<th>Fecha de Ingreso</th>
				<th>Precio de Compra</th>
				<th>Cantidad</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stocks}" var="item">
				<tr>
				<td>${item.id}</td>
				<td>${item.articulo.getNombre()}</td>
				<td>${item.fechaIngreso}</td>
				<td>${item.precioCompra}</td>
				<td>${item.cantidad}</td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	</section>
	<!-- END DATATABLE -->
	
	<!-- MODALS -->
	<!-- Modal NUEVO STOCK -->
		<div class="modal fade" id="newStock" tabindex="-1" aria-labelledby="newStocklabel" aria-hidden="true">
  			<div class="modal-dialog modal-lg">
    			<div class="modal-content">
      				<div class="modal-header">
        				<h5 class="modal-title" id="newStocklabel">Registrar Ingreso de Stock</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      				</div>
      				<div class="modal-body">
      					<form action="${pageContext.request.contextPath}/stocks/adding" method="GET">
      					
      						<div class="col-md-12">
 							 <label class="form-label">Articulo</label>
  								<select id="articulo" name="articulo" class="form-control">
   							 <c:forEach items="${articulos}" var="articulo">
      							<option value="${articulo.id}">${articulo.nombre}</option>
   								 </c:forEach>
  								</select>
								</div>
      						<div class="row">
      							<div class="col-md-6">
      								<label class="form-label">Fecha de Ingreso</label>
      								<input id="fechaIngreso" type="date" name="fechaIngreso" class="form-control" required>
      							</div>
      							<div class="col-md-6">
      								<label class="form-label">Precio de Compra</label>
      								<input id="precioCompra" type="number" min="0" name="precioCompra" class="form-control" required>
      							</div>
      						</div>
      						<div class="row">
	      						<div class="col-md-6">
	      							<label class="form-label">Cantidad</label>
	      							<input id="cantidad" type="number" min="0" name="cantidad" class="form-control" required>
	      						</div>
	      						
      						</div>
      						<div class="mt-5">
		        				<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
		        				<button type="submit" class="btn " style="background: #DAAE59; color: #fff;">Ingresar Stock</button>
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
	
	$.extend($.fn.dataTable.defaults, {
	    language: {
	      search: 'Buscar' ,
	      lengthMenu: 'Mostrar _MENU_ registros'
	    }
	  });
	
    $('#tableStocks').DataTable({
        order: [[0, 'desc']] // Ordena por la primera columna (ID) de forma descendente
    });
    
  $('#newStock').on("submit", function(e){
        e.preventDefault();
        let action = e.target.getAttribute('action');
        let data = {
			articulo: $('#articulo').val(),
			fechaIngreso: $('#fechaIngreso').val(),
			precioCompra: $('#precioCompra').val(),
		    cantidad: $('#cantidad').val(),
			
        }
		
        $.ajax({
            url: action +"/"+data.articulo+"/"+data.fechaIngreso+"/"+data.precioCompra+"/"+data.cantidad,
            method: "GET",
            success: function(data){
                console.log(data);
                let res = JSON.parse(data);

                if(res.status == 'ok'){
                    mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
                }
                if(res.status == 'error'){
                	errorNotification(res.message)
                }

            },
            error: function(res, error) {
                console.log(res);
                console.log(error);
                errorNotification(res.message + ". Refrescando sitio...");
            }
        })
	});
 });
    
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

	function errorNotification(mensaje){
		toastr.options = {
		        closeButton: true,
		        progressBar: true,
		        positionClass: "toast-top-right",
		        timeOut: 2000 // Duración de la notificación en milisegundos (3 segundos en este caso)
		    };

		    // Muestra la notificación Toastr
		    toastr.error(mensaje, "Error", {
		    });
		
	}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</body>

</html>