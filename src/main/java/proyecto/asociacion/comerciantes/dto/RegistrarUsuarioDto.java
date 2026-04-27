package proyecto.asociacion.comerciantes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrarUsuarioDto {

    private String username;
    private String password;
}