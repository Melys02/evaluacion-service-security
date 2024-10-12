package t_spring_security.evaluacion_service_security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll() // Permitir acceso a la autenticación
                        .requestMatchers("/api/gestor/**").hasRole("GESTOR") // Permitir solo a GESTOR
                        .requestMatchers("/api/coordinador/**").hasRole("COORDINADOR") // Permitir solo a COORDINADOR
                        .requestMatchers("/api/shared/**").hasAnyRole("GESTOR", "COORDINADOR") // Permitir a ambos roles
                        .anyRequest().authenticated() // Proteger todas las demás rutas
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // No usar sesiones

        // Desactivar CSRF si es necesario
        http.csrf(csrf -> csrf.disable()); // Desactivar CSRF para aplicaciones RESTful

        return http.build();
    }
}

