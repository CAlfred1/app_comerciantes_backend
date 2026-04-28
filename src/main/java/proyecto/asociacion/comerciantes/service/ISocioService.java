package proyecto.asociacion.comerciantes.service;

import proyecto.asociacion.comerciantes.dto.SocioRequestDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;

import java.util.List;
import java.util.Optional;

public interface ISocioService {

    List<SocioResponseDto> findAll();

    SocioResponseDto findById(Long id);

    SocioResponseDto save(SocioRequestDto dto);

    SocioResponseDto update(SocioRequestDto request, Long id);

    SocioResponseDto deleteById(Long id);
}
