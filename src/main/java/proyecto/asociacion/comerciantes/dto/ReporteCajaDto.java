package proyecto.asociacion.comerciantes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ReporteCajaDto {

    private BigDecimal totalGeneral;

    private Map<String, BigDecimal> totalPorMetodoPago;

    private int cantidadComprobantes;

    private List<ComprobanteDto> comprobantes;
}