<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/navbar.css"/>'>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    	<img class="navLogo" src='<c:url value="/resources/img/logo-navbar.png"/>'/>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav ms-auto navbar-text">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Articulos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Ventas</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>