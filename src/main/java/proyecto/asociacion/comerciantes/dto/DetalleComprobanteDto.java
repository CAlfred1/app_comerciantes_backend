package proyecto.asociacion.comerciantes.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleComprobanteDto {
    private Long id;

    private ComprobanteDto comprobante;

    private Long idDeuda;

    private BigDecimal montoPagado;

    private LocalDateTime fechaRegistro;//

}
