package mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller;

import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto.VideoJuegoRequestDTO;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.controller.dto.VideoJuegoResponseDTO;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.model.videoJuego.VideoJuego;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.repository.VideoJuegoRepository;
import mx.edu.utez.zy6r_4E_Angelica_Davalos_CC7.service.VideoJuegoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador")
@CrossOrigin("")
public class VideoJuegoController {

    private final VideoJuegoService videoJuegoService;

    public VideoJuegoController(VideoJuegoService videoJuegoService){
        this.videoJuegoService=videoJuegoService;
    }


}
