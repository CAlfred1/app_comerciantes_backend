package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proyecto.asociacion.comerciantes.model.ComprobanteEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {

    @Query("SELECT c FROM ComprobanteEntity c " +
            "WHERE c.fecha >= :inicio AND c.fecha < :fin")
    List<ComprobanteEntity> findByRangoFecha(@Param("inicio") LocalDateTime inicio,
                                             @Param("fin") LocalDateTime fin);
}