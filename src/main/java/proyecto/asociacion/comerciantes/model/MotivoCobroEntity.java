package proyecto.asociacion.comerciantes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "motivo_cobro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotivoCobroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motivo")
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}