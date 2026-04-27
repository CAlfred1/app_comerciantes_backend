package proyecto.asociacion.comerciantes.service;

import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.RegistrarUsuarioConRolDto;
import proyecto.asociacion.comerciantes.dto.RegistrarUsuarioDto;
import proyecto.asociacion.comerciantes.model.RolEntity;
import proyecto.asociacion.comerciantes.model.UsuarioEntity;
import proyecto.asociacion.comerciantes.repository.UsuarioRepository;
import proyecto.asociacion.comerciantes.repository.RolRepository;

import java.util.ArrayList;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public AuthService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    // REGISTRO
    public UsuarioEntity registrar(RegistrarUsuarioDto dto) {

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword()); // luego BCrypt
        usuario.setEstado(true);

        return usuarioRepository.save(usuario);
    }

    // LOGIN
    public UsuarioEntity login(String username, String password) {

        UsuarioEntity usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Password incorrecto");
        }

        return usuario;
    }

    // ASIGNAR ROL
    public UsuarioEntity asignarRol(Integer idUsuario, Integer idRol) {

        UsuarioEntity usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        RolEntity rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no existe"));

        usuario.getRoles().add(rol);

        return usuarioRepository.save(usuario);
    }

    // REGISTRAR USUARIO CON ROL
    public UsuarioEntity registrarConRol(RegistrarUsuarioConRolDto dto) {

        // 1. Crear usuario
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEstado(true);

        // 2. Buscar rol
        RolEntity rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no existe"));

        // 3. Asignar rol
        usuario.setRoles(new ArrayList<>());
        usuario.getRoles().add(rol);

        // 4. Guardar todo
        return usuarioRepository.save(usuario);
    }
}