package co.edu.javeriana.ejemplojpa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.ejemplojpa.dto.BarcoDTO;
import co.edu.javeriana.ejemplojpa.services.BarcoService;

@RestController
@RequestMapping("/barco")
public class BarcoController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final BarcoService barcoService;

    public BarcoController(BarcoService barcoService) {
        this.barcoService = barcoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BarcoDTO>> listarBarcos() {
        log.info("GET /barco/list");
        return ResponseEntity.ok(barcoService.listarBarcos());
    }

    @GetMapping
    public ResponseEntity<List<BarcoDTO>> listarPorJugador(@RequestParam(required = false) Integer jugadorId) {
        if (jugadorId == null) return ResponseEntity.ok(barcoService.listarBarcos());
        log.info("GET /barco?jugadorId={}", jugadorId);
        return ResponseEntity.ok(barcoService.listarPorJugador(jugadorId));
    }

    @GetMapping("{idBarco}")
    public ResponseEntity<BarcoDTO> recuperarBarco(@PathVariable Integer idBarco) {
        log.info("GET /barco/{}", idBarco);
        return ResponseEntity.ok(barcoService.recuperarBarco(idBarco));
    }

    @PostMapping
    public ResponseEntity<BarcoDTO> crear(@RequestBody BarcoDTO barcoDTO) {
        log.info("POST /barco");
        return ResponseEntity.status(HttpStatus.CREATED).body(barcoService.guardar(barcoDTO));
    }

    @PutMapping("{idBarco}")
    public ResponseEntity<BarcoDTO> actualizar(@PathVariable Integer idBarco, @RequestBody BarcoDTO barcoDTO) {
        log.info("PUT /barco/{}", idBarco);
        return ResponseEntity.ok(barcoService.actualizar(idBarco, barcoDTO));
    }

    @DeleteMapping("{idBarco}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idBarco) {
        log.info("DELETE /barco/{}", idBarco);
        barcoService.eliminar(idBarco);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/asignar-a-jugador/{idJugador}")
    public ResponseEntity<Void> asignarModelosAJugador(@PathVariable Integer idJugador,
                                                       @RequestBody List<Integer> modeloIds) {
        log.info("POST /barco/asignar-a-jugador/{}", idJugador);
        barcoService.asignarModelosAJugador(idJugador, modeloIds != null ? modeloIds : List.of());
        return ResponseEntity.noContent().build();
    }
}
