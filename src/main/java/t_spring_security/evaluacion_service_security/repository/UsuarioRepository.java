package t_spring_security.evaluacion_service_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t_spring_security.evaluacion_service_security.model.Usuario;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCodigo(String codigo);

    Usuario registrarUsuario(String codigo, String password, String email, Usuario.Rol rol);

}
