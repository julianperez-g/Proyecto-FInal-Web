package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public JugadorDTO actualizar(@RequestBody JugadorDTO jugadorDTO, @PathVariable Integer idJugador) {
        return jugadorService.actualizarJugador(jugadorDTO, idJugador);
    }



    @DeleteMapping("{idJugador}")
    public void eliminar(@PathVariable Integer idJugador) {
       jugadorService.eliminarJugador(idJugador);
    
    }

 
}
