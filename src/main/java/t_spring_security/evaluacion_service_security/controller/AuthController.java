package t_spring_security.evaluacion_service_security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t_spring_security.evaluacion_service_security.dto.AuthRequest;
import t_spring_security.evaluacion_service_security.security.JwtTokenUtil;
import t_spring_security.evaluacion_service_security.service.UsuarioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;

    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
        // Autenticación con Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getCodigo(), authRequest.getPassword()));

        // Si la autenticación es exitosa, generamos el token JWT
        //final String token = jwtTokenUtil.generateToken(
        // authRequest.getCodigo(),
        // usuarioService.findByCodigo(authRequest.getCodigo());

        //  return token; // Retornar el token
        return "";
    }
}


