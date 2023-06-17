<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de clientes</title>


<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/articulos.css"/>'>
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

</head>
<body>
<jsp:include page="../components/Navbar.jsp"></jsp:include>
<main class="articulosBody d-flex justify-content-center align-items-center flex-column w-100" style="background-image: url('${pageContext.request.contextPath}/resources/img/home-background.jpg');">
	<section class="sectionTable">
        <h2>Clientes</h2>

        <!-- Action Modal -->
        	<button type="button" class="btnNewArt " data-bs-toggle="modal" data-bs-target="#modal" onclick='crearOpen()'>
          		Nuevo cliente
        	</button>

        <table id="tableArticulos" class="responsive table table-striped dataTables_wraper">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Sexo</th>
                    <th>Fecha de nacimiento</th>
                    <th>Direccion</th>
                    <th>Localidad</th>
                    <th>Email</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="item">
                    <tr>
                    <td>${item.dni}</label> </td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.sexo}</td>
                    <td>${item.fechaNac}</td>
                    <td>${item.direccion}</td>
                    <td>${item.localidad}</td>
                    <td>${item.email}</td>
                    <td>${item.telefono}</td>
                    <td>
                        <button class="btnTableEdit" onclick='editOpen(${item.id})'><i class="fa-solid fa-pencil"></i></button>
                        <button onclick='eliminar(${item.id})'>
                            <i class="fa-solid fa-trash"></i>
                        </button>
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section> <!-- END DATATABLE -->

    <!-- Modal -->
    <div class="modal fade" id="modal" tabindex="-1" aria-labelledby="newArtlabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="tituloModal">Nuevo cliente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <jsp:include page="./AltaModificacionForm.jsp"></jsp:include>
                </div>
                <p id="resultadoOperacion"></p>
            </div>
        </div>
    </div>

	<!-- scripts -->
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.13.4/datatables.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        $(document).ready( function () {
            $('#formulario').on("submit", (e) => {
                e.preventDefault();
                let action = e.target.getAttribute('action');
                let data = {
                    id: Number($('#id').val()),
                    dni: $('#dni').val(),
                    nombre: $('#nombre').val(),
                    apellido: $('#apellido').val(),
                    sexo: $('#sexo').val(),
                    fechaNac: $('#fechaNac').val(),
                    direccion: $('#direccion').val(),
                    localidad: $('#localidad').val(),
                    email: $('#email').val(),
                    telefono: $('#telefono').val(),
                }

                $.ajax({
                    url: action,
                    method: "POST",
                    data,
                    success: function(data){
                        console.log(data);
                        let res = JSON.parse(data);

                        if(res.status == 'ok'){
                            $('#resultadoOperacion').text(res.message + ". Refrescando sitio...");
                            setTimeout(function(){
                               window.location.reload();
                            }, 1000);
                        }
                        else{
                            $('#resultadoOperacion').text(res.message);
                        }

                    },
                    error: function(res, error) {
                        console.log(res);
                        console.log(error);
                        $('#resultadoOperacion').text('Error al realizar peticion');
                    }
                })
            });
        });

        function editOpen(id){
            $.ajax({
                url: "/clientes/"+id,
                method: "GET",
                success: function(json){
                    let res = JSON.parse(json);
                    console.log(res);

                    // Por que no muestra la fecha en el input???????
                    let fecha = new Date(res.fechaNac).toLocaleDateString("en-US").replace('/', '-');
                    console.log(fecha);

                    $('#id').val(res.id);
                    $('#dni').val(res.dni);
                    $('#nombre').val(res.nombre);
                    $('#apellido').val(res.apellido);
                    $('#sexo').val(res.sexo);
                    $('#fechaNac').val(fecha);
                    $('#direccion').val(res.direccion);
                    $('#localidad').val(res.localidad);
                    $('#email').val(res.email);
                    $('#telefono').val(res.telefono);
                },
                complete: function() {
                    document.getElementById('formulario')
                      .setAttribute('action', '/clientes/modificar');

                    $('#tituloModal').text('Actualizar cliente');
                    $('#modal').modal('toggle');
                }

            })
        }

        function crearOpen(){
            $('#tituloModal').text('Nuevo cliente');
            document.getElementById('formulario')
              .setAttribute('action', '/clientes/crear');

            $('#id').val('');
            $('#dni').val('');
            $('#nombre').val('');
            $('#apellido').val('');
            $('#sexo').val('');
            $('#fechaNac').val('');
            $('#direccion').val('');
            $('#localidad').val('');
            $('#email').val('');
            $('#telefono').val('');
        }

        function eliminar(id){
            $.ajax({
                url: "/clientes/eliminar/"+id,
                method: "GET",
                success: function(data){
                    alert('Cliente eliminado exitosamente!');
                    window.location.reload();
                },
                error: function(res, error) {
                    console.log(res)
                }
            })
        }
    </script>
</body>
</html>