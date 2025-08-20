package co.edu.javeriana.ejemplojpa.init;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import co.edu.javeriana.ejemplojpa.model.*;
import co.edu.javeriana.ejemplojpa.repository.*;

@Component
public class DbInitializer implements CommandLineRunner {

    private final JugadorRepository jugadorRepo;
    private final ModeloBarcoRepository modeloRepo;
    private final BarcoRepository barcoRepo;
    private final MapaRepository mapaRepo;
    private final CeldaRepository celdaRepo;

    public DbInitializer(JugadorRepository jugadorRepo, ModeloBarcoRepository modeloRepo,
                         BarcoRepository barcoRepo, MapaRepository mapaRepo, CeldaRepository celdaRepo) {
        this.jugadorRepo = jugadorRepo;
        this.modeloRepo = modeloRepo;
        this.barcoRepo = barcoRepo;
        this.mapaRepo = mapaRepo;
        this.celdaRepo = celdaRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear mapa
        Mapa mapa = new Mapa();
        mapa.setNombre("Mapa Principal");
        mapa.setFilas(10);
        mapa.setColumnas(10);
        mapaRepo.save(mapa);

        // Crear celdas
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Celda celda = new Celda();
                celda.setCoordX(x);
                celda.setCoordY(y);
                if (x == 0 && y == 0) {
                    celda.setTipoCelda("Partida");
                } else if (x == 9 && y == 9) {
                    celda.setTipoCelda("Meta");
                } else if (x == 5) {
                    celda.setTipoCelda("Pared");
                } else {
                    celda.setTipoCelda("Agua");
                }
                celda.setMapa(mapa);
                celdaRepo.save(celda);
            }
        }

        // Crear jugadores
        for (int i = 1; i <= 5; i++) {
            Jugador jugador = new Jugador();
            jugador.setNombre("Jugador " + i);
            jugador.setUsuario("user" + i);
            jugador.setContrasena("pass" + i);
            jugador.setRol("Jugador");
            jugadorRepo.save(jugador);
        }

        // Crear modelos de barco
        for (int i = 1; i <= 10; i++) {
            ModeloBarco modelo = new ModeloBarco();
            modelo.setNombre("Modelo " + i);
            modelo.setColor("Color" + i);
            modeloRepo.save(modelo);
        }

        // Crear barcos
        Random rnd = new Random();
        var jugadores = jugadorRepo.findAll();
        var modelos = modeloRepo.findAll();

        for (Jugador j : jugadores) {
            for (int k = 0; k < 10; k++) {
                Barco barco = new Barco();
                barco.setVelX(0);
                barco.setVelY(0);
                barco.setPosX(0);
                barco.setPosY(0);
                barco.setJugador(j);
                barco.setModelo(modelos.get(rnd.nextInt(modelos.size())));
                barcoRepo.save(barco);
            }
        }
    }
}