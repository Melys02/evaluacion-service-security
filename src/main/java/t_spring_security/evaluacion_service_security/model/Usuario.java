package t_spring_security.evaluacion_service_security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String password;

    private String email;
    private Rol rol;
    private boolean activo;


    public enum Rol {
        COORDINADOR, GESTOR
    }
}