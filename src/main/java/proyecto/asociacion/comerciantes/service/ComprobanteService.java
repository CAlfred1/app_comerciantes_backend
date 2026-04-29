package proyecto.asociacion.comerciantes.service;

import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.ComprobanteDto;
import proyecto.asociacion.comerciantes.dto.DetalleComprobanteDto;
import proyecto.asociacion.comerciantes.model.ComprobanteEntity;
import proyecto.asociacion.comerciantes.mappers.ComprobanteMapper;
import proyecto.asociacion.comerciantes.repository.ComprobanteRepository;
import java.util.NoSuchElementException;


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

        if (comprobanteRepository.existsByNumero(
                comprobanteDto.getNumero().trim())) {

            throw new RuntimeException("El número de comprobante ya existe");
        }

        comprobanteDto.setFecha(LocalDateTime.now());

        for (DetalleComprobanteDto detalle :
                comprobanteDto.getListaDetalle()) {

            detalle.setFechaRegistro(LocalDateTime.now());
        }

        ComprobanteEntity entity =
                comprobanteMapper.toEntity(comprobanteDto);

        comprobanteRepository.save(entity);

        comprobanteDto.setId(entity.getId());

        return comprobanteDto;
    }

    public ComprobanteDto obtenerPorId(Long id) {

        ComprobanteEntity entity =
                comprobanteRepository.findById(id)
                        .orElseThrow(() ->
                                new NoSuchElementException("Comprobante no existe"));

        return comprobanteMapper.toDto(entity);
    }

    public ComprobanteDto actualizar(Long id, ComprobanteDto dto) {

        ComprobanteEntity entity =
                comprobanteRepository.findById(id)
                        .orElseThrow(() ->
                                new NoSuchElementException("Comprobante no existe"));

        entity.setNumero(dto.getNumero());
        entity.setTipo(dto.getTipo());
        entity.setIdPuesto(dto.getIdPuesto());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setTotal(dto.getTotal());
        entity.setVuelto(dto.getVuelto());

        comprobanteRepository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }
}
