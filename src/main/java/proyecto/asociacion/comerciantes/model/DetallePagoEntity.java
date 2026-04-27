package proyecto.asociacion.comerciantes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="detalle_pago")
public class DetallePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pago")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_comprobante")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ComprobanteEntity comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PagoEntity pago;

}
