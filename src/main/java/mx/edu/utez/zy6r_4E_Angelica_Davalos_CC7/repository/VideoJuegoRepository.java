package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.repository;

import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Long> {
    List<VideoJuego> findByDisponibleTrue();

}
