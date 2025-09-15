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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import co.edu.javeriana.ejemplojpa.dto.JugadorDTO;
import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.services.ModeloBarcoService;

@RestController
@RequestMapping("/modelos")
public class ModeloBarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ModeloBarcoService modeloBarcoService;

   // GET /modelos/list  -> lista de jugadores
    @GetMapping("/list")
     public ResponseEntity<List<ModeloBarcoDTO>> listar() {
        log.info("GET /modelobarco/list");
        List<ModeloBarcoDTO> modelos = modeloBarcoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(modelos);
    }

    // GET /modelos/{idJugador}  -> detalle por id
    @GetMapping("{idModelo}")
    public ModeloBarcoDTO recuperar(@PathVariable Integer idModelo) {
        log.info("GET /{idModelo}", idModelo);
        return modeloBarcoService.recuperar(idModelo);
    }

    // Crea persona y redirecciona a listado de personas
    @PostMapping
    public ModeloBarcoDTO crear(@RequestBody ModeloBarcoDTO modeloBarcoDTO){
        return modeloBarcoService.crearModelo(modeloBarcoDTO);    
    }
    
    // Crea persona y redirecciona a listado de personas
    @PutMapping
    public ModeloBarcoDTO actualizar(@PathVariable Integer idModelo, @RequestBody ModeloBarcoDTO modeloBarcoDTO) {
        return modeloBarcoService.actualizarModelo(idModelo, modeloBarcoDTO );
    }
   

    @DeleteMapping("{idModelo}")
    public void eliminar(@PathVariable Integer idModelo) {
        modeloBarcoService.eliminar(idModelo);
    }

    
}
