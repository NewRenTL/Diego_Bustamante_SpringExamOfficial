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
@Table(name = "avion")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avion_id")
    private Integer id;

    private String modelo;

    private Integer capacidad_pasajeros;
    //Foreign Key

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id_fk")
    private Aerolinea aerolinea;

    @OneToMany(mappedBy = "avion",cascade = CascadeType.ALL)
    private List<Vuelo> vuelos;

}
