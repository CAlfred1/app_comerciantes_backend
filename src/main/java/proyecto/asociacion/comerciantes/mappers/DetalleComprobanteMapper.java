package proyecto.asociacion.comerciantes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import proyecto.asociacion.comerciantes.dto.DetalleComprobanteDto;
import proyecto.asociacion.comerciantes.model.DetalleComprobanteEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleComprobanteMapper {
    @Mapping(target = "comprobante", ignore = true)
    DetalleComprobanteDto toDto(DetalleComprobanteEntity entity);

    @Mapping(target = "comprobante", ignore = true)
    DetalleComprobanteEntity toEntity(DetalleComprobanteDto dto);

    List<DetalleComprobanteDto> toDtoList(List<DetalleComprobanteEntity> entities);
}
