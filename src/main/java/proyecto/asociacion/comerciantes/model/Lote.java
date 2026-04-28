package proyecto.asociacion.comerciantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lote_deuda")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Long id;

    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "lote", fetch = FetchType.LAZY)
    private List<Deuda> deudas = new ArrayList<>();
}
