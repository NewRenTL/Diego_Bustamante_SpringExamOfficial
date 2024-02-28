package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer> {
    Optional<Vuelo> findByFechasalida(Date d1);
}
