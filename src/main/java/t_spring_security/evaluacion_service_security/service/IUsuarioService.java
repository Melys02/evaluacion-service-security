package t_spring_security.evaluacion_service_security.service;

import t_spring_security.evaluacion_service_security.model.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Optional<Usuario> findByCodigo(String codigo);
    Usuario registrarUsuario(String  codigo, String password, String email, Usuario.Rol rol);

}
