package principal;

import entidad.Usuario;
import negocio.UsuarioNegocio;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
	    usuario.setUsuario("Pepe");
	    usuario.setContrasenia("123");
	    
	    UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    if(estado)
	    	System.out.println("Se agrego correctamente");
	    else
	    	System.out.println("No se pudo agregar, el usuario ya existe en la BD");
		    	
	}	
}
