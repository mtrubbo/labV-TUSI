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
</br>
<form action="/clientes/crear" method="POST">
    <label for="dni">DNI: </label>
    <input id="dni" name="dni" />

    </br>
    <label for="nombre">Nombre: </label>
    <input id="nombre" name="nombre" />

    </br>
    <label for="apellido">Apellido: </label>
    <input id="apellido" name="apellido" />

	</br>
    <label for="sexo">Sexo: </label>
    <select id="sexo" name="sexo">
      <option value="Masculino" selected>Masculino</option>
      <option value="Femenino">Femenino</option>
      <option value="Otro">Otro</option>
    </select>

    </br>
    <label for="fechaNac">Fecha de nacimiento: </label>
    <input type="date" id="fechaNac" name="fechaNac" />

    </br>
    <label for="direccion">Direccion: </label>
    <input id="direccion" name="direccion" />

    </br>
    <label for="localidad">Localidad: </label>
    <input id="localidad" name="localidad" />

    </br>
    <label for="email">Email: </label>
    <input id="email" name="email" />

    </br>
    <label for="telefono">Telefono: </label>
    <input id="telefono" name="telefono" />

    </br>
    </br>
    <input type="submit" value="Aceptar" />
</form>

${Mensaje}

</body>
</html>