<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de clientes</title>


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

</head>
<body style="background-color:#10ba99">
<jsp:include page="../components/Navbar.jsp"></jsp:include>
<!-- style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');" -->
<main class="articulosBody d-flex justify-content-center align-items-center flex-column w-100">
	<section style="width:90%;" class="sectionTable">
		<input type="hidden" id="pathGlobal" value="${pageContext.request.contextPath}">
        <h2>Clientes</h2>

        <!-- Action Modal -->
        	<button type="button" class="btnNewArt " data-bs-toggle="modal" data-bs-target="#modal" onclick='crearOpen()'>
          		Nuevo cliente
        	</button>

        <table id="tableClientes" class="responsive table table-striped dataTables_wraper">
            <thead>
                <tr>
                	<th style="display: none">ID</th>
                    <th>DNI</th>
                    <th>Nombre</th>

                    <th style="display: none">Sexo</th>
                    <th style="display: none">Fecha de nacimiento</th>
                    <th style="display: none">Direccion</th>
                    <th>Localidad</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="item">
                    <tr>
                    <td style="display: none">${item.id} </td>
                    <td>${item.dni}</label> </td>
                    <td>${item.nombre} ${item.apellido}</td>
                    <td style="display: none">${item.sexo}</td>
                    <td style="display: none">${item.fechaNac}</td>
                    <td style="display: none">${item.direccion}</td>
                    <td>${item.localidad}</td>
                    <td>${item.email}</td>
                    <td>${item.telefono}</td>
                    <td>
                        <button class="btnNewArt" onclick='editOpen(${item.id})'><i class="fa-solid fa-pencil"></i></button>
                        <button onclick='eliminar(${item.id})'>
                            <i class="fa-solid fa-trash btnCancel" style="border:0'"></i>
                        </button>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section> <!-- END DATATABLE -->

    <!-- Modal -->
    <div class="modal fade" id="modal" tabindex="-1" aria-labelledby="newArtlabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="tituloModal">Nuevo cliente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <jsp:include page="./AltaModificacionForm.jsp"></jsp:include>
                </div>
                <p id="resultadoOperacion"></p>
            </div>
        </div>
    </div>

	<!-- scripts -->
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src='<c:url value="/resources/js/listadoClientes.js"/>'></script>

	<script type="text/javascript">
		$(document).ready( function () {
			
			$.extend($.fn.dataTable.defaults, {
				    language: {
				      search: 'Buscar' ,
				      lengthMenu: 'Mostrar _MENU_ registros'
				    }
				  });
			  
	    	$('#tableClientes').DataTable({
	        	order: [[0, 'desc']] // Ordena por la primera columna (ID) de forma
									// descendente
	    	});
		});
    </script>
</body>
</html>