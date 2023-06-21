package frgp.utn.edu.ar.servicio;

import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.dtos.LoginRequest;

public interface LoginServicio {
    Usuario autenticar(LoginRequest datosLogin);
}
