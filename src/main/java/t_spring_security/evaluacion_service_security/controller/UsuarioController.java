package t_spring_security.evaluacion_service_security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import t_spring_security.evaluacion_service_security.dto.UsuarioRequest;
import t_spring_security.evaluacion_service_security.model.Usuario;
import t_spring_security.evaluacion_service_security.service.UsuarioService;

public class UsuarioController
{
    private UsuarioService usuarioService;

    // API para registrar un usuario con un rol
    @PostMapping("/registrar")
    public String registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.registrarUsuario(
                usuarioRequest.getCodigo(),
                usuarioRequest.getPassword(),
                usuarioRequest.getEmail(),
                usuarioRequest.getRol()
        );
        return "Usuario " + usuario.getCodigo() + " registrado exitosamente con rol " + usuario.getRol();
    }
}

