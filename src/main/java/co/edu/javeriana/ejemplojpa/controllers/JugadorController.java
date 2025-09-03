package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.services.JugadorService;


@Controller
@RequestMapping("/jugador")
public class JugadorController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // ---------------------------------------------------------
    // LISTAR
    // http://localhost:8080/jugador/list
    // ---------------------------------------------------------
    @GetMapping("/list")
    public ModelAndView listarJugadores() {
        log.info("GET /jugador/list");
        ModelAndView mv = new ModelAndView("jugador-list");
        List<JugadorDTO> jugadores = jugadorService.listarJugadores();
        mv.addObject("listadoJugadores", jugadores);
        return mv;
    }

    // ---------------------------------------------------------
    // VER DETALLE
    // http://localhost:8080/jugador/view/1
    // ---------------------------------------------------------
    @GetMapping("/view/{idJugador}")
    public ModelAndView recuperarJugador(@PathVariable Integer idJugador) {
        log.info("GET /jugador/view/{}", idJugador);
        ModelAndView mv = new ModelAndView("jugador-view");
        JugadorDTO jugador = jugadorService.recuperarJugador(idJugador);
        mv.addObject("jugador", jugador);
        return mv;
    }

    // ---------------------------------------------------------
    // CREAR (form vacío)
    // http://localhost:8080/jugador/create
    // ---------------------------------------------------------
    @GetMapping("/create")
    public ModelAndView nuevo() {
        log.info("GET /jugador/create");
        ModelAndView mv = new ModelAndView("jugador-create");
        mv.addObject("jugador", new JugadorDTO());
        mv.addObject("modo", "crear");
        return mv;
    }

    // ---------------------------------------------------------
    // GUARDAR (submit de creación)
    // POST a /jugador/save
    // ---------------------------------------------------------
    @PostMapping("/save")
    public String guardar(@ModelAttribute("jugador") JugadorDTO dto,
                          RedirectAttributes ra) {
        log.info("POST /jugador/save -> {}", dto.getNombre());
        JugadorDTO saved = jugadorService.guardar(dto);
        ra.addFlashAttribute("ok", "Jugador creado con id " + saved.getIdJugador());
        return "redirect:/jugador/list";
    }

    // ---------------------------------------------------------
    // EDITAR (cargar form con datos)
    // http://localhost:8080/jugador/edit/1
    // ---------------------------------------------------------
    @GetMapping("/edit/{idJugador}")
    public ModelAndView editar(@PathVariable Integer idJugador) {
        log.info("GET /jugador/edit/{}", idJugador);
        ModelAndView mv = new ModelAndView("jugador-edit");
        mv.addObject("jugador", jugadorService.recuperarJugador(idJugador));
        mv.addObject("modo", "editar");
        return mv;
    }

    // ---------------------------------------------------------
    // ACTUALIZAR (submit de edición)
    // POST a /jugador/update/1
    // ---------------------------------------------------------
    @PostMapping("/update/{idJugador}")
    public String actualizar(@PathVariable Integer idJugador,
                             @ModelAttribute("jugador") JugadorDTO dto,
                             RedirectAttributes ra) {
        log.info("POST /jugador/update/{}", idJugador);
        jugadorService.actualizar(idJugador, dto);
        ra.addFlashAttribute("ok", "Jugador actualizado correctamente");
        return "redirect:/jugador/view/" + idJugador;
    }

    // ---------------------------------------------------------
    // ELIMINAR
    // POST a /jugador/delete/1
    // ---------------------------------------------------------
    @PostMapping("/delete/{idJugador}")
    public RedirectView eliminar(@PathVariable Integer idJugador, RedirectAttributes ra) {
        log.info("Post /jugador/delete/{}", idJugador);
        jugadorService.eliminar(idJugador);
        ra.addFlashAttribute("ok", "Jugador eliminado");
        return new RedirectView("/jugador/list");
    }

 
}
