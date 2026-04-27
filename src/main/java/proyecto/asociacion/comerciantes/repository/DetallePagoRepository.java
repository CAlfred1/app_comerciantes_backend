package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.asociacion.comerciantes.model.DetallePagoEntity;

public interface DetallePagoRepository extends JpaRepository<DetallePagoEntity, Long> {
}
