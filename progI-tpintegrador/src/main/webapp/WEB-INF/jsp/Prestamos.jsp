<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Prestamos</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Banco</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/clientes">Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/prestamos">Prestamos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout">Logout</a>
        </li>
        <li class="nav-item">
          Usuario: <span>${userName}</span>
        </li>
      </ul>
    </div>
  </div>
</nav>

<h1>Prestamos</h1>

    <script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
    </script>

    <table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>Nro Prestamo</th>
                <th>Fecha</th>
                <th>Dni Cliente</th>
                <th>Nombre y Apellido Cliente</th>
                <th>Monto</th>
                <th>Total de Cuotas</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>04/06/2021</td>
                <td>42544654</td>
                <td>Tiger Nixon</td>
                <td>$610</td>
                <td>5</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <th>Nro Prestamo</th>
                <th>Fecha</th>
                <th>Dni Cliente</th>
                <th>Nombre y Apellido Cliente</th>
                <th>Monto</th>
                <th>Total de Cuotas</th>
            </tr>
        </tfoot>
    </table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>