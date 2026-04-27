package proyecto.asociacion.comerciantes.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.SocioRequestDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;
import proyecto.asociacion.comerciantes.service.ISocioService;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/socios")
public class SocioController {
    private final ISocioService service;

    @GetMapping
    public ResponseEntity<?> listarSocios() {
        List<SocioResponseDto> dtos = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarSocioPorId(@PathVariable Long id) {
        SocioResponseDto dto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarSocio(@Valid @RequestBody SocioRequestDto request) {
        SocioResponseDto responseDto = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSocio(@Valid @RequestBody SocioRequestDto actualizado, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(actualizado, id));
    }
}
