package t_spring_security.evaluacion_service_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import t_spring_security.evaluacion_service_security.model.Usuario;
import t_spring_security.evaluacion_service_security.repository.UsuarioRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<Usuario> findByCodigo(String codigo) {
        return Optional.ofNullable(usuarioRepository.findByCodigo(codigo).orElse(null));

    }

    @Override
    public Usuario registrarUsuario(String codigo, String password, String email, Usuario.Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        usuario.setPassword(passwordEncoder.encode(password)); // Encriptar la contraseña
        usuario.setEmail(email);
        usuario.setRol(rol);
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);    }


}
