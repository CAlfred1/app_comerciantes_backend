package proyecto.asociacion.comerciantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.MotivoCobroDto;
import proyecto.asociacion.comerciantes.model.UsuarioEntity;
import proyecto.asociacion.comerciantes.service.MotivoCobroService;

import java.util.List;

@RestController
@RequestMapping("/motivo-cobro")
public class MotivoCobroController {

    private final MotivoCobroService motivoCobroService;

    public MotivoCobroController(MotivoCobroService motivoCobroService) {
        this.motivoCobroService = motivoCobroService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MotivoCobroDto>> listar() {
        return ResponseEntity.ok(motivoCobroService.listar());
    }

    @PostMapping("/registrar")
    public ResponseEntity<MotivoCobroDto> registrar(@RequestBody MotivoCobroDto motivoCobroDto) {
        return ResponseEntity.ok(motivoCobroService.registrar(motivoCobroDto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MotivoCobroDto> actualizar(
            @PathVariable Integer id,
            @RequestBody MotivoCobroDto dto) {

        return ResponseEntity.ok(motivoCobroService.actualizar(id, dto));
    }


}