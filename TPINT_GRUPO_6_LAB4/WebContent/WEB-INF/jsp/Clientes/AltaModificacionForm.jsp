<form id="formulario" action="/clientes/crear" method="POST">
    <input id="id" type="hidden" name="id" />

    <div class="row">
        <label class="form-label" for="dni">DNI: </label>
        <input class="form-control" type="number" min="0" id="dni" name="dni" />
    </div>
    <div class="row">
        <label class="form-label" for="nombre">Nombre: </label>
        <input class="form-control" id="nombre" name="nombre" />
    </div>
    <div class="row">
        <label class="form-label" for="apellido">Apellido: </label>
        <input class="form-control" id="apellido" name="apellido" />
    </div>
    <div class="row">
        <label class="form-label" for="sexo">Sexo: </label>
        <select class="form-control" id="sexo" name="sexo">
          <option value="Masculino" selected>Masculino</option>
          <option value="Femenino">Femenino</option>
          <option value="Otro">Otro</option>
        </select>
    </div>
    <div class="row">
        <label class="form-label" for="fechaNac">Fecha de nacimiento: </label>
        <input class="form-control" type="date" id="fechaNac" name="fechaNac" />
    </div>
    <div class="row">
        <label class="form-label" for="direccion">Direccion: </label>
        <input class="form-control" id="direccion" name="direccion" />
    </div>
    <div class="row">
        <label class="form-label" for="localidad">Localidad: </label>
        <input class="form-control" id="localidad" name="localidad" />
    </div>
    <div class="row">
        <label class="form-label" for="email">Email: </label>
        <input class="form-control" id="email" name="email" />
    </div>
    <div class="row">
        <label class="form-label" for="telefono">Telefono: </label>
        <input class="form-control" type="number" min="0" id="telefono" name="telefono" />
    </div>
    <div class="mt-5">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="submit" class="btn btn-primary">Aceptar</button>
    </div>
</form>