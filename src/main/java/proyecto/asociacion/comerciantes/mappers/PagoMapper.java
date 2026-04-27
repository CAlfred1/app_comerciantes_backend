package proyecto.asociacion.comerciantes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import proyecto.asociacion.comerciantes.dto.PagoDto;
import proyecto.asociacion.comerciantes.model.PagoEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = DetallePagoMapper.class)
public interface PagoMapper {
    @Mapping(target = "detalles", source = "detalles")
    PagoDto toDto(PagoEntity entity);

    @Mapping(target = "detalles", source = "detalles")
    PagoEntity toEntity(PagoDto dto);

    List<PagoDto> toDtoList(List<PagoEntity> entities);
}
