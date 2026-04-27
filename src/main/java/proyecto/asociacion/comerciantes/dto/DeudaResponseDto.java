package proyecto.asociacion.comerciantes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.asociacion.comerciantes.model.EstadoDeuda;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeudaResponseDto {
    private Long id;
    private SocioResponseDto socio;
    private PuestoResumenDto puesto;
    private MotivoCobroDto motivo;
    private LoteResumenDto lote;
    private BigDecimal monto;
    private LocalDate fecha;
    private EstadoDeuda estado;
    private LocalDate fechaPago;
    private LocalDateTime fechaCreacion;
}
