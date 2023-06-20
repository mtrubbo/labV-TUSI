package frgp.utn.edu.ar.initializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataInitializer implements InitializingBean  {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
	public DataInitializer(JdbcTemplate dataSource) {
        this.jdbcTemplate = dataSource;
    }

    @PostConstruct
    public void initializeData() {
        try {
            ClassPathResource resource = new ClassPathResource("datainit.sql");
            byte[] scriptBytes = Files.readAllBytes(Paths.get(resource.getURI()));
            String scriptContent = new String(scriptBytes, StandardCharsets.UTF_8);

            jdbcTemplate.execute(scriptContent);
        } catch (IOException e) {
            // Manejar cualquier excepción
        }
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		initializeData();
	}
}

