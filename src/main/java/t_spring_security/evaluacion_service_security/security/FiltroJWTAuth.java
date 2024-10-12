package t_spring_security.evaluacion_service_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import t_spring_security.evaluacion_service_security.service.DetalleUsuarioService;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
@Service

public class FiltroJWTAuth {
    private final DetalleUsuarioService detalleUsuarioService;
    private final JwtTokenUtil jwtTokenUtil;



    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
            } catch (Exception e) {
                System.out.println("Token inválido");
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
             {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        username, null, Collections.emptyList());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }


    }
}
