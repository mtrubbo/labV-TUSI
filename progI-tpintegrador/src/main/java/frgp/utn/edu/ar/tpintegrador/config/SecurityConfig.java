package frgp.utn.edu.ar.tpintegrador.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// Configuración específica de Spring Security
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/css/**", "/js/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/")
                .defaultSuccessUrl("/clientes", true)
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
             .and()
             .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }
    
/*  Paso 3: Configurar URLs y permisos
    Aquí, al igual que antes, debes definir las reglas de autorización para diferentes URLs de 
    tu aplicación en el método configure(HttpSecurity http) de la clase de configuración. Personaliza 
    las reglas según tus necesidades. */

/*  Paso 4: Configurar usuarios y roles
    Al igual que antes, configura los usuarios y roles para la autenticación en el método 
    configure(AuthenticationManagerBuilder auth) de la clase de configuración. */
    
/*  Paso 5: Integración con Spring MVC
    En tu configuración de Spring MVC, asegúrate de incluir la configuración de Spring Security mediante
    la anotación @Import(SecurityConfig.class). Esto asegurará que Spring MVC y Spring Security estén 
    correctamente integrados. */
}
