package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Piloto;
import com.example.Exam1BasicSpring.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto,Integer> {
    @Query("SELECT p FROM Piloto p WHERE p.nombre =:nombre AND p.apellido =:apellido")
    Optional<Piloto> findByAtributosIguales(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
