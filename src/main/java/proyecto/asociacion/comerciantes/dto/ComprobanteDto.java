package proyecto.asociacion.comerciantes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
//este es el que se devuelve, el entity no sube hasta el controller
public class ComprobanteDto {
    private Long id;

    private String numero;

    private String tipo;

    private Long idPuesto;

    private Long idUsuario;

    private LocalDateTime fecha;

    private BigDecimal total;

    private BigDecimal vuelto;

    private List<DetalleComprobanteDto> listaDetalle;
}
