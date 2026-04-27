package proyecto.asociacion.comerciantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.asociacion.comerciantes.model.ComprobanteEntity;

//extends herencia
//JpaRepository metodos consulta, modificacion de Comprobante en base de datos
//repository puede hjacer operaciones con su clase entity
public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {

}
