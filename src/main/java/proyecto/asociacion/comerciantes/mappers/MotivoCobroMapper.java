package proyecto.asociacion.comerciantes.mappers;

import org.mapstruct.Mapper;
import proyecto.asociacion.comerciantes.dto.MotivoCobroDto;
import proyecto.asociacion.comerciantes.model.MotivoCobroEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MotivoCobroMapper {

    MotivoCobroDto toDto(MotivoCobroEntity entity);

    MotivoCobroEntity toEntity(MotivoCobroDto dto);

    List<MotivoCobroDto> toDtoList(List<MotivoCobroEntity> entities);
}