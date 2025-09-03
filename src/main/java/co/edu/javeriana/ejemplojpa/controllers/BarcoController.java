package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.services.BarcoService;
import co.edu.javeriana.ejemplojpa.services.JugadorService;
import co.edu.javeriana.ejemplojpa.services.ModeloBarcoService;

@Controller
@RequestMapping("/barco")
public class BarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BarcoService barcoService;

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private ModeloBarcoService modeloBarcoService;

    // ---------------------------------------------------------
    // LISTAR
    // http://localhost:8080/barco/list
    // ---------------------------------------------------------
    @GetMapping("/list")
    public ModelAndView listarBarcos() {
        log.info("GET /barco/list");
        ModelAndView mv = new ModelAndView("barco-list");
        List<BarcoDTO> barcos = barcoService.listarBarcos();
        mv.addObject("listadoBarcos", barcos);
        return mv;
    }

    // ---------------------------------------------------------
    // VER DETALLE
    // http://localhost:8080/barco/view/1
    // ---------------------------------------------------------
    @GetMapping("/view/{idBarco}")
    public ModelAndView recuperarBarco(@PathVariable Integer idBarco) {
        log.info("GET /barco/view/{}", idBarco);
        ModelAndView mv = new ModelAndView("barco-view");
        BarcoDTO barco = barcoService.recuperarBarco(idBarco);
        mv.addObject("barco", barco);
        return mv;
    }

    // ---------------------------------------------------------
    // CREAR (FORMULARIO)
    // http://localhost:8080/barco/new
    // ---------------------------------------------------------
    @GetMapping("/new")
    public ModelAndView nuevoBarco() {
        log.info("GET /barco/new");
        ModelAndView mv = new ModelAndView("barco-create");
        mv.addObject("barco", new BarcoDTO());

        // listas para los selects
        List<JugadorDTO> jugadores = jugadorService.listarJugadores();
        List<ModeloBarcoDTO> modelos = modeloBarcoService.listar();
        mv.addObject("jugadores", jugadores);
        mv.addObject("modelos", modelos);

        return mv;
        }

    // ---------------------------------------------------------
    // CREAR (ACCION)
    // POST a /barco/create
    // ---------------------------------------------------------
    @PostMapping("/create")
    public RedirectView crear(@ModelAttribute("barco") BarcoDTO dto, RedirectAttributes ra) {
        log.info("POST /barco/create dto={}", dto);
        BarcoDTO creado = barcoService.crear(dto);
        ra.addFlashAttribute("ok", "Barco creado");
        return new RedirectView("/barco/view/" + creado.getIdBarco());
    }

    // ---------------------------------------------------------
    // EDITAR (FORMULARIO)
    // http://localhost:8080/barco/edit/1
    // ---------------------------------------------------------
    @GetMapping("/edit/{idBarco}")
    public ModelAndView editar(@PathVariable Integer idBarco) {
        log.info("GET /barco/edit/{}", idBarco);
        ModelAndView mv = new ModelAndView("barco-edit");
        mv.addObject("barco", barcoService.recuperarBarco(idBarco));

        // listas para los selects
        List<JugadorDTO> jugadores = jugadorService.listarJugadores();
        List<ModeloBarcoDTO> modelos = modeloBarcoService.listar();
        mv.addObject("jugadores", jugadores);
        mv.addObject("modelos", modelos);

        return mv;
    }

    // ---------------------------------------------------------
    // ACTUALIZAR (ACCION)
    // POST a /barco/update/1
    // ---------------------------------------------------------
    @PostMapping("/update/{idBarco}")
    public RedirectView actualizar(@PathVariable Integer idBarco,
                                   @ModelAttribute("barco") BarcoDTO dto,
                                   RedirectAttributes ra) {
        log.info("POST /barco/update/{} dto={}", idBarco, dto);
        barcoService.actualizar(idBarco, dto);
        ra.addFlashAttribute("ok", "Barco actualizado");
        return new RedirectView("/barco/view/" + idBarco);
    }

    // ---------------------------------------------------------
    // ELIMINAR
    // POST a /barco/delete/1
    // ---------------------------------------------------------
    @PostMapping("/delete/{idBarco}")
    public RedirectView eliminar(@PathVariable Integer idBarco, RedirectAttributes ra) {
        log.info("POST /barco/delete/{}", idBarco);
        barcoService.eliminar(idBarco);
        ra.addFlashAttribute("ok", "Barco eliminado");
        return new RedirectView("/barco/list");
    }

    // Lista de jugadores con botón "Ver barcos"
@GetMapping("/por-jugador")
public ModelAndView barcosPorJugador() {
    ModelAndView mv = new ModelAndView("barcoXjugador");
    mv.addObject("jugadores", jugadorService.listarJugadores());
    return mv;
}

// Pantalla para un jugador: muestra modelos con checkboxes y barcos actuales
@GetMapping("/por-jugador/{idJugador}")
public ModelAndView barcosDeJugador(@PathVariable Integer idJugador) {
    ModelAndView mv = new ModelAndView("barcoXjugador-form");
    mv.addObject("jugador", jugadorService.recuperarJugador(idJugador)); // necesitas JugadorService.recuperar(...)
    mv.addObject("modelos", modeloBarcoService.listar());
    mv.addObject("barcosActuales", barcoService.listarPorJugador(idJugador)); // ver Service abajo
    return mv;
}

// Acción para guardar selección (máx 10)
@PostMapping("/por-jugador/{idJugador}/guardar")
public RedirectView guardarBarcosDeJugador(@PathVariable Integer idJugador,
        @RequestParam(value = "modeloIds", required = false) List<Integer> modeloIds,
        RedirectAttributes ra) {

    if (modeloIds == null) modeloIds = List.of();
    barcoService.asignarModelosAJugador(idJugador, modeloIds); // ver Service abajo
    ra.addFlashAttribute("ok", "Barcos asignados al jugador");
    return new RedirectView("/barco/por-jugador/" + idJugador);
}

}
