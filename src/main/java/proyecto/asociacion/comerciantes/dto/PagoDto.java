package proyecto.asociacion.comerciantes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.asociacion.comerciantes.model.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class PagoDto {
    private Long id;
    private MetodoPago metodo;
    private BigDecimal montoAcumulado;
    private LocalDateTime fechaRegistro;

    private List<DetallePagoDto> detalles ;

}
