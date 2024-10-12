package t_spring_security.evaluacion_service_security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {
}
