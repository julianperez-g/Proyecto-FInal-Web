package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.services.JugadorService;

@Controller
@RequestMapping("/jugador")
public class JugadorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JugadorService jugadorService;

    // http://localhost:8080/jugador/list
    @GetMapping("/list")
    public ModelAndView listarJugadores() {
        log.info("Recibi peticion de listar jugadores");
        ModelAndView modelAndView = new ModelAndView("jugador-list"); 
        List<JugadorDTO> jugadores = jugadorService.listarJugadores();
       modelAndView.addObject("listadoJugadores", jugadores);
        return modelAndView;
    }

    // http://localhost:8080/jugador/view/1
    @GetMapping("/view/{idJugador}")
    public ModelAndView recuperarJugador(@PathVariable Integer idJugador) {
        log.info("Recibi peticion de buscar un jugador");
        ModelAndView mv = new ModelAndView("jugador-view"); 
        JugadorDTO jugador = jugadorService.recuperarJugador(idJugador);
        mv.addObject("jugador", jugador);
        return mv;
    }

     
}
