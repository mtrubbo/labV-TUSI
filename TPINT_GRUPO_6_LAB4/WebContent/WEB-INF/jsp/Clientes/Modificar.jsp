<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar cliente</title>
</head>
<body>

<h2>Actualizar cliente</h2>
</br>

<form action="/clientes/modificar" method="POST">
    <input type="hidden" name="id" value="${Cliente.getId()}" />

    <label for="dni">DNI: </label>
    <input id="dni" name="dni" value="${Cliente.getDni()}" />

    </br>
    <label for="nombre">Nombre: </label>
    <input id="nombre" name="nombre" value="${Cliente.getNombre()}" />

    </br>
    <label for="apellido">Apellido: </label>
    <input id="apellido" name="apellido" value="${Cliente.getApellido()}" />

    <c:set var="sexo" value="${Cliente.getSexo()}" />

	</br>
    <label for="sexo">Sexo: </label>
    <select id="sexo" name="sexo">
      <option value="Masculino" <c:if test="${sexo == 'Masculino'}">selected</c:if>>Masculino</option>
      <option value="Femenino" <c:if test="${sexo == 'Femenino'}">selected</c:if>>Femenino</option>
      <option value="Otro" <c:if test="${sexo == 'Otro'}">selected</c:if>>Otro</option>
    </select>

    </br>
    <label for="fechaNac">Fecha de nacimiento: </label>
    <input type="date" id="fechaNac" name="fechaNac" value="${Cliente.getFechaNac()}" />

    </br>
    <label for="direccion">Direccion: </label>
    <input id="direccion" name="direccion" value="${Cliente.getDireccion()}" />

    </br>
    <label for="localidad">Localidad: </label>
    <input id="localidad" name="localidad" value="${Cliente.getLocalidad()}" />

    </br>
    <label for="email">Email: </label>
    <input id="email" name="email" value="${Cliente.getEmail()}" />

    </br>
    <label for="telefono">Telefono: </label>
    <input id="telefono" name="telefono" value="${Cliente.getTelefono()}" />

    </br>
    </br>
    <input type="submit" value="Aceptar" />
</form>

${Mensaje}

</body>
</html>