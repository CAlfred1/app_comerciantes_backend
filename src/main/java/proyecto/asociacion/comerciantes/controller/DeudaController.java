package proyecto.asociacion.comerciantes.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.service.IDeudaService;
import proyecto.asociacion.comerciantes.dto.DeudaRequestDto;
import proyecto.asociacion.comerciantes.dto.DeudaResponseDto;

@AllArgsConstructor
@RestController
@RequestMapping("/deudas")
public class DeudaController {

    private final IDeudaService deudaService;

    @GetMapping
    public ResponseEntity<?> finAllDeudas() {
        return ResponseEntity.status(HttpStatus.OK).body(deudaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDeudaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(deudaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> registrarDeuda(@Valid @RequestBody DeudaRequestDto requestDto) {
        DeudaResponseDto response = deudaService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDeuda(@PathVariable Long id, @Valid @RequestBody DeudaRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(deudaService.update(requestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDeuda(@PathVariable Long id) {
        deudaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
