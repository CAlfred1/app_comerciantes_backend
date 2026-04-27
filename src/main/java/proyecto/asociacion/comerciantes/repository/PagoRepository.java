package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.asociacion.comerciantes.model.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity, Long> {
}
