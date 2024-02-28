package com.example.Exam1BasicSpring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "vuelo")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuelo_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "avion_id_fk")
    private Avion avion;

    @Column(name = "fecha_salida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date fechasalida;

    @Column(name = "fecha_llegada")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date fechallegada;

    private Boolean estado;

    @ManyToMany(mappedBy = "vuelos")
    private List<Piloto> pilotos;

    @OneToMany(mappedBy = "vuelo_reserva",cascade =CascadeType.ALL)
    List<Reserva> reservas;


}
