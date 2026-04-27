package proyecto.asociacion.comerciantes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pago")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo")
    private MetodoPago metodo;

    @Column(name = "monto_acumulado")
    private BigDecimal montoAcumulado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetallePagoEntity> detalles = new ArrayList<>();

    public void setDetalles(List<DetallePagoEntity> detalles) {
        this.detalles.clear();
        if (detalles != null) {
            for (DetallePagoEntity detalle : detalles) {
                detalle.setPago(this);
                this.detalles.add(detalle);
            }
        }
    }
}
