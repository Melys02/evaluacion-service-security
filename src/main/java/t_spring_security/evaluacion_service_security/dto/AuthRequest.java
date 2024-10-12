package t_spring_security.evaluacion_service_security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthRequest {
    private String codigo;
    private String password;
}