package proyecto.asociacion.comerciantes.mappers;

import proyecto.asociacion.comerciantes.dto.PuestoRequestDto;
import proyecto.asociacion.comerciantes.dto.PuestoResponseDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;
import proyecto.asociacion.comerciantes.model.Puesto;

public class PuestoMapper {

    public static PuestoResponseDto toPuestoResponseDto(Puesto puesto) {
        PuestoResponseDto responseDto = new PuestoResponseDto();
        responseDto.setId(puesto.getId());
        responseDto.setCodigo(puesto.getCodigo());
        responseDto.setDescripcion(puesto.getDescripcion());
        responseDto.setEstado(puesto.isEstado());
        responseDto.setEsPropiedad(puesto.isEsPropiedad());

        // Convertir el Socio asociado
        if (puesto.getSocio() != null) {
            responseDto.setSocio(SocioMapper.toSocioResponseDto(puesto.getSocio()));
        }

        return responseDto;
    }

    public static Puesto toPuesto(PuestoRequestDto dto) {
        Puesto puesto = new Puesto();
        puesto.setCodigo(dto.getCodigo());
        puesto.setDescripcion(dto.getDescripcion());
        puesto.setEsPropiedad(dto.isEsPropiedad());
        return puesto;
    }
}
