<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/navbar.css"/>'>
</head>
<body>

    <%String atributo = (String) request.getSession().getAttribute("usuarioRol");%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">
    	<img class="navLogo" src='<c:url value="/resources/img/logo-navbar.png"/>'/>
    </a>
    <h5 style="display:inline-block;z-index:500;color:#fff">Usuario: <%=atributo%></h5>
      
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav ms-auto navbar-text">
      
      	<%
		if (atributo.equalsIgnoreCase("vendedor")) {
	%>
	        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/clientes">Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/articulos">Articulos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/stocks">Stocks</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/ventas">Ventas</a>
        </li>
	<%} %>
	
	
	      	<%
		if (atributo.equalsIgnoreCase("contador")) {
	%>
	        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/ventas/consultas">Consultas</a>
        </li>
	<%} %>
	

         <li class="nav-item">
          <a class="nav-link btn btn-success" href="${pageContext.request.contextPath}/logout">Salir</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>