package proyecto.asociacion.comerciantes.service;

import org.springframework.stereotype.Service;

import proyecto.asociacion.comerciantes.dto.PagoDto;
import proyecto.asociacion.comerciantes.model.PagoEntity;
import proyecto.asociacion.comerciantes.mappers.PagoMapper;
import proyecto.asociacion.comerciantes.repository.PagoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoService {
    private PagoRepository pagoRepository;

    private PagoMapper pagoMapper;

    public PagoService(PagoRepository pagoRepository,
                              PagoMapper pagoMapper2
    ) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper2;
    }

    public List<PagoDto> listar(){
        List<PagoEntity> listaEntity = pagoRepository.findAll();
        List<PagoDto> listaDto = pagoMapper.toDtoList(listaEntity);
        return listaDto;
    }

    public PagoDto registrar(PagoDto pagoDto) {
        pagoDto.setFechaRegistro(LocalDateTime.now());

        PagoEntity pagoEntity = pagoMapper.toEntity(pagoDto);
        pagoRepository.save(pagoEntity);
        pagoDto.setId(pagoEntity.getId());
        return pagoDto;
    }
}
