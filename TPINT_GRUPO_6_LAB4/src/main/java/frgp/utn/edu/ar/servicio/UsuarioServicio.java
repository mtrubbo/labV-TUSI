package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Usuario;

public interface UsuarioServicio {

	ArrayList<Usuario> obtenerUsuarios();

	Usuario obtenerUnRegistro(String nombreUser);

	void insertarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUser) ;

	void actualizarUsuario(Usuario usuario);
	
}
