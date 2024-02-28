package com.example.Exam1BasicSpring.repository;

import com.example.Exam1BasicSpring.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
