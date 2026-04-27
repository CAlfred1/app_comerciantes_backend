package proyecto.asociacion.comerciantes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyecto.asociacion.comerciantes.dto.*;
import proyecto.asociacion.comerciantes.model.*;
import proyecto.asociacion.comerciantes.repository.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class DeudaService implements IDeudaService {

    private final IDeudaRepository deudaRepository;
    private final ISocioRepository socioRepository;
    private final IPuestoRepository puestoRepository;
    private final MotivoCobroRepository motivoRepository;
    private final ILoteRepository loteRepository;

    @Override
    public List<DeudaResponseDto> findAll() {
        List<Deuda> lista = deudaRepository.findAll();
        return lista.stream().map(this::toResponseDto).toList();
    }

    @Override
    public DeudaResponseDto findById(Long idDeuda) {
        if (idDeuda == null) {
            throw new IllegalArgumentException("El idDeuda es obligatorio");
        }

        return deudaRepository.findById(idDeuda)
                .map(this::toResponseDto)
                .orElseThrow(() -> new NoSuchElementException("No se encontro la deuda"));
    }

    @Override
    public DeudaResponseDto save(DeudaRequestDto requestDto) {
        if (requestDto == null) {
            throw new IllegalArgumentException("La deuda es obligatoria");
        }

        Deuda deuda = new Deuda();
        applyRequestToDeuda(deuda, requestDto);
        return toResponseDto(deudaRepository.save(deuda));
    }

    @Override
    public DeudaResponseDto update(DeudaRequestDto requestDto, Long idDeuda) {
        if (requestDto == null || idDeuda == null) {
            throw new IllegalArgumentException("Datos de actualizacion incompletos");
        }

        Deuda deudaExistente = deudaRepository.findById(idDeuda)
                .orElseThrow(() -> new NoSuchElementException("No se encontro la deuda"));

        if (deudaExistente.getEstado() == EstadoDeuda.PAGADA) {
            throw new IllegalStateException("No se puede actualizar una deuda pagada");
        }

        applyRequestToDeuda(deudaExistente, requestDto);
        return toResponseDto(deudaRepository.save(deudaExistente));
    }

    @Override
    public void deleteById(Long idDeuda) {
        if (idDeuda == null) {
            throw new IllegalArgumentException("El idDeuda es obligatorio");
        }

        Deuda deuda = deudaRepository.findById(idDeuda)
                .orElseThrow(() -> new NoSuchElementException("No se encontro la deuda"));

        if (deuda.getEstado() == EstadoDeuda.PAGADA) {
            throw new IllegalStateException("No se puede eliminar una deuda pagada");
        }

        deudaRepository.deleteById(idDeuda);
    }

    private void applyRequestToDeuda(Deuda deuda, DeudaRequestDto requestDto) {
        if (requestDto.getIdSocio() == null || requestDto.getIdPuesto() == null || requestDto.getIdMotivo() == null) {
            throw new IllegalArgumentException("idSocio, idPuesto e idMotivo son obligatorios");
        }

        Socio socio = socioRepository.findById(requestDto.getIdSocio())
                .orElseThrow(() -> new NoSuchElementException("No se encontro el socio"));
        Puesto puesto = puestoRepository.findById(requestDto.getIdPuesto())
                .orElseThrow(() -> new NoSuchElementException("No se encontro el puesto"));
        MotivoCobroEntity motivo = motivoRepository.findById(Integer.valueOf(requestDto.getIdMotivo().toString()))
                .orElseThrow(() -> new NoSuchElementException("No se encontro el motivo"));

        Lote lote = null;
        if (requestDto.getIdLote() != null) {
            lote = loteRepository.findById(requestDto.getIdLote())
                    .orElseThrow(() -> new NoSuchElementException("No se encontro el lote"));
        }

        deuda.setSocio(socio);
        deuda.setPuesto(puesto);
        deuda.setMotivo(motivo);
        deuda.setLote(lote);
        deuda.setMonto(requestDto.getMonto());
        deuda.setFecha(requestDto.getFecha());
        deuda.setFechaPago(requestDto.getFechaPago());

        if (requestDto.getEstado() != null) {
            deuda.setEstado(requestDto.getEstado());
        } else if (deuda.getEstado() == null) {
            deuda.setEstado(EstadoDeuda.PENDIENTE);
        }
    }

    private DeudaResponseDto toResponseDto(Deuda deuda) {
        DeudaResponseDto dto = new DeudaResponseDto();
        dto.setId(deuda.getId());
        dto.setSocio(toSocioResponseDto(deuda.getSocio()));
        dto.setPuesto(toPuestoResumenDto(deuda.getPuesto()));
        dto.setMotivo(toMotivoResumenDto(deuda.getMotivo()));
        dto.setLote(toLoteResumenDto(deuda.getLote()));
        dto.setMonto(deuda.getMonto());
        dto.setFecha(deuda.getFecha());
        dto.setEstado(deuda.getEstado());
        dto.setFechaPago(deuda.getFechaPago());
        dto.setFechaCreacion(deuda.getFechaCreacion());
        return dto;
    }

    private SocioResponseDto toSocioResponseDto(Socio socio) {
        if (socio == null) {
            return null;
        }

        SocioResponseDto dto = new SocioResponseDto();
        dto.setId(socio.getId());
        dto.setNombre(socio.getNombre());
        dto.setDni(socio.getDni());
        dto.setTelefono(socio.getTelefono());
        dto.setEstado(socio.isEstado());
        return dto;
    }

    private PuestoResumenDto toPuestoResumenDto(Puesto puesto) {
        if (puesto == null) {
            return null;
        }

        PuestoResumenDto dto = new PuestoResumenDto();
        dto.setId(puesto.getId());
        dto.setCodigo(puesto.getCodigo());
        dto.setDescripcion(puesto.getDescripcion());
        dto.setEstado(puesto.isEstado());
        dto.setEsPropiedadAsociacion(puesto.isEsPropiedad());
        return dto;
    }

    private MotivoCobroDto toMotivoResumenDto(MotivoCobroEntity motivo) {
        if (motivo == null) {
            return null;
        }

        //MotivoResumenDto dto = new MotivoResumenDto();
        MotivoCobroDto dto = new MotivoCobroDto();
        dto.setId(motivo.getId());
        dto.setDescripcion(motivo.getDescripcion());
        return dto;
    }

    private LoteResumenDto toLoteResumenDto(Lote lote) {
        if (lote == null) {
            return null;
        }

        LoteResumenDto dto = new LoteResumenDto();
        dto.setId(lote.getId());
        dto.setDescripcion(lote.getDescripcion());
        dto.setFecha(lote.getFecha());
        return dto;
    }
}
