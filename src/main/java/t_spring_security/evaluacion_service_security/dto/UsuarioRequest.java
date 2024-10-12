package t_spring_security.evaluacion_service_security.dto;

import lombok.Getter;
import lombok.Setter;
import t_spring_security.evaluacion_service_security.model.Usuario;

    @Getter
    @Setter
    public class UsuarioRequest {

        private String codigo;
        private String password;
        private String email;
        private Usuario.Rol rol;
}
