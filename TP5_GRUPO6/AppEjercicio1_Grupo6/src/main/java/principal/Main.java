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
		Usuario u = (Usuario)appContext.getBean("Usuario");
		System.out.println("Salida: "+u.toString());
		((ConfigurableApplicationContext)(appContext)).close();

	    
	    /*UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    if(estado)
	    	System.out.println("Se agrego correctamente");
	    else
	    	System.out.println("No se pudo agregar, el usuario ya existe en la BD");*/
		    	
	}	
}
