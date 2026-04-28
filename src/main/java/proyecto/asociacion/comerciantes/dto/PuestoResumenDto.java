package proyecto.asociacion.comerciantes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PuestoResumenDto {
    private Long id;
    private String codigo;
    private String descripcion;
    private boolean estado;
    private boolean esPropiedadAsociacion;
}
