package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="videojuegos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoJuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titulo;
    private  String plataforma;

    private boolean dispoible= true;
}
