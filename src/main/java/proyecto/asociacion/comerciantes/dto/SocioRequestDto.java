package proyecto.asociacion.comerciantes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocioRequestDto {
    private String nombre;
    private String dni;
    private String telefono;
}

