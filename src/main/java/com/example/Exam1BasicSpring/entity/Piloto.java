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
@Table(name = "piloto")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "piloto_id"
)
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer piloto_id;


    String nombre;
    String apellido;
    Boolean estado;

    //@OneToMany(mappedBy = "piloto")
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "piloto_vuelo",
            joinColumns = @JoinColumn(
                    name = "piloto_id_fk",
                    referencedColumnName = "piloto_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "vuelo_id_fk",
                    referencedColumnName = "vuelo_id"
            )
    )
    private List<Vuelo> vuelos;

}
