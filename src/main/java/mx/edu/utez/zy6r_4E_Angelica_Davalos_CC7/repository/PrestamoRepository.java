package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.repository;

import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo.EstadoPrestamo;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo.Prestamo;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego.VideoJuego;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByEstado(EstadoPrestamo estado);
    List<Prestamo> findByVideojuegoIdAndEstado(Long videojuegoId, EstadoPrestamo estado);
    Optional<Prestamo> findFirstByVideojuegoIdAndEstado(Long videojuegoId, EstadoPrestamo estado);

}
