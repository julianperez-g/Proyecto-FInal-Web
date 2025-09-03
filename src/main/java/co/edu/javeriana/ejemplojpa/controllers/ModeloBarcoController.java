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

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.services.ModeloBarcoService;

@Controller
@RequestMapping("/modelobarco")
public class ModeloBarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ModeloBarcoService modeloBarcoService;

    // LISTAR
    @GetMapping("/list")
    public ModelAndView listar() {
        log.info("GET /modelobarco/list");
        ModelAndView mv = new ModelAndView("modelobarco-list");
        List<ModeloBarcoDTO> modelos = modeloBarcoService.listar();
        mv.addObject("listadoModelos", modelos);
        return mv;
    }

    // VER
    @GetMapping("/view/{idModelo}")
    public ModelAndView ver(@PathVariable Integer idModelo) {
        log.info("GET /modelobarco/view/{}", idModelo);
        ModelAndView mv = new ModelAndView("modelobarco-view");
        mv.addObject("modelo", modeloBarcoService.recuperar(idModelo));
        return mv;
    }

    // CREAR (formulario)
   @GetMapping("/new")
public ModelAndView nuevo() {
    System.out.println(">>> GET /modelobarco/new"); 
    ModelAndView mv = new ModelAndView("modelobarco-create"); // coincide con el .html
    mv.addObject("modelo", new ModeloBarcoDTO());            // coincide con th:object="${modelo}"
    return mv;
}


    // CREAR (acción)
    @PostMapping("/create")
    public RedirectView crear(@ModelAttribute("modelo") ModeloBarcoDTO dto, RedirectAttributes ra) {
        log.info("POST /modelobarco/create dto={}", dto);
        ModeloBarcoDTO creado = modeloBarcoService.crear(dto);
        ra.addFlashAttribute("ok", "Modelo de barco creado");
        return new RedirectView("/modelobarco/view/" + creado.getIdModelo());
    }

    // EDITAR (form)
    @GetMapping("/edit/{idModelo}")
    public ModelAndView editar(@PathVariable Integer idModelo) {
        log.info("GET /modelobarco/edit/{}", idModelo);
        ModelAndView mv = new ModelAndView("modelobarco-edit");
        mv.addObject("modelo", modeloBarcoService.recuperar(idModelo));
        return mv;
    }

    // ACTUALIZAR (acción)
    @PostMapping("/update/{idModelo}")
    public RedirectView actualizar(@PathVariable Integer idModelo,
                                   @ModelAttribute("modelo") ModeloBarcoDTO dto,
                                   RedirectAttributes ra) {
        log.info("POST /modelobarco/update/{} dto={}", idModelo, dto);
        modeloBarcoService.actualizar(idModelo, dto);
        ra.addFlashAttribute("ok", "Modelo de barco actualizado");
        return new RedirectView("/modelobarco/view/" + idModelo);
    }

    // ELIMINAR
    @PostMapping("/delete/{idModelo}")
    public RedirectView eliminar(@PathVariable Integer idModelo, RedirectAttributes ra) {
        log.info("POST /modelobarco/delete/{}", idModelo);
        modeloBarcoService.eliminar(idModelo);
        ra.addFlashAttribute("ok", "Modelo de barco eliminado");
        return new RedirectView("/modelobarco/list");
    }

    
}
