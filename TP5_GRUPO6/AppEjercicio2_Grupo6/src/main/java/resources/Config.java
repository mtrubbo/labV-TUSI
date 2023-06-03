package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entidad.Usuario;

@Configuration
public class Config {
	
	//Bean Usuario
	@Bean
	public Usuario Usuario() {
		Usuario u = new Usuario();
		u.setUsuario("admin");
		u.setContrasenia("admin");
		return u;
	}
	
}
