package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.asociacion.comerciantes.model.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {
}
