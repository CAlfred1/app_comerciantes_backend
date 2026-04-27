package proyecto.asociacion.comerciantes.service;

import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.MotivoCobroDto;
import proyecto.asociacion.comerciantes.model.MotivoCobroEntity;
import proyecto.asociacion.comerciantes.mappers.MotivoCobroMapper;
import proyecto.asociacion.comerciantes.repository.MotivoCobroRepository;

import java.util.List;

@Service
public class MotivoCobroService {

    private final MotivoCobroRepository motivoCobroRepository;
    private final MotivoCobroMapper motivoCobroMapper;

    public MotivoCobroService(MotivoCobroRepository motivoCobroRepository,
                              MotivoCobroMapper motivoCobroMapper) {
        this.motivoCobroRepository = motivoCobroRepository;
        this.motivoCobroMapper = motivoCobroMapper;
    }

    public List<MotivoCobroDto> listar() {
        List<MotivoCobroEntity> listaEntity = motivoCobroRepository.findAll();
        return motivoCobroMapper.toDtoList(listaEntity);
    }

    public MotivoCobroDto registrar(MotivoCobroDto motivoCobroDto) {
        MotivoCobroEntity entity = motivoCobroMapper.toEntity(motivoCobroDto);

        motivoCobroRepository.save(entity);

        motivoCobroDto.setId(entity.getId());
        return motivoCobroDto;
    }

    public MotivoCobroDto actualizar(Integer id, MotivoCobroDto dto) {

        MotivoCobroEntity entity = motivoCobroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motivo de cobro no encontrado"));

        // actualizar campos
        entity.setDescripcion(dto.getDescripcion());

        motivoCobroRepository.save(entity);

        return motivoCobroMapper.toDto(entity);
    }


}