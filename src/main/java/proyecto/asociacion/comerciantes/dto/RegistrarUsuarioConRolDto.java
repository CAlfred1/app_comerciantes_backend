package proyecto.asociacion.comerciantes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class RegistrarUsuarioConRolDto {

    private String username;
    private String password;
    private Integer idRol;
}
