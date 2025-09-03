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

    
String[][] JUGADORES = {
    {"Julián Pérez", "jperez", "1234", "Jugador"},
    {"María Gómez", "mariag", "1234", "Jugador"},
    {"Andrés Torres", "andrest", "1234", "Jugador"},
    {"Luisa Fernández", "luisaf", "1234", "Jugador"},
    {"Jorge Martínez", "jorgem", "1234", "Jugador"}
};

for (String[] datos : JUGADORES) {
    Jugador jugador = new Jugador();
    jugador.setNombre(datos[0]);       // nombre realista
    jugador.setUsuario(datos[1]);      // usuario corto
    jugador.setContrasena(datos[2]);   // contraseña simple
    jugador.setRol(datos[3]);          // rol
    jugadorRepo.save(jugador);
}


        // Crear modelos de barco con nombre y color (nombre + HEX)
String[][] MODELOS = {
    {"Fragata", "Rojo Ferrari (#FF2800)"},
    {"Destructor", "Azul Marino (#003366)"},
    {"Corbeta", "Verde Esmeralda (#2ECC71)"},
    {"Lancha Rápida", "Amarillo Sol (#F1C40F)"},
    {"Acorazado", "Naranja Vela (#E67E22)"},
    {"Portaaviones", "Gris Acero (#7F8C8D)"},
    {"Submarino", "Negro Onix (#111111)"},
    {"Carguero", "Blanco Perla (#FDFEFE)"},
    {"Patrullero", "Cian Caribe (#17A2B8)"},
    {"Catamarán", "Morado Real (#6F42C1)"}
};

for (String[] datos : MODELOS) {
    ModeloBarco modelo = new ModeloBarco();
    modelo.setNombre(datos[0]);   // nombre del modelo
    modelo.setColor(datos[1]);    // color con su HEX
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