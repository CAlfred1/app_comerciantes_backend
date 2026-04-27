package proyecto.asociacion.comerciantes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.SocioRequestDto;
import proyecto.asociacion.comerciantes.dto.SocioResponseDto;
import proyecto.asociacion.comerciantes.model.Socio;
import proyecto.asociacion.comerciantes.repository.ISocioRepository;
import proyecto.asociacion.comerciantes.mappers.SocioMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SocioService implements ISocioService {
    private final ISocioRepository repository;

    @Override
    public List<SocioResponseDto> findAll() {
        List<Socio> listaSocio = repository.findAll();
        return listaSocio.stream().map(SocioMapper::toSocioResponseDto
        ).toList();
    }

    @Override
    public SocioResponseDto findById(Long id) {
        return repository.findById(id)
                .map(SocioMapper::toSocioResponseDto)
                .orElse(null);
    }

    @Override
    public SocioResponseDto save(SocioRequestDto dto) {
        if(dto!=null){
            Socio socio = SocioMapper.toSocio(dto);
            return SocioMapper.toSocioResponseDto(repository.save(socio));
        }
        return null;
    }

    @Override
    public SocioResponseDto update(SocioRequestDto requestDto, Long id) {
        if (requestDto == null || id == null) {
            return null;
        }

        return repository.findById(id)
                .map(socioExistente -> {
                    Socio socioActualizado = SocioMapper.toSocio(requestDto);
                    socioActualizado.setId(socioExistente.getId());
                    return SocioMapper.toSocioResponseDto(repository.save(socioActualizado));
                })
                .orElse(null);
    }

    @Override
    public SocioResponseDto deleteById(Long id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id)
                .map(socio -> {
                    SocioResponseDto response = SocioMapper.toSocioResponseDto(socio);
                    repository.deleteById(id);
                    return response;
                })
                .orElse(null);
    }
}
