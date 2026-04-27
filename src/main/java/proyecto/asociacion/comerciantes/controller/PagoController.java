package proyecto.asociacion.comerciantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.dto.PagoDto;
import proyecto.asociacion.comerciantes.service.ComprobanteService;
import proyecto.asociacion.comerciantes.service.PagoService;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {
    private PagoService pagoService;

    public PagoController(PagoService pagoServiceSpring) {
        this.pagoService = pagoServiceSpring;
    }


    @GetMapping("/listar")//get para leer
    public ResponseEntity<List<PagoDto>> listar() {
        return ResponseEntity.ok(pagoService.listar());
    }

    @PostMapping("/registrar")//post para guardar
    public ResponseEntity<PagoDto> registrar(@RequestBody PagoDto pagoDto) {
        return ResponseEntity.ok(pagoService.registrar(pagoDto));
    }
}
