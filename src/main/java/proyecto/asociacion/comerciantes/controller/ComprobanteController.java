package proyecto.asociacion.comerciantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.service.ComprobanteService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    private ComprobanteService comprobanteService;

    public ComprobanteController(
            ComprobanteService comprobanteServiceSpring) {

        this.comprobanteService =
                comprobanteServiceSpring;
    }
    // LISTAR
    @GetMapping("/listar")
    public ResponseEntity<List<ComprobanteDto>> listar() {
        return ResponseEntity.ok(
                comprobanteService.listar()
        );
    }
    // REGISTRAR
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(
            @RequestBody ComprobanteDto comprobanteDto) {

        try {

            ComprobanteDto dto =
                    comprobanteService.registrar(comprobanteDto);

            return ResponseEntity.ok(dto);

        } catch (RuntimeException ex) {

            return ResponseEntity
                    .status(409)
                    .body(ex.getMessage());
        }
    }

    // ENCONTRAR
    @GetMapping("/{id}")
    public ResponseEntity<ComprobanteDto> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                comprobanteService.obtenerPorId(id)
        );
    }

    // EDITAR
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComprobanteDto> actualizar(
            @PathVariable Long id,
            @RequestBody ComprobanteDto dto) {

        return ResponseEntity.ok(
                comprobanteService.actualizar(id, dto)
        );
    }
}