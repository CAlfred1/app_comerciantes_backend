package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.asociacion.comerciantes.model.Lote;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Long> {
}
