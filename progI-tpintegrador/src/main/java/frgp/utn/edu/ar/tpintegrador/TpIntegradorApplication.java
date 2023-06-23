package frgp.utn.edu.ar.tpintegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import frgp.utn.edu.ar.tpintegrador.config.ViewResolverConfiguration;

@SpringBootApplication
@Import(ViewResolverConfiguration.class)
public class TpIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpIntegradorApplication.class, args);
	}

}
