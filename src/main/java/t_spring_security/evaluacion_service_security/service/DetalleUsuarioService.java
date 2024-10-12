package t_spring_security.evaluacion_service_security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import t_spring_security.evaluacion_service_security.model.Usuario;
import t_spring_security.evaluacion_service_security.repository.UsuarioRepository;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCodigo(codigo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + codigo));

        return new org.springframework.security.core.userdetails.User(
                usuario.getCodigo(), usuario.getPassword(), Collections.emptyList());

    }  }