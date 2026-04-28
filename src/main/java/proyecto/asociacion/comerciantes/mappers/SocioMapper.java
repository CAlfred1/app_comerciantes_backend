package proyecto.asociacion.comerciantes.mappers;

import proyecto.asociacion.comerciantes.dto.SocioRequestDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;
import proyecto.asociacion.comerciantes.model.Socio;

public class SocioMapper {

    public static SocioResponseDto toSocioResponseDto(Socio socio) {
        SocioResponseDto responseDto = new SocioResponseDto();
        responseDto.setId(socio.getId());
        responseDto.setNombre(socio.getNombre());
        responseDto.setDni(socio.getDni());
        responseDto.setTelefono(socio.getTelefono());
        responseDto.setEstado(socio.isEstado());

        return responseDto;
    }

    public static Socio toSocio(SocioRequestDto dto) {
        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setDni(dto.getDni());
        socio.setTelefono(dto.getTelefono());
        return socio;
    }
}
