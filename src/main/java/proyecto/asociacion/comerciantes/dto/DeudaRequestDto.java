package proyecto.asociacion.comerciantes.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyecto.asociacion.comerciantes.model.EstadoDeuda;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeudaRequestDto {
    @NotNull
    private Long idSocio;

    @NotNull
    private Long idPuesto;

    @NotNull
    private Long idMotivo;

    private Long idLote;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal monto;

    @NotNull
    private LocalDate fecha;

    private EstadoDeuda estado;

    private LocalDate fechaPago;
}
