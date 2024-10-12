package t_spring_security.evaluacion_service_security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {
    private final String SECRET_KEY = "t2vi2024";

    // Generar token JWT
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3)) // Expira en 3 minutos
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
