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

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.services.BarcoService;

@Controller
@RequestMapping("/barco")
public class BarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BarcoService barcoService;

    // http://localhost:8080/barco/list
    @GetMapping("/list")
    public ModelAndView listarBarcos() {
        log.info("Recibi peticion de listar barcos");
        ModelAndView mv = new ModelAndView("barco-list"); 
        List<BarcoDTO> barcos = barcoService.listarBarcos();
        mv.addObject("listadoBarcos", barcos);
        return mv;
    }

    // http://localhost:8080/barco/view/1
    @GetMapping("/view/{idBarco}")
    public ModelAndView recuperarBarco(@PathVariable int idBarco) {
        log.info("Recibi peticion de buscar un barco: {}", idBarco);
        ModelAndView mv = new ModelAndView("barco-view"); // templates/barco-view.html
        BarcoDTO barco = barcoService.recuperarBarco(idBarco);
        mv.addObject("barco", barco);
        return mv;
    }
}