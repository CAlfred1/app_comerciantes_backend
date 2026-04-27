package proyecto.asociacion.comerciantes.service;

import proyecto.asociacion.comerciantes.dto.PuestoRequestDto;
import proyecto.asociacion.comerciantes.dto.PuestoResponseDto;

import java.util.List;

public interface IPuestoService {

    List<PuestoResponseDto> findAll();

    PuestoResponseDto findById(Long id);

    PuestoResponseDto save(PuestoRequestDto dto);

    PuestoResponseDto update(PuestoRequestDto request, Long id);

    PuestoResponseDto deleteById(Long id);

    List<PuestoResponseDto> findBySocioId(Long socioId);
}