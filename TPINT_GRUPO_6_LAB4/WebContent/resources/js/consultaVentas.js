$(document).ready( function () {

});

function obtenerVentas(){
    let fechaInicio = $("#fechaInicio").val();
    let fechaFin = $("#fechaFin").val();

    if(!fechaInicio || !fechaFin){
        alert("Seleccione fechas validas");
        return;
    }

    window.location.href = `/ventas/consultas/${fechaInicio}/${fechaFin}`;
}
