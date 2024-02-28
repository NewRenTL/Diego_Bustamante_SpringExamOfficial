package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Integer> {
    Optional<Pasajero> findByNombre(String nombre);
}
