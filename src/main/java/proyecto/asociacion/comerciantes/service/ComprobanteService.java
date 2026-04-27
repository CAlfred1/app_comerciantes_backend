package proyecto.asociacion.comerciantes.service;

import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.dto.DetalleComprobanteDto;
import proyecto.asociacion.comerciantes.model.ComprobanteEntity;
import proyecto.asociacion.comerciantes.mappers.ComprobanteMapper;
import proyecto.asociacion.comerciantes.repository.ComprobanteRepository;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComprobanteService {
    //inyeccion de dependencias crea una clase desde otro lado y lo hace Spring
    private ComprobanteRepository comprobanteRepository;

    private ComprobanteMapper comprobanteMapper;

    //segunda forma de instanciar automaticamente con spring Inyector de dependencias
    //autowired es algo mas lento
    public ComprobanteService(ComprobanteRepository comprobanteRepository,
                              ComprobanteMapper comprobanteMapper2
                              ) {
        this.comprobanteRepository = comprobanteRepository;
        this.comprobanteMapper = comprobanteMapper2;
    }

    public List<ComprobanteDto> listar(){
        List<ComprobanteEntity> listaEntity = comprobanteRepository.findAll();//encontrar todo en bd
        List<ComprobanteDto> listaDto = comprobanteMapper.toDtoList(listaEntity);//convertir una listaEntity a una listaDto
        return listaDto;
    }

    public ComprobanteDto registrar(ComprobanteDto comprobanteDto) {
        comprobanteDto.setFecha(LocalDateTime.now());
        for(DetalleComprobanteDto detalleComprobanteDto: comprobanteDto.getListaDetalle()) {
            detalleComprobanteDto.setFechaRegistro(LocalDateTime.now());
        }
        ComprobanteEntity comprobanteEntity = comprobanteMapper.toEntity(comprobanteDto);
        comprobanteRepository.save(comprobanteEntity);// aca se va a crear un id!
        comprobanteDto.setId(comprobanteEntity.getId());
        return comprobanteDto;
    }
}
