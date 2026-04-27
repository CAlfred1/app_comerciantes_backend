package proyecto.asociacion.comerciantes.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.SocioRequestDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;
import proyecto.asociacion.comerciantes.service.ISocioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/socios")
public class SocioController {
    private final ISocioService service;

    @GetMapping
    public ResponseEntity<?> listarSocios() {
        List<SocioResponseDto> dtos = service.findAll();
        if(!dtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron socios");
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarSocioPorId(@PathVariable Long id) {
        SocioResponseDto dto = service.findById(id);
        Map<String, String> response = new HashMap<>();
        if(dto == null) {
            response.put("Error", "No se encontró el socio con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarSocio(@Valid @RequestBody SocioRequestDto request) {
        SocioResponseDto responseDto = service.save(request);
        if(responseDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se logro registrar el socio ");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSocio(@Valid @RequestBody SocioRequestDto actualizado, @PathVariable Long id) {
        SocioResponseDto buscadoDto = service.findById(id);
        if(buscadoDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el socio con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.update(actualizado, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSocio(@PathVariable Long id) {
        SocioResponseDto deleted = service.deleteById(id);
        if (deleted == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el socio con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Socio eliminado exitosamente: " + deleted.getNombre());
    }
}