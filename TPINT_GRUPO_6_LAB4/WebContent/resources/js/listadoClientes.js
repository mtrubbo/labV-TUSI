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

            $('#id').val(res.id);
            $('#dni').val(res.dni);
            $('#nombre').val(res.nombre);
            $('#apellido').val(res.apellido);
            $('#sexo').val(res.sexo);
            $('#fechaNac').val(res.fechaNac);
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
    let eliminar = confirm("Desea eliminar el cliente?");
    if(!eliminar) return;

    $.ajax({
        url: "/clientes/eliminar/"+id,
        method: "GET",
        success: function(data){
            if(data == "true"){
                alert('Cliente eliminado exitosamente.');
                window.location.reload();
            }
            else {
                alert('Error al eliminar cliente.');
            }
        },
        error: function(res, error) {
            console.log(res)
        }
    })
}