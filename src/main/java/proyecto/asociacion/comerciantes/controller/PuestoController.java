package proyecto.asociacion.comerciantes.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.PuestoRequestDto;
import proyecto.asociacion.comerciantes.dto.PuestoResponseDto;
import proyecto.asociacion.comerciantes.service.IPuestoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/puestos")
public class PuestoController {
    private final IPuestoService service;

    @GetMapping
    public ResponseEntity<?> listarPuestos() {
        List<PuestoResponseDto> dtos = service.findAll();
        if (!dtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron puestos");
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPuestoPorId(@PathVariable Long id) {
        PuestoResponseDto dto = service.findById(id);
        Map<String, String> response = new HashMap<>();
        if (dto == null) {
            response.put("Error", "No se encontró el puesto con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/socio/{idSocio}")
    public ResponseEntity<?> listarPuestosPorSocio(@PathVariable Long idSocio) {
        List<PuestoResponseDto> dtos = service.findBySocioId(idSocio);
        if (!dtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron puestos para el socio con ID: " + idSocio);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPuesto(@Valid @RequestBody PuestoRequestDto request) {
        PuestoResponseDto responseDto = service.save(request);
        if (responseDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se logró registrar el puesto. Verifique que el socio exista.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPuesto(@Valid @RequestBody PuestoRequestDto actualizado, @PathVariable Long id) {
        PuestoResponseDto buscadoDto = service.findById(id);
        if (buscadoDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el puesto con ID: " + id);
        }
        PuestoResponseDto updated = service.update(actualizado, id);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se logró actualizar el puesto. Verifique que el socio exista.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPuesto(@PathVariable Long id) {
        PuestoResponseDto deleted = service.deleteById(id);
        if (deleted == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el puesto con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Puesto eliminado exitosamente: " + deleted.getCodigo());
    }
}
