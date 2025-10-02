package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.ejemplojpa.dto.ModeloBarcoDTO;
import co.edu.javeriana.ejemplojpa.services.ModeloBarcoService;

@RestController
@RequestMapping("/modelos")
public class ModeloBarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ModeloBarcoService modeloBarcoService;

    public ModeloBarcoController(ModeloBarcoService modeloBarcoService) {
        this.modeloBarcoService = modeloBarcoService;
    }

    // GET /modelos/list -> lista de modelos
    @GetMapping("/list")
    public ResponseEntity<List<ModeloBarcoDTO>> listar() {
        log.info("GET /modelos/list");
        return ResponseEntity.ok(modeloBarcoService.listar());
    }

    // GET /modelos/{idModelo} -> detalle por id
    @GetMapping("{idModelo}")
    public ResponseEntity<ModeloBarcoDTO> recuperar(@PathVariable Integer idModelo) {
        log.info("GET /modelos/{}", idModelo);
        return ResponseEntity.ok(modeloBarcoService.recuperar(idModelo));
    }

    // POST /modelos -> crear
    @PostMapping
    public ResponseEntity<ModeloBarcoDTO> crear(@RequestBody ModeloBarcoDTO modeloBarcoDTO) {
        log.info("POST /modelos");
        ModeloBarcoDTO creado = modeloBarcoService.crear(modeloBarcoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /modelos/{idModelo} -> actualizar
    @PutMapping("{idModelo}")
    public ResponseEntity<ModeloBarcoDTO> actualizar(@PathVariable Integer idModelo,
                                                     @RequestBody ModeloBarcoDTO modeloBarcoDTO) {
        log.info("PUT /modelos/{}", idModelo);
        ModeloBarcoDTO actualizado = modeloBarcoService.actualizar(idModelo, modeloBarcoDTO);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /modelos/{idModelo} -> eliminar
    @DeleteMapping("{idModelo}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idModelo) {
        log.info("DELETE /modelos/{}", idModelo);
        modeloBarcoService.eliminar(idModelo);
        return ResponseEntity.noContent().build();
    }
}
