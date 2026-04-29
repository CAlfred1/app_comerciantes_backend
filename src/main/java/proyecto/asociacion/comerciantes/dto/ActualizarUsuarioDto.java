package proyecto.asociacion.comerciantes.dto;

import lombok.*;

@Getter
@Setter
public class ActualizarUsuarioDto {

    private String username;
    private String password;
    private Integer idRol;
    private Boolean estado;
}