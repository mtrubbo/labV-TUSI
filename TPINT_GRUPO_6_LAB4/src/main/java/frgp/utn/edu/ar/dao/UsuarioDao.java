package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.dominio.Usuario;

public interface UsuarioDao {
    Usuario obtenerUsuario(String nombreUsuario);
}
