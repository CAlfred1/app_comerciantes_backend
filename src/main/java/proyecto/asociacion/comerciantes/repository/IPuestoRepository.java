package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.asociacion.comerciantes.model.Puesto;

import java.util.List;

@Repository
public interface IPuestoRepository extends JpaRepository<Puesto, Long> {
    List<Puesto> findBySocioId(Long socioId);
}

