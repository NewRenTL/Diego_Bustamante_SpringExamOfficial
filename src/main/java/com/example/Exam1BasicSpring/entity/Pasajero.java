package com.example.Exam1BasicSpring.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pasajero")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "pasajero_id"
)
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer pasajero_id;

    String nombre;

    String apellido;

    Boolean estado;

    @OneToMany(mappedBy = "pasajero_reserva",cascade = CascadeType.ALL)
    List<Reserva> reservas;
}
