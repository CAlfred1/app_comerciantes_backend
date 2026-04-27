package proyecto.asociacion.comerciantes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.model.ComprobanteEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = DetalleComprobanteMapper.class)
public interface ComprobanteMapper {
    @Mapping(target = "listaDetalle", source = "detalles")
    ComprobanteDto toDto(ComprobanteEntity entity);

    @Mapping(target = "detalles", source = "listaDetalle")
    ComprobanteEntity toEntity(ComprobanteDto dto);

    List<ComprobanteDto> toDtoList(List<ComprobanteEntity> entities);
}
