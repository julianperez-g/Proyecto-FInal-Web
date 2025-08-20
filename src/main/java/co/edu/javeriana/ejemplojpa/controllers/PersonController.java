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

import co.edu.javeriana.ejemplojpa.dto.PersonDTO;
import co.edu.javeriana.ejemplojpa.services.PersonService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonService personService;

    // http://localhost:8080/person/list
    // @RequestMapping(value="/person/list", method=RequestMethod.GET)
    @GetMapping("/list")
    public ModelAndView listarPersonas() {
        log.info("Recibi peticion de listar persona");
        ModelAndView modelAndView = new ModelAndView("person-list");
        List<PersonDTO> personas = personService.listarPersonas();
        modelAndView.addObject("listadoPersonas", personas);
        return modelAndView;
    }
    
    
    // http://localhost:8080/person/view/1
    @GetMapping("/view/{idPersona}")
    public ModelAndView recuperarPersona(@PathVariable Long idPersona) {
        log.info("Recibi peticion de buscar una persona");
        ModelAndView modelAndView = new ModelAndView("person-view");
        PersonDTO persona = personService.recuperarPersona(idPersona);
        modelAndView.addObject("persona", persona);
        return modelAndView;
    }

}
