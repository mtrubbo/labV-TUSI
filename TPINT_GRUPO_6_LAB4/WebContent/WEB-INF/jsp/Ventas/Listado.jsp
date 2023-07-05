<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ventas</title>

<style>
    :root {
        --contextPath: "${pageContext.request.contextPath}";
    }
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/ventas.css"/>'>
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
<body style="background-color:#10ba99">


<jsp:include page="../components/Navbar.jsp"></jsp:include>
<main class="articulosBody d-flex justify-content-center align-items-center flex-column w-100">
	<section class="sectionTable">
	<div class="row justify-content-around">
		<h2>Ventas</h2>
		<p>${Mensaje}</p>
	</div>
	
	<!-- Action Modal -->
	<button type="button" class="btnNewVent btnNewArt" data-bs-toggle="modal" data-bs-target="#newVent">
  		Nueva Venta
	</button>
	
	
	<!-- INICIO DATATABLE -->
	<table id="tableVentas" class="responsive table table-striped dataTables_wraper">
		<thead>
			<tr>
				<th>N° Venta</th>
				<th>Fecha</th>
				<th>Cliente</th>
				<th>Monto total</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ventas}" var="item">
				<tr>
					<td>${item.id}</label> </td>
					<td>${item.fecha}</td>
					<td>${item.cliente.nombre} ${item.cliente.apellido}</td>
					<td>${item.montoTotal}</td>
					<td>
						<button class="btnTableDetalle btnNewArt" onclick='detalleOpen(${item.id})'>
							<i class="fas fa-eye"></i>
						</button>
						<button class="btnTableDelete btnCancel" onclick='confirmDelete(${item.id})'>
							<i class="fa-solid fa-trash"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	</section>
	<!-- END DATATABLE -->
	
	<!-- MODALS -->
	<!-- Modal NUEVA VENTA -->
		<div class="modal fade" id="newVent" tabindex="-1" aria-labelledby="newVentlabel" aria-hidden="true">
  			<div class="modal-dialog modal-lg">
    			<div class="modal-content">
      				<div class="modal-header" style="background: #10ba99; color: #fff;">
        				<h5 class="modal-title" id="newVentlabel">Nueva Venta</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      				</div>
      				<div class="modal-body">
      					<form id="ingresarventa" action="${pageContext.request.contextPath}/ventas/crear" method="GET">
      						<input type="hidden" id="estado" value="true" name="estado">
      						<div class="row mb-4">
      							<h5>Cliente</h5>
	      						<div class="col-md-4">
	      							<label class="form-label">Fecha Venta</label>
	      							<input id="fechaVenta" type="date" name="fecha" class="form-control" required>
	      						</div>
	      						<div class="col-md-6">
      								<label class="form-label">Cliente</label>
	      							<select id="cliente" name="tipo" class="form-control">
   							 			<c:forEach items="${clientes}" var="item">
      										<option value="${item.id}">${item.dni} - ${item.nombre} ${item.apellido}</option>
   								 		</c:forEach>
  									</select>
      							</div>
      						</div>
      						
      			
      						
      						<div class="row mb-4">
      						<h5>Articulos</h5>
      							<div class="col-md-6">
      								<label class="form-label">Articulos</label>
      								<select id="selectArt" name="tipo"  class="form-control">
      									<option value="-1">Seleccionar un articulo...</option>
   							 			<c:forEach items="${Articulos}" var="item">
      										<option value="${item.id}">${item.nombre}</option>
   								 		</c:forEach>
  									</select>
      							</div>
      							<div class="col-md-6">
	      							<label class="form-label">Cantidad</label>
	      							<input id="cantidad" type="number" min="1" name="cantidad" class="form-control" required>
	      						</div>
      							<div class="col-md-6">
	      							<label class="form-label">Precio Unitario</label>
	      							<input id="precio" disabled type="number" min="0" name="precio" class="form-control" required>
	      						</div>
	      						<div class="col-md-6">
	      							<label class="form-label">Precio Total</label>
	      							<input id="precioTotal" disabled type="number" name="precio" class="form-control" required>
	      						</div>
	      						<div class="col-md-6 mx-auto mt-1 text-center">
	      						</div>
	      						<div class="col-md-6 mx-auto mt-3 text-right w-100">
		      						<button type="button" class="btn btnNewArt" id="addArtToList">Agregar</button>
	      						</div>
	      					</div>	
      						<div class="row">
							<h5>Articulos Agregados</h5>
								<div id="addings" class="border mb-4">
								</div>
      						</div>
      						<div class="row">
      						<h5>Totales y subtotales</h5>
      							<div class="col-md-6">
      								<label class="form-label">Monto total de compra</label>
	      							<input id="montoTotal" disabled type="number" name="precio" class="form-control" required>
      							</div>
      						</div>
      						<div class="mt-3">
		        				<button type="button" class="btn btnCancel" data-bs-dismiss="modal">Cancelar</button>
		        				<button type="submit" class="btn btnNewArt">Ingresar Venta</button>
							</div>
      					</form>
    			</div>
  			</div>
		</div>
		</div>
		
		
		<!-- Modal Borrar -->
		<div class="modal fade" id="deleteVent" tabindex="-1" aria-labelledby="deleteVentLabel" aria-hidden="true">
  			<div class="modal-dialog modal-lg">
    			<div class="modal-content">
      				<div class="modal-header" style="background: #B32D2D; color: #fff">
        				<h5 class="modal-title" id="deleteVentLabel">Borrar Venta</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      				</div>
      				<div class="modal-body">
      					<form id="formDelete" action="${pageContext.request.contextPath}/ventas/eliminar" method="GET">
      						<!-- <input type="hidden" id="estado" value="true" name="estado">-->
      						<p style="font-weight: bold; font-size:20px;">Usted esta a punto de eliminar una venta</p>
      						<p>¿Seguro desea realizar la operacion?</p>
      						<div class="mt-3">
      							<button type="button" data-bs-dismiss="modal" class="btn btn-secondary">Cancel</button>
      							<button class="btn btn-danger" type="submit">OK</button>
      						</div>
      					</form>
    			</div>
  			</div>
		</div>
		</div>
		
		
		<!-- MODAL DETALLE -->
		<div class="modal fade" id="detalleVent" tabindex="-1" aria-labelledby="detalleVentlabel" aria-hidden="true">
  			<div class="modal-dialog modal-lg">
    			<div class="modal-content">
      				<div class="modal-header" style="background: #DAAE59; color: #fff;">
        				<h5 class="modal-title" id="newVentlabel">Detalle de Venta</h5>
        				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      				</div>
      				<div class="modal-body">
      					<form id="formDetalle" action="${pageContext.request.contextPath}/ventas/detalle" method="GET">
      						<input type="hidden" id="estado" value="true" name="estado">
      						<div class="row mb-5">
      							<h5>Cliente</h5>
	      						<div class="col-md-4">
	      							<label class="form-label">Fecha Venta</label>
	      							<input id="dfechaVenta" type="date" name="fecha" class="form-control" required disabled>
	      						</div>
	      						<div class="col-md-6">
      								<label class="form-label">Cliente</label>

			
      										<input id="dcliente" name="cliente" class="form-control" type="text" value="${item.id}" disabled>${item.nombre} ${item.apellido}</input>


      							</div>
      						</div>
      						
      						<!--
      						<div class="row mb-5">
      						<h5>Articulos</h5>
      							<div class="col-md-6">
      								<label class="form-label">Articulos</label>
      								<input id="darticulos" name="articulos" class="form-control" type="text" value="${item.id}" disabled>${item.nombre}</input>
      							</div>
								      							
								<div class="col-md-6">
	      							<label class="form-label">Cantidad</label>
	      							<input id="dcantidad" disabled type="number" min="1" name="cantidad" class="form-control" required>
	      						</div>
      							<div class="col-md-6">
	      							<label class="form-label">Precio Unitario</label>
	      							<input id="dprecio" disabled type="number" min="0" name="precio" class="form-control" required>
	      						</div>
	      						<div class="col-md-6">
	      							<label class="form-label">Precio Total</label>
	      							<input id="dprecioTotal" disabled type="number" name="precio" class="form-control" required>
	      						</div> 

								<div class="col-md-6 mx-auto mt-3 text-center">
		      						<button type="button" class="btn btn-primary" id="addArtToList">Agregar</button>
	      						</div>
	      						 
	      					</div>	
	      					-->
	      					
      						<div class="row">
							<h5>Articulos Agregados</h5>
								<div id="daddings" class="border mb-4">
								</div>
      						</div>
      						<div class="row">
      						<h5>Totales y subtotales</h5>
      							<div class="col-md-6">
      								<label class="form-label">Monto total de compra</label>
	      							<input id="dmontoTotal" disabled type="number" name="precio" class="form-control" required>
      							</div>
      						</div>
      						<div class="mt-5">
		        				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		        				<!-- <button type="submit" class="btn " style="background: #DAAE59; color: #fff;">Ingresar Venta</button> -->
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
	
    $('#tableVentas').DataTable({
        order: [[0, 'desc']] // Ordena por la primera columna (ID) de forma descendente
    });
    

    $('#selectArt').on('change', function(){
    	let idArt = $(this).val();
    	console.log(idArt);
    	
    	$.ajax({
    		url: "${pageContext.request.contextPath}/ventas/getArticulo_by_venta/"+idArt,
            method: "GET",
            success: function(data){    	
                let res = JSON.parse(data);
                $('#precio').val(res.precio)
            },
            error: function(res, error) {
                console.log(res);
                console.log(error);
                
            }
    	})
    });
    
    
    $('#ingresarventa').on('submit', function(e) {
    	  e.preventDefault();
          let action = e.target.getAttribute('action');
    	  let selectedIDs = [];
    	  let cantidadesxart = [];
    	  
    	  /*ES ACA*/
    	  
    	  $('#addings .cardAddedArt').each(function(index, element) {
    	    var id = $(this).attr('id');
      	    console.log('Articulo guarda: ' + id);     	 
    	    selectedIDs.push(id);
    	    
      	    var cant = $(this).find('[name]').attr('name');   
      	    console.log('Cantidad guarda: ' + cant);     	 
      	    cantidadesxart.push(cant);
    	  });
    	      	      	         	     	  

    	  let data = {
    	    	  fechaVenta: encodeURIComponent($('#fechaVenta').val()),
    	    	  cliente: encodeURIComponent($('#cliente').val()),
    	    	  montoTotal: encodeURIComponent($('#montoTotal').val()),
    	    	 
    	  }
    	  
    	  $.ajax({
    	    url: action +"/"+ data.fechaVenta + '/' + data.cliente + '/' + data.montoTotal + '/' + selectedIDs.join(',') + '/' + cantidadesxart.join(','),
    	    type: 'GET',
    	    success: function(response) {
    	      let res = JSON.parse(response);
    	      
    	      if(res.status == "ok"){
    	    	  //alert("insertado");
                  mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
    	      }
    	      else{
    	    	  //alert("Ha ocurrido un error");
    	    	  mostrarNotificacionYRecargar(res.message + ". Refrescando sitio...");
    	      }
    	    },
    	    error: function(error) {
    	      // Manejar el error de la solicitud AJAX
    	    }
    	  });
    	});
    
    $('#cantidad').on('change', function(e){
    	if($('#selectArt').val() != -1){
    		
    		let price = Number($('#precio').val());
    		let totalPrice = price*Number($(this).val());
    		
    		$('#precioTotal').val(totalPrice);
    		
    	}
    	else{
    		$(this).val("");
    	}
    });
    
    $('#addArtToList').on('click', function(e){
    	let item = "";
    	let infoSelect = $('select[id="selectArt"] option:selected').text();
    	let idSelect = $('#selectArt').val();
    	let qt = $('#cantidad').val();
    	let total = $('#precioTotal').val();
    	let isAdded = false;
    	
    	
  	  
  	  $('#addings .cardAddedArt').each(function(index, element) {
  	    	var id = $(this).attr('id');
  	    	if(id == idSelect){
  	    		isAdded = true;
  	    	}
  	  	});
    	
  	  if(!isAdded){
	 	$.ajax({
    		url: "/ventas/hasStock_by_id/"+idSelect+"/"+qt,
    		method: "GET",
    		success: function(res){
    			let response = JSON.parse(res);
    			
    			if(response.status == "ok"){
    				
    				let montoTotal = Number($('#montoTotal').val());
    				
    				montoTotal += Number(total);
    				$('#montoTotal').val(montoTotal);
    				
    				
    		    	item += '<div id="'+idSelect+'" class="cardAddedArt">';
    		    	item += '<button class="eraseButton" onclick="eraseArt('+idSelect+')">x</button>';
    		    	item += '<p>'+infoSelect+'</p>';
    		    	item += "<p name="+qt+"> x"+qt+"</p>";
    		    	item += "<p id='total'> Total por seleccion: "+total+"</p>";
    		    	item += "</div>";
    		    	
    		    	$('#addings').append(item);
    			}
    			else{
    				alert(response.message);
    			}
    		}
    	});
  	  }
  	  else{
  		  alert("el articulo ya ha sido añadido!");
  	  }
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

function eraseArt(id){
	let total;
	  $('#addings .cardAddedArt').each(function(index, element) {
	    	var idart = $(this).attr('id');
	    	if(id == id){
	    		total = $(this).attr('total');
	    	}
	  	});
	  
	  let montoTotal = Number($('#montoTotal').val());
	  montoTotal-=Number(total);
	  $('#montoTotal').val(montoTotal);
	 $('#' + id).remove();
}

function confirmDelete(id){
	$('#formDelete').attr('action', '${pageContext.request.contextPath}/ventas/eliminar/'+id);
	$('#deleteVent').modal('toggle');
}

function detalleOpen(id){
	window.location.href = "${pageContext.request.contextPath}/ventas/detalle/"+id;
    /*
    $.ajax({
        url: "${pageContext.request.contextPath}/ventas/detalle/"+id,
        method: "GET",
        
        success: function(json){
            let res = JSON.parse(json);
            console.log(res);
            
        	//$('#dfechaVenta').val(res);
        	//$('#dcliente').val(res.cliente);
        	//$('#dmontoTotal').val(res.montoTotal);	
        },        
        complete: function() {
        	//limpiar
        	//$('#daddings').append(item);
        	let item="";
        	item += '<div id="'+20+'" class="cardAddedArt">';
        	item += '<p>'+'Producto: '+'leche'+'</p>';
        	item += "<p id='total'> Total del producto: $<b>"+22050+"</b></p>";
        	item += "</div>";	
        	$('#daddings').append(item);
      		$('#detalleVent').modal('toggle');
      }
	})*/
        
}




function editOpen(id){
	let pathAction = $('#pathGlobal').val(); 
    $.ajax({
        url: pathAction+"/clientes/"+id,
        method: "GET",
        success: function(json){
            let res = JSON.parse(json);
            console.log(res);

            $('#id').val(res.id);
            $('#dni').val(res.dni);
            $('#nombre').val(res.nombre);
            $('#apellido').val(res.apellido);
            $('#sexo').val(res.sexo);
            $('#fechaNac').val(res.fechaNac);
            $('#direccion').val(res.direccion);
            $('#localidad').val(res.localidad);
            $('#email').val(res.email);
            $('#telefono').val(res.telefono);
        },
        complete: function() {
            document.getElementById('formulario')
              .setAttribute('action', '/clientes/modificar');

            $('#tituloModal').text('Actualizar cliente');
            $('#modal').modal('toggle');
        }

    })
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
</script>
<c:if test="${not empty sessionScope.mensaje}">
    <%-- Configurar la notificación Toastr --%>
    <script>
    mostrarNotificacionYRecargar("${sessionScope.mensaje}")
    </script>

    <%-- Limpiar el mensaje de la sesión para que no se muestre nuevamente en futuras peticiones --%>
    <% session.removeAttribute("mensaje"); %>
</c:if>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</body>

</html>