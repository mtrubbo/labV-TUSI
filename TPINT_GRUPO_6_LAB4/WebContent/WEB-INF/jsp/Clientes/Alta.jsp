<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de cliente</title>
</head>
<body>

<h2>Alta de cliente</h2>

<form action="/clientes/crear" method="post">
	<table>
	<tr> <td> Nombre:  </td> <td> <input name="nombre"/> </td></tr>
	<tr>  <td> Apellido: </td> <td>  <input name="apellido"/> </td></tr>
	<tr>  <td> </td> <td> <input type="submit" name="btnAceptar" value="Aceptar"> </td></tr>
	</table>
</form>

${Mensaje}

</body>
</html>