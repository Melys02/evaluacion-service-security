package t_spring_security.evaluacion_service_security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import t_spring_security.evaluacion_service_security.service.DetalleUsuarioService;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {
    private final FiltroJWTAuth filtroJWTAuth;

    private final DetalleUsuarioService detalleUsuarioService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detalleUsuarioService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
