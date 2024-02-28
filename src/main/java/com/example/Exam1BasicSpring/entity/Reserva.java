package com.example.Exam1BasicSpring.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.Exam1BasicSpring.entity.Avion;

@Entity
@Getter
@Setter
@Table(name = "reserva")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "reserva_id"
)
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reserva_id;


    @ManyToOne
    @JoinColumn(name = "vuelo_id_fk")
    Vuelo vuelo_reserva;

    @ManyToOne
    @JoinColumn(name = "pasajero_id_fk")
    Pasajero pasajero_reserva;

    Integer asientoNumero;

    Boolean estado;
}
