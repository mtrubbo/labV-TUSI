package resources;

import org.springframework.context.annotation.Configuration;

import entidad.Usuario;

@Configuration
public class Config {
	
	//Bean Usuario
	public Usuario getUsuario() {
		Usuario u = new Usuario();
		u.setUsuario("admin");
		u.setContrasenia("admin");
		return u;
	}
	
}
