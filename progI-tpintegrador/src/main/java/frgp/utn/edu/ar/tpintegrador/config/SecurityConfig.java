package frgp.utn.edu.ar.tpintegrador.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

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
                .defaultSuccessUrl("/clientes.html", true)
                .permitAll()
            .and()
                .oauth2Login()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/?logout")
                .permitAll()
             .and()
             .csrf().disable()
             .sessionManagement()
             .sessionFixation()
             .migrateSession()
             .maximumSessions(1)
//             .maxSessionsPreventsLogin(true)
             .expiredUrl("/login?expired");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
    
}
