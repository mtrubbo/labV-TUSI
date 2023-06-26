<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de articulo</title>
</head>
<body>

<h2>Alta de articulo</h2>
</br>
<form action="/articulos/crear" method="POST">
    <label for="nombre">Nombre: </label>
    <input id="nombre" name="nombre" />

    </br>
    <label for="descripcion">Descripcion: </label>
    <input id="descripcion" name="descripcion" />

    </br>
    <label for="marca">Marca: </label>
    <input id="marca" name="marca" />
    
    </br>
    <label for="tipo">Tipo: </label>
    <input id="tipo" name="tipo" />
    
    </br>
    <label for="precio">Precio: </label>
    <input id="precio"  name="precio" />

    </br>
    </br>
    <input type="submit" value="Aceptar" />
</form>

${Mensaje}

</body>
</html>