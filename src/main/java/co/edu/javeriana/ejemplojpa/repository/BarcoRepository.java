package co.edu.javeriana.ejemplojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.ejemplojpa.model.Barco;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Integer> {
    
}