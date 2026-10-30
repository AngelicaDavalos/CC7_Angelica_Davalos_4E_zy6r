package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.prestamo.EstadoPrestamo;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoResponseDTO {

    private Long id;
    private String nombreSolicitante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    private Long videojuegoId;
    private String tituloVideojuego;
}
