package proyecto.asociacion.comerciantes.service;

import proyecto.asociacion.comerciantes.dto.DeudaRequestDto;
import proyecto.asociacion.comerciantes.dto.DeudaResponseDto;

import java.util.List;

public interface IDeudaService {

    List<DeudaResponseDto> findAll();

    //Page<DeudaResponseDto> findAll(Integer page, Integer size, Long idSocio, Long idPuesto, EstadoDeuda estado, LocalDate fechaDesde, LocalDate fechaHasta);

    DeudaResponseDto findById(Long id);

    DeudaResponseDto save(DeudaRequestDto requestDto);

    DeudaResponseDto update(DeudaRequestDto requestDto, Long id);

    void deleteById(Long id);
}
