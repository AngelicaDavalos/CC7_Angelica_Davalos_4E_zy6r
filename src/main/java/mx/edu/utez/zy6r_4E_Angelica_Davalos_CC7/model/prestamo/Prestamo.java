package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo;

import jakarta.persistence.*;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego.VideoJuego;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreSolicitante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    private  EstadoPrestamo estado;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private VideoJuego videoJuego;
}
