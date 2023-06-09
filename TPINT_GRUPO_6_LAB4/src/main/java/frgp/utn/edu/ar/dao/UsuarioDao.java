package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Usuario;


public interface UsuarioDao {

	//Alta de persona
	public void insertarUsuario(Usuario usuario);

	//Obtiene una persona por dni
	public Usuario obtenerUsuarioPorNombre(String nombreUser);

	//Obtiene todas las presonas
	public ArrayList<Usuario> obtenerUsuarios();

	//Elimina una presona a aprtir del dni
	public void eliminarUsuario(Integer idUsuario);

	//Actualiza los datos de una persona
	public void actualizarUsuario(Usuario usuario);
	

}
