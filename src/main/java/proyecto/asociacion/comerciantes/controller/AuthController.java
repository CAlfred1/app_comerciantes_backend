package proyecto.asociacion.comerciantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.RegistrarUsuarioConRolDto;
import proyecto.asociacion.comerciantes.dto.RegistrarUsuarioDto;
import proyecto.asociacion.comerciantes.model.UsuarioEntity;
import proyecto.asociacion.comerciantes.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // REGISTRAR USUARIO
    @PostMapping("/register")
    public ResponseEntity<UsuarioEntity> registrar(@RequestBody RegistrarUsuarioDto dto) {
        return ResponseEntity.ok(authService.registrar(dto));
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<UsuarioEntity> login(@RequestBody RegistrarUsuarioDto dto) {
        return ResponseEntity.ok(
                authService.login(dto.getUsername(), dto.getPassword())
        );
    }

    // ASIGNAR ROL
    @PostMapping("/asignar-rol")
    public ResponseEntity<UsuarioEntity> asignarRol(
            @RequestParam Integer idUsuario,
            @RequestParam Integer idRol) {

        return ResponseEntity.ok(authService.asignarRol(idUsuario, idRol));
    }

    // REGISTRAR CON ROL
    @PostMapping("/registrar-con-rol")
    public ResponseEntity<UsuarioEntity> registrarConRol(
            @RequestBody RegistrarUsuarioConRolDto dto) {

        return ResponseEntity.ok(authService.registrarConRol(dto));
    }
}