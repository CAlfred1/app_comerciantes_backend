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
import java.util.NoSuchElementException;
import java.util.Optional;
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
        if (id == null) {
            throw new IllegalArgumentException("El id es obligatorio");
        }
        return repository.findById(id)
                .map(SocioMapper::toSocioResponseDto)
                .orElseThrow(() -> new NoSuchElementException("No se encontro el socio"));
    }

    @Override
    public SocioResponseDto save(SocioRequestDto dto) {
        if(dto==null){
            throw new IllegalArgumentException("El socio es obligatorio");

        }
        Socio socio = SocioMapper.toSocio(dto);
        return SocioMapper.toSocioResponseDto(repository.save(socio));
    }

    @Override
    public SocioResponseDto update(SocioRequestDto requestDto, Long id) {
        if (requestDto == null || id == null) {
            throw new IllegalArgumentException("Datos de actualizacion incompletos");
        }
        Socio socioExiste = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontro el socio"));

        if(!socioExiste.isEstado()){
            throw new IllegalStateException("Socio no existente");
        }
           Socio socioActualizado = SocioMapper.toSocio(requestDto);
           socioActualizado.setId(socioExiste.getId());

           return SocioMapper.toSocioResponseDto(repository.save(socioActualizado));
    }

    @Override
    public SocioResponseDto deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id es obligatorio");
        }
        Socio socioExiste = repository.findById(id).orElseThrow(() -> new NoSuchElementException("No se encontro el socio"));
        if(socioExiste.isEstado()){
            throw new IllegalStateException("Socio no existente");
        }
        SocioResponseDto response = SocioMapper.toSocioResponseDto(socioExiste);
        repository.deleteById(id);
        return response;

    }
}
