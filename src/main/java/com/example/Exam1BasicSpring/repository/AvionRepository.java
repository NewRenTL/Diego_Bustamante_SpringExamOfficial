package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Integer> {
    Optional<Avion> findByModelo(String modelo);
}
