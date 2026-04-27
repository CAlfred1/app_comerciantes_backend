package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.asociacion.comerciantes.model.MotivoCobroEntity;

public interface MotivoCobroRepository extends JpaRepository<MotivoCobroEntity, Integer> {
}