package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.services.JugadorService;


@RestController
@RequestMapping("/jugador")
public class JugadorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // GET /jugador/list  -> lista de jugadores
    @GetMapping("/list")
    public ResponseEntity<List<JugadorDTO>> listarJugadores() {
        log.info("GET /jugador/list");
        List<JugadorDTO> jugadores = jugadorService.listarJugadores();
        return ResponseEntity.status(HttpStatus.OK).body(jugadores);
    }

    // GET /jugador/{idJugador}  -> detalle por id
    @GetMapping("{idJugador}")
    public JugadorDTO recuperarJugador(@PathVariable Integer idJugador) {
        log.info("GET /jugador/{}", idJugador);
        return jugadorService.recuperarJugador(idJugador);
    }

    // Crea persona y redirecciona a listado de personas
    @PostMapping
    public JugadorDTO crear(@RequestBody JugadorDTO jugadorDTO) {
        return jugadorService.crearJugador(jugadorDTO);
    }

    
    // Crea persona y redirecciona a listado de personas
    @PutMapping
    public JugadorDTO actualizarJugador(@RequestBody JugadorDTO jugadorDTO, @PathVariable Integer idJugador) {
        return JugadorService.actualizarJugador(jugadorDTO, idJugador);
    }



    @PostMapping("/delete/{idJugador}")
    public RedirectView eliminar(@PathVariable Integer idJugador, RedirectAttributes ra) {
        log.info("Post /jugador/delete/{}", idJugador);
        jugadorService.eliminar(idJugador);
        ra.addFlashAttribute("ok", "Jugador eliminado");
        return new RedirectView("/jugador/list");
    }

 
}
