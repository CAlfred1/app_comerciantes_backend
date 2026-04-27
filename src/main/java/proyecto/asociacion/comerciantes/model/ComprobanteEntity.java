package proyecto.asociacion.comerciantes.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="comprobante")
public class ComprobanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "id_puesto")
    private Long idPuesto;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "vuelto")
    private BigDecimal vuelto;

    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleComprobanteEntity> detalles = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getVuelto() {
        return vuelto;
    }

    public void setVuelto(BigDecimal vuelto) {
        this.vuelto = vuelto;
    }


    public ComprobanteEntity(Long id, String numero, String tipo, Long idPuesto, Long idUsuario, LocalDateTime fecha, BigDecimal total, BigDecimal vuelto) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.idPuesto = idPuesto;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.total = total;
        this.vuelto = vuelto;
    }

    public ComprobanteEntity() {
    }

    public List<DetalleComprobanteEntity> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleComprobanteEntity> detalles) {
        this.detalles.clear();
        if (detalles != null) {
            for (DetalleComprobanteEntity detalle : detalles) {
                detalle.setComprobante(this);
                this.detalles.add(detalle);
            }
        }
    }
}

