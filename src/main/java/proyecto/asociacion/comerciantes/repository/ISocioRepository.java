package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.asociacion.comerciantes.model.Socio;

@Repository
public interface ISocioRepository extends JpaRepository<Socio, Long> {
}
