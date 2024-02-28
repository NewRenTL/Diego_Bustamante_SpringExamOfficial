package com.example.Exam1BasicSpring.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.Exam1BasicSpring.entity.Avion;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "aerolinea")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "aerolinea_id"
)
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aerolinea_id")
    Integer aerolinea_id;

    String nombre;

    Boolean estado;

    @OneToMany(mappedBy = "aerolinea",cascade = CascadeType.ALL)
    List<Avion> aviones;
}
