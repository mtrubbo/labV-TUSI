package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;

public class Main {

	static ApplicationContext appContext;
	
	public static void main(String[] args) {

	    appContext = new ClassPathXmlApplicationContext("resources/Bean.xml");

		// Instanciar clases desde el contenedor
		Usuario usuario = (Usuario)appContext.getBean("Usuario");
		System.out.println("Usuario: " + usuario.toString());

		UsuarioNegocio usuarioNegocio = (UsuarioNegocio)appContext.getBean("UsuarioNegocio");
		System.out.println("Usuario negocio: " + usuarioNegocio.toString());

		((ConfigurableApplicationContext)(appContext)).close();

	    // Comprobar correcto funcionamiento
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    if(estado)
	    	System.out.println("Se agrego correctamente");
	    else
	    	System.out.println("No se pudo agregar, el usuario ya existe en la BD");


	}	
}
