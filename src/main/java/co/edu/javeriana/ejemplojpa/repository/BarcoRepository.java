package co.edu.javeriana.ejemplojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.ejemplojpa.model.Barco;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Integer> {
    List<Barco> findByJugador_IdJugador(Integer idJugador);
    void deleteByJugador_IdJugador(Integer idJugador);
}
