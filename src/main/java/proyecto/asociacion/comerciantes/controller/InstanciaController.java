package proyecto.asociacion.comerciantes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Indica que instancia del servicio respondio. Sirve para demostrar el balanceo
 * de carga: GET http://localhost:8080/instancia (a traves del Gateway) responde
 * alternadamente 9090 y 9091.
 */
@RestController
public class InstanciaController {

    @Value("${spring.application.name}")
    private String servicio;

    @Value("${server.port}")
    private String puerto;

    @GetMapping("/instancia")
    public Map<String, Object> instancia() {
        Map<String, Object> datos = new LinkedHashMap<>();
        datos.put("servicio", servicio);
        datos.put("puerto", puerto);
        datos.put("hora", LocalDateTime.now().toString());
        return datos;
    }
}
