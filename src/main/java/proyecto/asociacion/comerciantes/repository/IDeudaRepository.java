package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.asociacion.comerciantes.model.Deuda;

@Repository
public interface IDeudaRepository extends JpaRepository<Deuda, Long> {
}
