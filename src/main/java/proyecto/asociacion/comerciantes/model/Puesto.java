package proyecto.asociacion.comerciantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "puesto", uniqueConstraints = @UniqueConstraint(name = "uq_puesto_codigo", columnNames = "codigo"))
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(length = 100)
    private String descripcion;

    @Column(nullable = false)
    private boolean estado = true;

    @Column(name = "es_propiedad_asociacion", nullable = false)
    private boolean esPropiedad = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_socio", nullable = true)
    private Socio socio;
}
