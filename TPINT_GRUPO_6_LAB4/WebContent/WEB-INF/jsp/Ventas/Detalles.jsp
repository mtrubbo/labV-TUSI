<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de venta</title>
<!-- ContextPath setting in css, DO NOT TOUCH!!! -->
<style>
    :root {
        --contextPath: "${pageContext.request.contextPath}";
    }
</style>

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/consultaventas.css"/>'>
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
<main class="consultasBody d-flex justify-content-center align-items-center flex-column w-100 " style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');">

    <section style="margin-top: 1.5rem;" class="sectionTable">
        <div class="row justify-content-around">
            <h2>Detalles</h2>
        </div>


        <table id="tableArticulos" class="responsive table table-striped dataTables_wraper">
        		<thead>
        			<tr>
        				<th>Nombre</th>
        				<th>Descripcion</th>
        				<th>Marca</th>
        				<th>Tipo</th>
        				<th>Precio</th>
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${articulos}" var="item">
        				<tr>
        					<td>${item.nombre}</label> </td>
        					<td>${item.descripcion}</td>
        					<td>${item.marca.nombre}</td>
        					<td>${item.tipo.descripcion}</td>
        					<td>${item.precio}</td>
        				</tr>
        			</c:forEach>
        	    </tbody>
        	</table>
    </section>

</main>

<script type="text/javascript" src='<c:url value="/resources/js/consultaVentas.js"/>'></script>

<c:if test="${not empty sessionScope.mensaje}">
    <%-- Configurar la notificaci�n Toastr --%>
    <script>
    mostrarNotificacionYRecargar("${sessionScope.mensaje}")
    </script>

    <%-- Limpiar el mensaje de la sesi�n para que no se muestre nuevamente en futuras peticiones --%>
    <% session.removeAttribute("mensaje"); %>
</c:if>

<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</body>

</html>