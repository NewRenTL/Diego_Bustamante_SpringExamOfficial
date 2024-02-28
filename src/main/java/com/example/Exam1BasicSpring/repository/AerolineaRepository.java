package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea,Integer> {
    Optional<Aerolinea> findByNombre(String name);
}
