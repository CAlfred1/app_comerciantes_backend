package proyecto.asociacion.comerciantes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoteResumenDto {
    private Long id;
    private String descripcion;
    private LocalDate fecha;
}
