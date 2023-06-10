<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de clientes</title>
</head>
<body>


${Mensaje}

<br/><br/><br/>

<h2>Clientes</h2>
	<table border="1px">
		<thead>
			<tr>
				<th>Id Usuario</th>
				<th>Usuario</th>
				<th>Contraseña</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="item">
				
				<tr>
			
				<td> ${item.dni}</label> </td>
				<td>${item.nombre}</td>
				<td>${item.apellido}</td>
				<td>${item.sexo}</td>
				<td>${item.fechaNac}</td>
				<td>${item.direccion}</td>
				<td>${item.localidad}</td>
				<td>${item.email}</td>
				<td>${item.telefono}</td>
				<td><a href="<c:url value='/clientes/eliminar/${item.id}' />"  >Eliminar</a></td>

				</tr>
				
			</c:forEach>
	    </tbody>
	</table>
</body>
</html>