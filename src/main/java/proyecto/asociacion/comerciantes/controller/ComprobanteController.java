package proyecto.asociacion.comerciantes.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.service.ComprobanteService;

import java.util.List;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {
    private ComprobanteService comprobanteService;//datos de la clase que estan vivos

    public ComprobanteController(ComprobanteService comprobanteServiceSpring) {
        this.comprobanteService = comprobanteServiceSpring;// comprobanteService <- comprobanteServiceSpring
    }


    @GetMapping("/listar")//get para leer
    public ResponseEntity<List<ComprobanteDto>> listar() {
        return ResponseEntity.ok(comprobanteService.listar());
    }

    @PostMapping("/registrar")//post para guardar
    public ResponseEntity<ComprobanteDto> registrar(@RequestBody ComprobanteDto comprobanteDto) {
        return ResponseEntity.ok(comprobanteService.registrar(comprobanteDto));
    }

}