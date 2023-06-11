<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de articulos</title>
</head>
<body>


${Mensaje}

<br/><br/><br/>

<h2>Articulos</h2>
	<table border="1px">
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
				<td>${item.marca}</td>
				<td>${item.tipo}</td>
				<td>${item.precio}</td>
				<td><a href="<c:url value='/articulos/eliminar/${item.id}' />"  >Eliminar</a></td>

				</tr>
				
			</c:forEach>
	    </tbody>
	</table>
</body>
</html>