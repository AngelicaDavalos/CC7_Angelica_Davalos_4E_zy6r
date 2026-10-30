package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoJuegoResponseDTO {
    private Long id;
    private String titulo;
    private String plataforma;
    private boolean disponible;
}
