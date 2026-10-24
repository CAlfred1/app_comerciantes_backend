package proyecto.asociacion.comerciantes.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Spring Cloud LoadBalancer (evidencia): agrega a cada respuesta el header
 * X-Instancia con el puerto de la instancia que atendio la peticion.
 * Con dos instancias (9090 y 9091) registradas en Eureka, las peticiones que
 * pasan por el Gateway o por OpenFeign alternan entre ambas.
 */
@Component
public class InstanciaFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(InstanciaFilter.class);

    @Value("${spring.application.name}")
    private String servicio;

    @Value("${server.port}")
    private String puerto;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("X-Instancia", servicio + ":" + puerto);
        log.info("[{}:{}] {} {}", servicio, puerto, request.getMethod(), request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
