package com.example.Exam1BasicSpring.service;

import com.example.Exam1BasicSpring.Response.ResponseBase;
import com.example.Exam1BasicSpring.entity.Reserva;
import com.example.Exam1BasicSpring.entity.Vuelo;
import com.example.Exam1BasicSpring.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VueloService {

    @Autowired
    VueloRepository vueloRepository;

    public ResponseBase saveVuelo(Vuelo vuelo)
    {
        Optional<Vuelo> vuelo1 = vueloRepository.findByFechasalida(vuelo.getFechasalida());
        if(vuelo1.isPresent())
        {
            return new ResponseBase(400,"Vuelo "+(Integer.toString(vuelo1.get().getId()))+" ya existe",false,Optional.empty());
        }

        return new ResponseBase(201,"Vuelo creado",true,Optional.of(vueloRepository.save(vuelo)));
    }
    public ResponseBase findVueloById(Integer id)
    {
        Optional<Vuelo> vuelo = vueloRepository.findById(id);
        if(vuelo.isPresent())
        {
            return new ResponseBase(200,"Vuelo encontrado",true,vuelo);
        }
        return new ResponseBase(404,"No se ha encontrado",false,Optional.empty());
    }
}
