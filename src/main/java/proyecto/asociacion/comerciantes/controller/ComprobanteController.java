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

    @GetMapping("/listar")
    public ResponseEntity<List<ComprobanteDto>> listar() {
        return ResponseEntity.ok(
                comprobanteService.listar()
        );
    }

    @PostMapping("/registrar")
    public ResponseEntity<ComprobanteDto> registrar(
            @RequestBody ComprobanteDto comprobanteDto) {

        return ResponseEntity.ok(
                comprobanteService.registrar(
                        comprobanteDto
                )
        );
    }
}