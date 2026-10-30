package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.service;

import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto.PrestamoResponseDTO;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto.VideoJuegoRequestDTO;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto.VideoJuegoResponseDTO;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.exception.CustomException;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo.EstadoPrestamo;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo.Prestamo;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego.VideoJuego;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.repository.PrestamoRepository;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.repository.VideoJuegoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VideoJuegoService {

    private final PrestamoRepository prestamoRepository;
    private final VideoJuegoRepository videojuegoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, VideoJuegoRepository videojuegoRepository) {
        this.prestamoRepository = prestamoRepository;
        this.videojuegoRepository = videojuegoRepository;
    }

    public PrestamoResponseDTO crearPrestamo(PrestamoResponseDTO dto) {
        VideoJuego v = videojuegoRepository.findById(dto.getVideojuegoId())
                .orElseThrow(() -> new CustomException("El videojuego no existe"));

        if (!v.isDispoible()) {
            throw new CustomException("El videojuego no esta disponible");
        }

        v.setDisponible(false);
        videojuegoRepository.save(v);

        Prestamo p = new Prestamo();
        p.setVideoJuego(v);
        p.setNombreSolicitante(dto.getNombreSolicitante());
        p.setFechaPrestamo(LocalDateTime.now());
        p.setFechaDevolucion(null);
        p.setEstado(EstadoPrestamo.ACTIVO);

        return mapToDto(prestamoRepository.save(p));
    }

    public PrestamoResponseDTO devolverPrestamoPorVideojuego(Long videojuegoId) {
        if (!videojuegoRepository.existsById(videojuegoId)) {
            throw new CustomException("El videojuego no existe");
        }

        Prestamo p = prestamoRepository.findFirstByVideojuegoIdAndEstado(videojuegoId, EstadoPrestamo.ACTIVO)
                .orElseThrow(() -> new CustomException("No existe un prestamo ACTIVO para este videojuego"));

        p.setEstado(EstadoPrestamo.DEVUELTO);
        p.setFechaDevolucion(LocalDateTime.now());

        VideoJuego v = p.getVideoJuego();
        v.setDisponible(true);
        videojuegoRepository.save(v);

        return mapToDto(prestamoRepository.save(p));
    }

    private PrestamoResponseDTO mapToDto(Prestamo p) {
        return new PrestamoResponseDTO(
                p.getId(),
                p.getNombreSolicitante(),
                p.getFechaPrestamo(),
                p.getFechaDevolucion(),
                p.getEstado(),
                p.getVideojuego().getId(),
                p.getVideojuego().getTitulo()
        );
    }



}
