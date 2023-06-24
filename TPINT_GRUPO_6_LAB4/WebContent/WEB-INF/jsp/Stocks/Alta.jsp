<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de stock</title>
</head>
<body>

<h2>Alta de stock</h2>
</br>
<form action="/stocks/crear" method="POST">
    <label for="articulo">Articulo: </label>
    <input id="articulo" name="articulo" />

    </br>
    <label for="fechaIngreso">Fecha de Ingreso: </label>
    <input id="fechaIngreso" name="fechaIngreso" />

    </br>
    <label for="precioCompra">Precio de Compra: $ </label>
    <input id="precioCompra" name="precioCompra" />
    
    </br>
    <label for="cantidad">Cantidad: </label>
    <input id="cantidad" name="cantidad" />
    
   
    </br>
    <input type="submit" value="Aceptar" />
</form>

${Mensaje}

</body>
</html>