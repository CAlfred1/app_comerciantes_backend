package proyecto.asociacion.comerciantes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PuestoRequestDto {
    private String codigo;
    private String descripcion;
    private boolean esPropiedad;
    private Long idSocio;
}
