package co.edu.javeriana.ejemplojpa.controllers;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.services.ModeloBarcoService;

@Controller
@RequestMapping("/modelobarco")
public class ModeloBarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ModeloBarcoService modeloBarcoService;

    // http://localhost:8080/modelobarco/list
    @GetMapping("/list")
    public ModelAndView listarModelos() {
        log.info("GET /modelobarco/list");
        ModelAndView mv = new ModelAndView("modelobarco-list"); 
        List<ModeloBarcoDTO> modelos = modeloBarcoService.listar();
        mv.addObject("listadoModelos", modelos);
        return mv;
    }

    // http://localhost:8080/modelobarco/view/1
    @GetMapping("/view/{idModelo}")
    public ModelAndView verModelo(@PathVariable int idModelo) {
        log.info("GET /modelobarco/view/{}", idModelo);
        ModelAndView mv = new ModelAndView("modelobarco-view"); // templates/modelobarco-view.html
        ModeloBarcoDTO dto = modeloBarcoService.recuperar(idModelo);
        mv.addObject("modeloBarco", dto);
        return mv;
    }
}

